/**
Student Name - Sasi Vallikkat
Course - I&C SCI_X460.10/LEC/1(WINTER 2015,UNEX,00113)
Project E Team
**/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Registration {

HashMap<String, Course> courseMAP ;   // implemented for faster retrieval using key value pair currently not using
HashMap<String, Student> studentMAP ; // implemented for faster retrieval using key value pair currently not using


ArrayList<Student> studentList;
ArrayList<Course> courseList;

public Registration() {
	loadStudents();
	loadCourses();
}


public boolean registerCourse(String studentID,String courseNumber)
{
  try{

   if ( isRegistered (studentID, courseNumber) == false)

   {
	    for ( Student student: studentList )
	    {
	   	   	 if ( student.getSSN().trim().equals(studentID.trim()) )
	         {
				   if ( student.addCourse(courseNumber.trim()))
				   {
						for ( Course course: courseList ){
					  	 if ( course.getNumber().trim().equals(courseNumber.trim()) ){
		 				      return course.addStudent(studentID.trim());
		 		          }
                        }
			 	   }
		     }
         }

   }
}
catch ( Exception e ){
e.printStackTrace();
}

   return false;
}//end method


public boolean unregisterCourse(String studentID,String courseNumber)
{
  try{

   if ( isRegistered (studentID, courseNumber) == true)

   {
	    for ( Student student: studentList )
	    {
	   	   	 if ( student.getSSN().trim().equals(studentID.trim()) )
	         {
				   if ( student.removeCourse(courseNumber.trim()))
				   {
						for ( Course course: courseList ){
					  	 if ( course.getNumber().trim().equals(courseNumber.trim()) ){
		 				      return course.removeStudent(studentID.trim());
		 		          }
                        }
			 	   }
		     }
         }

   }
}
catch ( Exception e ){
e.printStackTrace();
}

   return false;
}//end method


public Boolean isRegistered (String studentID , String courseNumber){

 int flag = 0;
 boolean stuFound = false;

 for ( Student student: studentList )
 {

	 if ( student.getSSN().trim().equals(studentID.trim()) )
	 {
		 stuFound = true;
		 for ( int i=0 ; i < student.myCourseIDs.size(); i++)
		 {

			 if ( student.myCourseIDs.get(i).trim().equals(courseNumber.trim()) )
			 {
				 flag = 1;
			 }
		 }
	 }
 }

 if ( stuFound == false )
 {
	 throw new IllegalArgumentException("StudentID not in the system");
 }

 if (flag == 1)
 {
   return true;
 }
  return false;

}


public void loadStudents(){
 studentList = new ArrayList<Student>();
 studentMAP = new HashMap<String,Student>();

 try{

    File studentFile = new File("Students.txt");
	Scanner fileScanner = new Scanner(studentFile);
	String [] studentAttributes;
	Student tmpStudentObject ;

  while(fileScanner.hasNextLine()){
	studentAttributes = fileScanner.nextLine().split(",");
    tmpStudentObject = new Student(studentAttributes[0].trim(), studentAttributes[1].trim(), new Integer(studentAttributes[2].trim()).intValue(),studentAttributes[3].trim().charAt(0),studentAttributes[4]);

    //System.out.println(studentAttributes[3].trim().charAt(0));
    //System.out.println(tmpStudentObject.getGender());

    if (studentAttributes.length > 5)
	{
		//its the reference to course, create course class and add it to the student course arraylist
	    for (int i = 5; i < studentAttributes.length; i++)
	    {
			tmpStudentObject.myCourseIDs.add(studentAttributes[i]);

		}//end for
	}//end if
	studentList.add(tmpStudentObject);
	studentMAP.put(tmpStudentObject.getSSN(),tmpStudentObject);


  }//end while
  fileScanner.close();
}//end try
catch(FileNotFoundException e){
	e.printStackTrace();
	}//end catch
}


public void listCourses() {

	for ( Course course: courseList ) {

		course.listCourseDetails();

    }

}

public void loadCourses(){

 courseList = new ArrayList<Course>();
 courseMAP = new HashMap<String,Course>();

 try{

    File courseFile = new File("Courses.txt");
	Scanner fileScanner = new Scanner(courseFile);
	String [] courseAttributes;
	Course tmpCourseObject ;

  while(fileScanner.hasNextLine()){
	courseAttributes = fileScanner.nextLine().split(",");
    tmpCourseObject = new Course( courseAttributes[1].trim(), courseAttributes[0].trim(), courseAttributes[2].trim(),courseAttributes[3].trim(),courseAttributes[4].trim(),new Integer(courseAttributes[5].trim()).intValue());

    //System.out.println(courseAttributes[3].trim());
    //System.out.println(courseAttributes[4].trim());

    //System.out.println(tmpCourseObject.getStartDate());


    if (courseAttributes.length > 6)
	{
		//its the reference to course, create course class and add it to the student course arraylist
	    for (int i = 6; i < courseAttributes.length; i++)
	    {
			tmpCourseObject.myStudentIDs.add(courseAttributes[i]);

		}//end for
	}//end if
	courseList.add(tmpCourseObject);
    courseMAP.put(tmpCourseObject.getNumber(),tmpCourseObject);

  }//end while

 fileScanner.close();
}//end try
catch(FileNotFoundException e){
	e.printStackTrace();
	}//end catch
}

public void saveToFile()
{
	File studentFile;
	File courseFile;
	PrintWriter writeToFile;
    try{

	courseFile = new File("courses.txt");
    writeToFile = new PrintWriter(courseFile);
	String tmpArray = ",";

	for ( Course course: courseList ){

     if (course.myStudentIDs.size() > 0)
     {
		 for (String sID:course.myStudentIDs)
		 {
			 tmpArray = tmpArray + sID + "," ;
		 }

	 }
	 tmpArray.substring(0, tmpArray.length() - 1 );
     writeToFile.println(course.getName().trim() + ',' + course.getNumber().trim() + ',' + course.getDescription().trim() + ',' + course.getStartDate().trim() + ',' + course.getEndDate().trim() + ',' + new Integer(course.getMaxEnrollment()).toString().trim().toString() + tmpArray );
     tmpArray = ",";

    }//end for
      writeToFile.close();
    }//end try
	catch(FileNotFoundException e){
    e.printStackTrace();
    }
    catch(Exception e){
    e.printStackTrace();
    }


   // Save Students to File

   try{

   	studentFile = new File("students.txt");
       writeToFile = new PrintWriter(studentFile);
   	String tmpArray = ",";

   	for ( Student student: studentList ){

        if (student.myCourseIDs.size() > 0)
        {
   		 for (String cID:student.myCourseIDs)
   		 {
   			 tmpArray = tmpArray + cID + "," ;
   		 }

   	 }

   	    tmpArray.substring(0, tmpArray.length() - 1 );
        writeToFile.println(student.getFirstName().trim() + ',' + student.getLastName().trim() + ',' + new Integer(student.getAge()).toString().trim() + ',' +  String.valueOf(student.getGender()) + ',' + student.getSSN() + tmpArray );
        tmpArray = ",";

       }//end for
         writeToFile.close();
       }//end try
   	catch(FileNotFoundException e){
       e.printStackTrace();
       }
       catch(Exception e){
       e.printStackTrace();
       }


}

}
/**
Student Name - Sasi Vallikkat
Course - I&C SCI_X460.10/LEC/1(WINTER 2015,UNEX,00113)
Project E Team
**/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RegistrationTest {

public static void main ( String[] args )
{
    Registration tmpReg = new Registration();


    System.out.println("Student ArrayList Size =" + tmpReg.studentList.size());

    for ( Student student : tmpReg.studentList)
    {
	      System.out.println(student.talk() + "," +  student.getGender() );
	      System.out.println("The Courses i enrolled ");

	      for ( String courseID : student.myCourseIDs)
	      {
			  System.out.println(courseID);
		  }
	}

    System.out.println("Course ArrayList Size =" + tmpReg.courseList.size());

	for ( Course course : tmpReg.courseList)
	    {
		      System.out.println(course.getName() + "," + course.getNumber() + "," + course.getDescription() + "," + course.getStartDate() + "," + course.getEndDate() + "," + course.getMaxEnrollment() );
		      System.out.println("The Students enrolled ");

		      for ( String studentID : course.myStudentIDs)
		      {
				  System.out.println(studentID);
			  }
	}

        System.out.println("After New Registration");

        if (tmpReg.registerCourse("666-66-6666","SCI425.70"))
        {
		    System.out.println("Succesfully registered");
		}
		else
		{
			System.out.println("not registered");
		}

                if (tmpReg.registerCourse("444-44-4444","SCI425.22"))
                {
  	              System.out.println("Succesfully registered");
				}
				else
				{
					System.out.println("not registered");
				}


        if (tmpReg.unregisterCourse("111-11-1111","SCI460.37"))
        {
		    System.out.println("Succesfully Unregistered");
		}
		else
		{
			System.out.println("Fail to Unregister");
		}

      tmpReg.saveToFile();


}

}
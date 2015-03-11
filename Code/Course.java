import java.util.ArrayList;

class Course {
	private String name;
	private String number; // changed since the courseID is text
	private String description;
	private String startDate;
	private String endDate;
	private int maxEnrollment;
	private ArrayList<Student> enrollment;
	public ArrayList<String> myStudentIDs; //Added by Sasi for the student load in the registration


	public Course(String courseNumber, String courseName, String courseDescription , String sDate, String eDate , int max ) {
		number = courseNumber;
		name = courseName;
		description = courseDescription;
		startDate = sDate;
		endDate = eDate;
		maxEnrollment = max;
		enrollment = new ArrayList<Student>();
		myStudentIDs = new ArrayList<String>();
	}

	public void setCourseInfo(String start, int max){
		startDate = start;
		maxEnrollment = max;
	}
	public String getStartDate(){
		return startDate;
	}
	public String getEndDate(){
			return endDate;
	}
	public int getCurrentEnrollment(){
		return enrollment.size();
	}
	public int getMaxEnrollment(){
		return maxEnrollment;
	}
	public String getDescription(){
		return description;
	}

	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}

	public Boolean addStudent(Student s) throws CourseFullException {
		Boolean status = false;
		if (enrollment.size() < maxEnrollment){
			if (!enrollment.contains(s)){
				status = enrollment.add(s );
			}
		}
		else{
			throw new CourseFullException("Course if Full!");
		}

		return status;
	}

    public Boolean addStudent(String studentID) throws CourseFullException {
			Boolean status = false;
			if (myStudentIDs.size() < maxEnrollment){
				if (!myStudentIDs.contains(studentID)){
					status = myStudentIDs.add(studentID );
				}
			}
			else{
				throw new CourseFullException("Course if Full!");
			}

			return status;
	}


	public Boolean removeStudent(Student s){
		return enrollment.remove(s);
	}

    public Boolean removeStudent(String studentID ){
			return myStudentIDs.remove(studentID);
		}


	public ArrayList<Student> getEnrollment(){
		return enrollment;
	}

	public void listCourseDetails() {
		System.out.println( "Course name: " + this.name + "  Id: " + this.number + "\n" +
							"   Max: " + this.maxEnrollment + "  Enrolled: " + this.myStudentIDs.size() + "\n" +
							"   Start: " + this.startDate + "  End: " + this.endDate + "\n" +
							"   Description: " + this.description);


	}
}



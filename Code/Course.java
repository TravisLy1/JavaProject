import java.util.ArrayList;
	
class Course {
	private String name;
	private int number;
	private String description;
	private String startDate;
	private ArrayList<Student> enrollment;
	
	private int maxEnrollment;
	
	public Course(int courseNumber, String courseName, String courseDescription) {
		name = courseName;
		number = courseNumber;
		description = courseDescription;
		startDate = "03/15/2015";
		maxEnrollment =10;
		enrollment = new ArrayList<Student>();
	}
	
	public void setCourseInfo(String start, int max){
		startDate = start;
		maxEnrollment = max;
	}
	public String getStartDate(){
		return startDate;
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
	public int getNumber() {
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
	
	public Boolean removeStudent(Student s){
		return enrollment.remove(s);
	}
	
	public ArrayList<Student> getEnrollment(){
		return enrollment;
	}
}
	


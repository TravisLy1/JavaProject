import java.util.ArrayList;

public class Person implements Comparable<Person> {
	protected String firstName;
	protected String lastName;
	protected int age;
	protected char gender;
	protected String ssn;

	public Person(String inFirst, String inLast, int inAge, char inGender,String inSSN) {
		firstName = inFirst;
		lastName = inLast;
		age = inAge;
		gender = inGender;
		ssn = inSSN;
	}

	public void setName(String inFirst, String inLast) {
		firstName = inFirst;
		lastName = inLast;
	}

	public String getName() {
		return firstName + " " + lastName;
	}
	public void setLastName(String inLast)	{
		lastName = inLast;
	}

	public String getLastName() {
		return lastName;
	}

    public String getFirstName() {
   		return firstName;
	}

	public void setAge(int inAge) {
		age = inAge;
	}

	public int getAge() {
		return age;
	}

	public void setGender(char inGender) {
		gender = inGender;
	}

	public char getGender() {
		return gender;
	}

	public void setSSN(String inSSN) {
		ssn = inSSN;
	}

	public String getSSN() {
		return ssn;
	}

	public String talk() {
		return "Hello, my name is " + getName() + " and I am " + age
				+ " years old";
	}

	@Override
	public int compareTo(Person person) {
		return this.lastName.compareTo(person.getLastName());
	}

}



class Student extends Person {
	private int ID;
	private String password;
	private ArrayList<Course> myCourses;
    public ArrayList<String> myCourseIDs; //Added by Sasi for the student load in the registration

	public Student(String inFirst, String inLast, int inAge, char inGender,	String inSSN) {
		super(inFirst, inLast, inAge, inGender, inSSN);
		myCourses = new ArrayList<Course>();
		myCourseIDs = new ArrayList<String>();
	}


	public int getID(){
		return ID;
	}

	public void setID(int id){
		ID = id;
	}

	public String getPassword()	{
		return password;
	}

	public void setPassword(String pw) {
		password = pw;
	}

	public ArrayList<Course> getCourseList(){
		return myCourses;
	}

	public Boolean addCourse(Course c) {
		Boolean status = false;
		if (!myCourses.contains(c))		// if not yet enrolled,
			status = myCourses.add(c);
		return status;
	}

	public Boolean addCourse(String courseNumber ) {
			Boolean status = false;
			if (!myCourseIDs.contains(courseNumber))		// if not yet enrolled,
				status = myCourseIDs.add(courseNumber);
			return status;
	}

	public Boolean removeCourse(Course c){
		// if not yet enrolled,
		return myCourses.remove(c);
	}

    public Boolean removeCourse(String courseNumber){
			// if not yet enrolled,
			return myCourseIDs.remove(courseNumber);
	}

}





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

	public Student(String inFirst, String inLast, int inAge, char inGender,	String inSSN) {
		super(inFirst, inLast, inAge, inGender, inSSN);
		myCourses = new ArrayList<Course>();
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

	public Boolean removeCourse(Course c){
		// if not yet enrolled,
		return myCourses.remove(c);
	}

}






public class CourseFullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseFullException () {

    }

    public CourseFullException (String message) {
        super (message);
    }

    public CourseFullException (Throwable cause) {
        super (cause);
    }

    public CourseFullException (String message, Throwable cause) {
        super (message, cause);
    }
}


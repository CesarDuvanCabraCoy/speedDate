package exceptions;

public class ExcUserNotFound extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ExcUserNotFound() {
		super(ConstantsExc.USER_NOT_FOUND);
	}
	
}

package ProjectPackage;

@SuppressWarnings("serial")
public class HashException extends Throwable {
	public HashException() {
		super();
	}
	public HashException(String message, Throwable throwable) {
		super(message, throwable);
	}
	public HashException(String message) {
		super(message);
	}
	public HashException(Throwable throwable) {
		super(throwable);
	}
}

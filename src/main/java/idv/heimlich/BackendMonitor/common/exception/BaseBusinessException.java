package idv.heimlich.BackendMonitor.common.exception;

public class BaseBusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseBusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public BaseBusinessException(final String message) {
		super(message);
	}

}

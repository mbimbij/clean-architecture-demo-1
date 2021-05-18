package org.example.domain.exception;

public class NotAllowedException extends RuntimeException {
	public NotAllowedException() {
	}

	public NotAllowedException(final String message) {
		super(message);
	}
}

package com.eko.assignment.exception;

/**
 * happy cube exception class
 *
 */
public class HappyCubeException extends Exception {

	private static final long serialVersionUID = 1L;

    public HappyCubeException(String message) {
        super(message);
    }

    public HappyCubeException(String message, Throwable cause) {
        super(message, cause);
    }
}

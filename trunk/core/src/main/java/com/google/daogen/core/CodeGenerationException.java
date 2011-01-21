package com.google.daogen.core;

public class CodeGenerationException extends RuntimeException {
    public CodeGenerationException() {
    }

    public CodeGenerationException(String message) {
        super(message);
    }

    public CodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeGenerationException(Throwable cause) {
        super(cause);
    }
}

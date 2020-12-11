package br.com.ecommerce.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public final class ErrorController {

    @ExceptionHandler(IOException.class)
    public String handleAbortedConnection(final IOException ex) {
        // prevents ClientAbortException
        if (ex.getClass().getName().equals("org.apache.catalina.connector.ClientAbortException")) {
            return null;
        }

        return "errorPage";
    }

}
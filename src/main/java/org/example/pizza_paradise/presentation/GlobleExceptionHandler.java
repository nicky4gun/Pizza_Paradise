package org.example.pizza_paradise.presentation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException e, Model model) {
        model.addAttribute("errorMessage",e.getMessage());
        return "error";

    }

    @ExceptionHandler(Exception.class)
    public String handleNullPointerException(NullPointerException e, Model model) {
        model.addAttribute("errorMessage",e.getMessage());
        return "error";
    }
}

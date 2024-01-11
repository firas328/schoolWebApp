package com.springHandOn.schoolWebApp.model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/*
@ControllerAdvice is a specialization of the @Component annotation which allows to handle
exceptions across the whole application in one global handling component. It can be viewed
as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.
* */
@ControllerAdvice
public class GlobalExeptionController {
    /*
    @ExceptionHandler will register the given method for a given
    exception type, so that ControllerAdvice can invoke this method
    logic if a given exception type is thrown inside the web application.
    * */
    @ExceptionHandler(Exception.class)
    public ModelAndView HnadelException(Exception exception){
        var modelAndview=new ModelAndView();
        modelAndview.setViewName("error");
        modelAndview.addObject("errormsg",exception.getMessage());
        return modelAndview;
    }
}

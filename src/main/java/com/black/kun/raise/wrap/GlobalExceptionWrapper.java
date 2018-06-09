package com.black.kun.raise.wrap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionWrapper {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Wrap defaultExceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        Wrap wrap = new Wrap(500, e.getMessage(), null, null);

        return wrap;
    }

    /**
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
//    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Wrap AccountExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        Wrap wrap = new Wrap(500,e.getMessage(), null, null);
        return wrap;
    }

}

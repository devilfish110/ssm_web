package org.study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.study.entities.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private Result result;

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result TypeMismatchExceptionHandler(MethodArgumentTypeMismatchException typeMismatchException) {
        logger.error(typeMismatchException.getMessage(), typeMismatchException);
        result.setCode(4000);
        result.setMessage(typeMismatchException.getMessage());
        return result;
    }
}
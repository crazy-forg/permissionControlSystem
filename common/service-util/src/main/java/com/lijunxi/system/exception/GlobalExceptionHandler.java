package com.lijunxi.system.exception;


import com.lijunxi.common.result.Result;
import com.lijunxi.common.result.ResultCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> error(Exception e) {
        e.printStackTrace();
        return Result.fail().message(e.getMessage());
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public Result<?> error(CustomException e) {
        e.printStackTrace();
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }

    /**
     * spring security异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result<?> error(AccessDeniedException e) throws AccessDeniedException {
        return Result.build(null, ResultCodeEnum.PERMISSION);
    }
}

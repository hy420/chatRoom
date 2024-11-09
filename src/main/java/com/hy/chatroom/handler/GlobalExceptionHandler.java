package com.hy.chatroom.handler;

import com.hy.chatroom.common.Result;
import com.hy.chatroom.excception.YangException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 全局异常处理类
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(YangException.class)
    @ResponseBody
    public Result error(YangException e){
        e.printStackTrace();
        return Result.build(null,e.getCode(), e.getMessage());
    }



}

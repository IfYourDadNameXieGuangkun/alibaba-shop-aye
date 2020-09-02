package com.aye.commons.ex.handler;

import com.aye.commons.dto.ER;
import com.aye.commons.ex.enums.ArgumentErrorEnum;
import com.aye.commons.ex.enums.CommonErrorEnum;
import com.aye.commons.ex.enums.ServletErrorEnum;
import com.aye.commons.ex.exception.BaseException;
import com.aye.commons.ex.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @ClassName GlobalDefaultExceptionHandler
 * @Description 全局异常处理
 * @Author Aye
 * @Date 2020/9/1 15:22
 * @Version 1.0
 */
//@Component
@ControllerAdvice
//@ConditionalOnWebApplication
//@ConditionalOnMissingBean(GlobalDefaultExceptionHandler.class)
public class GlobalDefaultExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    /**
     * 生产环境
     */
    private final static String ENV_PROD = "prod";
    /**
     * 当前环境
     */
    @Value("${spring.profiles.active}")
    private String profile;

    /**
     * 异常msg处理
     *
     * @param e 异常
     * @return
     */
    public String getMessage(BaseException e) {
        String message = e.getErrorEnum().getMessage();
        if (message == null || message.isEmpty()) {
            return e.getMessage();
        }
        return message;
    }

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ER handleBusinessException(BaseException e) {
        log.error(e.getMessage(), e);
        return new ER(e.getErrorEnum().getCode(), getMessage(e));
    }

    /**
     * 自定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ER handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        return new ER(e.getErrorEnum().getCode(), getMessage(e));
    }

    /**
     * Controller上一层相关异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            // BindException.class,
            // MethodArgumentNotValidException.class
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    @ResponseBody
    public ER handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        int code = CommonErrorEnum.SERVER_ERROR.getCode();
        try {
            ServletErrorEnum servletErrorEnum = ServletErrorEnum.valueOf(e.getClass().getSimpleName());
            code = servletErrorEnum.getCode();
        } catch (IllegalArgumentException e1) {
            log.error("class [{}] not defined in enum {}", e.getClass().getName(), ServletErrorEnum.class.getName());
        }

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
            code = CommonErrorEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonErrorEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ER(code, message);
        }

        return new ER(code, e.getMessage());
    }
    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ER handleBindException(BindException e) {
        log.error("参数绑定校验异常", e);

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数校验(Valid)异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ER handleValidException(MethodArgumentNotValidException e) {
        log.error("参数绑定校验异常", e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 包装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private ER wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();

        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());

        }

        return new ER(ArgumentErrorEnum.VALID_ERROR.getCode(), msg.substring(2));
    }

    /**
     * 未定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ER handleException(Exception e) {
        log.error(e.getMessage(), e);

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            int code = CommonErrorEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonErrorEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ER(code, message);
        }

        return new ER(CommonErrorEnum.SERVER_ERROR.getCode(), e.getMessage());
    }



}
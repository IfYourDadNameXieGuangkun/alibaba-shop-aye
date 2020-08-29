package com.aye.commons.exception;//package com.alibaba.validator.exception;
//
//import com.alibaba.validator.exception.dto.ER;
//import com.alibaba.validator.exception.dto.ResultDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.validation.ConstraintViolationException;
//
//
//@RestControllerAdvice
//public class CommonExceptionHandler {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
//
//    /**
//     * 请求传入对象字段值判断 validator
//     *
//     * @param methodArgumentNotValidException
//     * @return
//     */
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ER handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
//        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
//        StringBuilder sb = new StringBuilder("校验失败:");
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
//        }
//        String msg = sb.toString();
//        return new ER(ArgumentResponseEnum.VALID_ERROR.getCode(), msg);
//    }
//
//    /**
//     * 请求传入对象字段值判断 validator
//     *
//     * @param constraintViolationException
//     * @return
//     */
//    @ExceptionHandler({ConstraintViolationException.class})
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ER handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
//        return new ER(ArgumentResponseEnum.VALID_ERROR.getCode(), constraintViolationException.getMessage());
//    }
//
//    /**
//     * 业务异常
//     *
//     * @param baseException baseException
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = BizException.class)
//    @ResponseBody
//    public ER handleBizException(BaseException baseException) {
//        return new ER(baseException.getBizErrorEnum().getCode(), baseException.getMessage() == null ? baseException.getBizErrorEnum().getMessage() : baseException.getMessage());
//    }
//
//    /**
//     * 通用异常处理
//     *
//     * @param ex
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ER exceptionHandler(Exception ex) {
//        logger.error(ex.getMessage());
//        //输出异常信息
//        ex.printStackTrace();
//        //处理校验注解异常信息
//        if (ex instanceof MethodArgumentNotValidException) {
//            MethodArgumentNotValidException mex = (MethodArgumentNotValidException) ex;
//            return new ER(CommonResponseEnum.SERVER_ERROR.getCode(), e.getMessage());
//        } else {
//            return R.failed(ex.getMessage());
//        }
//    }
//
//}

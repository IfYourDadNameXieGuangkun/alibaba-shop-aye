//package com.aye.commons.exception;
//
//
//import com.aye.commons.dto.ER;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.ConversionNotSupportedException;
//import org.springframework.beans.TypeMismatchException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.HttpMediaTypeNotAcceptableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingPathVariableException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.ServletRequestBindingException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
//import org.springframework.web.multipart.support.MissingServletRequestPartException;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@ControllerAdvice
//public class UnifiedExceptionHandler implements ApplicationContextAware {
//
//
//    private static final String PROD_PROFILE = "prod";
//
//    private ApplicationContext context;
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
//
//
//    public String getActiveProfile(){
//        return context.getEnvironment().getActiveProfiles()[0];
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context = applicationContext;
//    }
//
//    /**
//     * 业务异常
//     * @param baseException baseException
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = BizException.class)
//    @ResponseBody
//    public ER handleBizException(BaseException baseException){
//        logger.error(baseException.getMessage(), baseException);
//        return new ER(baseException.getBizErrorEnum().getCode(), getMessage(baseException));
//    }
//
//    /**
//     * 自定义异常
//     * @param baseException 异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = BaseException.class)
//    @ResponseBody
//    public ER handleBaseException(BaseException baseException) {
//        logger.error(baseException.getMessage(), baseException);
//        return new ER(baseException.getBizErrorEnum().getCode(), getMessage(baseException));
//    }
//
//    private String getMessage(BaseException baseException) {
//        String message = baseException.getMessage();
//        if(message == null || message.isEmpty()){
//            message = baseException.getBizErrorEnum().getMessage();
//        }
//        return message;
//    }
//
//
//    /**
//     * 参数绑定异常
//     * @param bindException 异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = BindException.class)
//    @ResponseBody
//    public ER handleBindException(BindException bindException) {
//        if(!PROD_PROFILE.equals(getActiveProfile())) {
//            logger.error(bindException.getMessage(), bindException);
//        }
//        return wrapperBindingResult(bindException.getBindingResult());
//    }
//
//    /**
//     * 参数校验异常，将校验失败的所有异常组合成一条错误信息
//     * @param argumentNotValidException 异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ER handleValidException(MethodArgumentNotValidException argumentNotValidException) {
//        if(!PROD_PROFILE.equals(getActiveProfile())) {
//            logger.error(argumentNotValidException.getMessage(), argumentNotValidException);
//        }
//        return wrapperBindingResult(argumentNotValidException.getBindingResult());
//    }
//
//    /**
//     * 包装绑定异常结果
//     * @param bindingResult 绑定结果
//     * @return 异常结果
//     */
//    private ER wrapperBindingResult(BindingResult bindingResult) {
//        List<String> errors = bindingResult
//                .getFieldErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//        String message = errors.isEmpty() ? ArgumentResponseEnum.VALID_ERROR.getMessage() : errors.get(0);
//        return new ER(ArgumentResponseEnum.VALID_ERROR.getCode(), message);
//    }
//
//    /**
//     * 未定义异常
//     * @param e 异常
//     * @return 异常结果
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ER handleException(Exception e) {
//        logger.error(e.getMessage(), e);
//
//        if (PROD_PROFILE.equals(getActiveProfile())) {
//            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
//            int code = CommonResponseEnum.SERVER_ERROR.getCode();
//            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
//            String message = getMessage(baseException);
//            return new ER(code, message);
//        }
//
//        return new ER(CommonResponseEnum.SERVER_ERROR.getCode(), e.getMessage());
//    }
//
//
//    /**
//     * Controller上一层相关异常
//     * @param e 异常
//     * @return 异常结果
//     */
//    @ExceptionHandler({
//            NoHandlerFoundException.class,
//            HttpRequestMethodNotSupportedException.class,
//            HttpMediaTypeNotSupportedException.class,
//            MissingPathVariableException.class,
//            MissingServletRequestParameterException.class,
//            TypeMismatchException.class,
//            HttpMessageNotReadableException.class,
//            HttpMessageNotWritableException.class,
//            // BindException.class, //单独处理
//            // MethodArgumentNotValidException.class //单独处理
//            HttpMediaTypeNotAcceptableException.class,
//            ServletRequestBindingException.class,
//            ConversionNotSupportedException.class,
//            MissingServletRequestPartException.class,
//            AsyncRequestTimeoutException.class
//    })
//    @ResponseBody
//    public ER handleServletException(Exception e, HttpServletRequest request, HttpServletResponse response) {
//        logger.error(e.getMessage(), e);
//        int code = CommonResponseEnum.SERVER_ERROR.getCode();
//        try {
//            ServletResponseEnum servletExceptionEnum = ServletResponseEnum.valueOf(e.getClass().getSimpleName());
//            code = servletExceptionEnum.getCode();
//        } catch (IllegalArgumentException e1) {
//            logger.error("class [{}] not defined in enum [{}]", e.getClass().getName(), ServletResponseEnum.class.getName());
//        }
//
//        if (PROD_PROFILE.equals(getActiveProfile())) {
//            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
//            code = CommonResponseEnum.SERVER_ERROR.getCode();
//            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
//            String message = getMessage(baseException);
//            return new ER(code, message);
//        }
//        return new ER(code, e.getMessage());
//    }
//}

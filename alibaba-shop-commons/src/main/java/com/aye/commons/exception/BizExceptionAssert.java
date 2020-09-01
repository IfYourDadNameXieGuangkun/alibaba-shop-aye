//package com.aye.commons.exception;
//
//import java.text.MessageFormat;
//
//
//
//public interface BizExceptionAssert extends IBizErrorEnum, Assert {
//
//
//    @Override
//    default BizException newException(Object... args) {
//        String msg = MessageFormat.format(this.getMessage(), args);
//        return new BizException(this, args, msg);
//    }
//
//    @Override
//    default BizException newException(Throwable t, Object... args) {
//        String msg = MessageFormat.format(this.getMessage(), args);
//        return new BizException(this, args, msg, t);
//    }
//}
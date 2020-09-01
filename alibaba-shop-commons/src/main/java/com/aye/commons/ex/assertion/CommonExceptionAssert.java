package com.aye.commons.ex.assertion;


import com.aye.commons.ex.enums.IErrorEnum;
import com.aye.commons.ex.exception.ArgumentException;
import com.aye.commons.ex.exception.BaseException;

import java.text.MessageFormat;

public interface CommonExceptionAssert extends IErrorEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {

        String msg = MessageFormat.format(this.getMessage(), args);
        return new ArgumentException(this, args, msg, t);
    }

}

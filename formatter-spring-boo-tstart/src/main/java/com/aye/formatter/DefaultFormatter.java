package com.aye.formatter;

public class DefaultFormatter implements Formatter {
    @Override
    public String format(Object object) {
        return String.valueOf(object); // null 安全实现
    }
}

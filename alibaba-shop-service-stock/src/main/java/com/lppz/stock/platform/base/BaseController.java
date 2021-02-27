package com.lppz.stock.platform.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public abstract class BaseController implements ApplicationContextAware {
    private ApplicationContext context;

    protected SynProvider getSynHandler(String channel) {
        Map<String, SynProvider> map = context.getBeansOfType(SynProvider.class);//1.拿到所有实现IPay接口的实现类
        Optional<SynProvider> optionalName = map.values().stream()
                .filter(synProvider -> Objects.requireNonNull(AnnotationUtils.findAnnotation(synProvider.getClass(), ChannelSelector.class)).channel().getSource().equals(channel))
                .findFirst();
        return optionalName.orElse(null);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

package com.aye.reg.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 字段自动填充，
 * @Link User->addr字段上注解 @TableField(value = "c_addr",fill = FieldFill.INSERT) ,当执行插入sql时会进行填充,慎用!!!!所有对象上被注解的字段都会被填充
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "addr", String.class, "湖北省武汉市江汉区发展大道武汉科技大厦1106");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "addr", String.class, "湖北省武汉市东西湖区金银湖北街良品大厦7楼");
    }
}

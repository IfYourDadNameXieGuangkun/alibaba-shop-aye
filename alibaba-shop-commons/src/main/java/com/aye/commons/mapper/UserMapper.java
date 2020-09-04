package com.aye.commons.mapper;

import com.aye.commons.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Aye
 * @since 2020-09-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}

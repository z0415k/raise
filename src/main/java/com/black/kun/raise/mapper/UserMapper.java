package com.black.kun.raise.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.black.kun.raise.entity.vo.model.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zk123
 * @since 2018-04-16
 */
public interface UserMapper extends BaseMapper<User> {

    Integer testInsert();

    Integer testError();


}

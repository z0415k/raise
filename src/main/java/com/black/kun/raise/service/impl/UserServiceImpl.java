package com.black.kun.raise.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.black.kun.raise.entity.vo.model.User;
import com.black.kun.raise.mapper.UserMapper;
import com.black.kun.raise.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zk123
 * @since 2018-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

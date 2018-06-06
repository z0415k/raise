package com.black.kun.raise.test.service.impl;

import com.black.kun.raise.test.entity.User;
import com.black.kun.raise.test.mapper.UserMapper;
import com.black.kun.raise.test.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zk123
 * @since 2018-04-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

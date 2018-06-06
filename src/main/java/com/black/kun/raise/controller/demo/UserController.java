package com.black.kun.raise.controller.demo;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.black.kun.raise.entity.vo.model.User;
import com.black.kun.raise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zk
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/test/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostConstruct()
    public void test(){
        userService.selectList(new Wrapper<User>() {
            @Override
            public String getSqlSegment() {
                return "where user_id=1";
            }
        }.setSqlSelect("id"));
        System.out.println("#####################################");
    }

    public static void main(String[] args){

        List<Integer> test = Stream.of(asList(1,2),asList(3,4))
                .flatMap( a -> a.stream())
                .collect(Collectors.toList());

        test.forEach(System.out::println);
    }

}


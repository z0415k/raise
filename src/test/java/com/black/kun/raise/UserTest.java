package com.black.kun.raise;

import com.baomidou.mybatisplus.plugins.Page;
import com.black.kun.raise.entity.vo.model.User;
import com.black.kun.raise.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RaiseApplication.class)

public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<User>(0, 3);
        page.setSearchCount(true);
        List<User> addrList =
                userMapper.selectPage(page, null);
        System.out.println(1111111);
        Assert.assertNotEquals("Should have pagination info", 0, page.getTotal());
        Assert.assertEquals(3, addrList.size());
    }

    @Test
    public void aaa(){
        testChange(new int[]{1, 2, 3});
    }

    public static void testChange(int ... a){
        Arrays.stream(a).forEach(System.out::println);
    }

    @Test
    @Transactional(rollbackFor = {Exception.class})
    public void testTx(){
        try{
            userMapper.testInsert();
            userMapper.testError();
        }catch (Exception e){

        }

    }
}
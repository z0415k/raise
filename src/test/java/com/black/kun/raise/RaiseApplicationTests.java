package com.black.kun.raise;

import com.black.kun.raise.entity.vo.TestVo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaiseApplicationTests {
    private static final Logger logger = LogManager.getLogger("TEST");
    @Test
    public void contextLoads() {
        String test = Arrays.asList("1,2,3").stream().collect(Collectors.joining(",", "{", "}"));

        logger.info("sasasasasa");

        System.out.println(test);
    }

}

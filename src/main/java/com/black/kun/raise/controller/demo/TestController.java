package com.black.kun.raise.controller.demo;

import com.black.kun.raise.entity.vo.BaseResponse;
import com.black.kun.raise.entity.vo.TestAop;
import com.black.kun.raise.entity.vo.TestVo;
import com.black.kun.raise.service.RedisService;
import com.cipher.checker.Check;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试环境
 * @author zk
 */
@Api(description="测试")
@RestController
@RequestMapping("/test")
public class TestController {
    private Logger log = LogManager.getLogger();

    @Autowired
    private RedisService redisService;

//    @Autowired
//    private HbaseTemplate hbaseTemplate;

    @ApiOperation("测试环境")
    @RequestMapping(value = "/testEnv",method = RequestMethod.POST )
    public BaseResponse testEnv(){
        log.info(redisService.get("aaa"));
//        hbaseTemplate.delete("t1","f1","aa");
        return new BaseResponse(redisService.get("aaa"));
    }

    @ApiOperation("测试@validation分组")
    @RequestMapping(value = "/testValidation",method = RequestMethod.POST )
    public BaseResponse testValidation(@RequestBody @Validated(TestVo.test2.class) TestVo req, BindingResult result){
        if(result.hasErrors()){
            throw new RuntimeException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return new BaseResponse(redisService.get("aaa"));
    }

    @ApiOperation("测试Aop参数校验")
    @RequestMapping(value = "/aopValidation",method = RequestMethod.POST )
    @Check({"id","name"})
    public BaseResponse aopValidation(@RequestBody TestAop req){


        return new BaseResponse();
    }
}

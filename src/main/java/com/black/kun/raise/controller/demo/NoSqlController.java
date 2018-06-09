package com.black.kun.raise.controller.demo;

import com.black.kun.raise.service.NoSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/NoSql")
public class NoSqlController {

    @Autowired
    private NoSqlService noSqlService;

    @PostMapping("/Ehcache")
    public int testEhcache(@RequestParam("id") Integer id) {

        return noSqlService.testEhcache(500);
    }

    @GetMapping("redis")
    public int testRedis(@RequestParam("id")Integer id){
        return noSqlService.testRedis(id);
    }

}

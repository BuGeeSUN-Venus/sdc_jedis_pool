package com.example.sdc_jedis_pool.Controller;

import com.example.sdc_jedis_pool.Util.Redis.JedisPoolUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping(value = "sdc")
public class TestController {

    @RequestMapping(value = "/mvcTest.do", method = RequestMethod.POST)
    public Object mvcTest(){
        return "ok";
    }

    @RequestMapping(value = "/setValue.do", method = RequestMethod.POST)
    public Object setValue(){
        JedisPool pool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = pool.getResource();
        //插入String类型
        jedis.set("name","孙德超");
        jedis.append("name", "-是-");
        jedis.append("name", "满分师傅");
        System.out.println("name是否存在"+jedis.exists("name"));
        return "ok";
    }

}

package cn.itcast.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void test1(){
        //1.连接redis
        Jedis jedis = new Jedis("localhost",6379);
        //2.创建数据
        /*jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.setex("activateCode",20,"hehe");*/
        jedis.hset("user","name","wangwu");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","男");
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> ketset = user.keySet();
        for (String s : ketset) {
            String value = user.get(s);
            System.out.println(s+":"+value);
        }
        //3.关闭redis
        jedis.close();
    }

}

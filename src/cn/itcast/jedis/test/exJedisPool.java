package cn.itcast.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class exJedisPool {
    @Test
    public void test2(){
        //1.创建连接池对象
        JedisPool jedisPool = new JedisPool();
        //2.操作数据
        Jedis resource = jedisPool.getResource();
        String s = resource.set("name", "getingting");
        //3.归还连接池资源
        resource.close();
    }
}

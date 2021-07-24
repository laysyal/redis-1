package cn.itcast.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import utils.jedisPoolUtils;

public class jedisPoolUtilsTest {
    @Test
    public void test4(){
        Jedis jedis = jedisPoolUtils.getJedis();
        jedis.set("height","190");
    }
}

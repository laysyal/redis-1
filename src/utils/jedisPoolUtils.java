package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class jedisPoolUtils {
    private static JedisPool jedisPool;
    static {
        //1.读取配置文件
        InputStream is = jedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //2.创建property对象
        Properties pro = new Properties();
        //3.关联文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.获取数据，设置到jedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxIdle")));
        //5.初始化jedisPool
        jedisPool= new JedisPool(pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}

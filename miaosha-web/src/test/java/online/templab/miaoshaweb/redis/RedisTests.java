package online.templab.miaoshaweb.redis;


import online.templab.miaoshabase.entity.Item;
import online.templab.miaoshaweb.MiaoshaWebApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTests extends MiaoshaWebApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        String key = "name";
        redisTemplate.opsForValue().set(key, "yukong");
        String value = (String) redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

        Item item = new Item().setId(1L).setName("超级商品").setStock(100);
        String itemKey = "item";
        redisTemplate.opsForValue().set(itemKey, item);
        Item newItem = (Item) redisTemplate.opsForValue().get(itemKey);
        redisTemplate.delete(itemKey);
        System.out.println("获取缓存中key为" + itemKey + "的值为：" + newItem);


        String itemStockKey = "item:"+item.getId();
        redisTemplate.opsForValue().set(itemStockKey, item.getStock());
        int itemStock = (int) redisTemplate.opsForValue().get(itemStockKey);
        redisTemplate.delete(itemStockKey);
        System.out.println("获取缓存中key为" + itemStockKey + "的值为：" + itemStock);
    }

}


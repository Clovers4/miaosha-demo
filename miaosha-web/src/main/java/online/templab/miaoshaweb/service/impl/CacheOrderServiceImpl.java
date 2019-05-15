package online.templab.miaoshaweb.service.impl;

import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshabase.mapper.ItemMapper;
import online.templab.miaoshaweb.sender.RequestSender;
import online.templab.miaoshaweb.service.CacheOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheOrderServiceImpl implements CacheOrderService {

    @Autowired
    private RequestSender requestSender;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ItemMapper itemMapper;

    private final String STOCK = "stock:";

    @Override
    public int getStock(Long itemId) {
        if (redisTemplate.opsForHash().hasKey(STOCK, itemId)) {
            return (int) redisTemplate.opsForHash().get(STOCK, itemId);
        } else {
            int stock = itemMapper.selectByPrimaryKey(itemId).getStock();
            redisTemplate.opsForHash().put(STOCK, itemId, stock);
            return stock;
        }
    }

    @Override
    public void order(Long itemId, Long userId) {
        // TODO:此处有bug,高并发会突破该屏障导致库存变负数，不过只影响缓存，不会对真正的数据库造成影响
        if (getStock(itemId) <= 0) {
            return;
        }
        // 预减redis
        redisTemplate.opsForHash().increment(STOCK, itemId, -1);
        requestSender.sendOrderRequest(itemId, userId);
    }

    @Override
    public List<ItemOrder> listItemOrders(Long userId) {
        // TODO:redis
        return null;
    }
}

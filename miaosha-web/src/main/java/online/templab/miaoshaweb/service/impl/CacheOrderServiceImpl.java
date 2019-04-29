package online.templab.miaoshaweb.service.impl;

import online.templab.miaoshabase.entity.ItemOrder;
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

    @Override
    public int getStock(Long itemId) {
        final String itemStockKey = "item-stock:" + itemId;
        if (redisTemplate.hasKey(itemStockKey)) {
            return (int) redisTemplate.opsForValue().get(itemStockKey);
        } else {
            // TODO:redis

        }
        return 0;
    }

    @Override
    public void order(Long itemId, Long userId) {
        // TODO:redis
//        if(getStock(itemId)<=0){
//            return;
//        }
        requestSender.sendOrderRequest(itemId, userId);
    }

    @Override
    public List<ItemOrder> listItemOrders(Long userId) {
        // TODO:redis
        return null;
    }
}

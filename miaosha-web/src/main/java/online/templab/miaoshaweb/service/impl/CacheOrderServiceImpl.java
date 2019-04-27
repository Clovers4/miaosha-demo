package online.templab.miaoshaweb.service.impl;

import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshaweb.sender.OrderRequestSender;
import online.templab.miaoshaweb.service.CacheOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheOrderServiceImpl implements CacheOrderService {

    @Autowired
    private OrderRequestSender orderRequestSender;

    @Override
    public int getStock(Long itemId) {
        return 0;
    }

    @Override
    public void order(Long itemId, Long userId) {
        // TODO:redis
        orderRequestSender.send(itemId, userId);
    }

    @Override
    public List<ItemOrder> listItemOrders(Long userId) {
        return null;
    }
}

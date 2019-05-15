package online.templab.miaoshacore.service.impl;

import lombok.extern.slf4j.Slf4j;
import online.templab.miaoshabase.entity.Item;
import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshacore.mapper.ItemMapper;
import online.templab.miaoshacore.mapper.ItemOrderMapper;
import online.templab.miaoshacore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;


    @Override
    public int getStock(Long itemId) {
        Item item = itemMapper.selectByPrimaryKey(itemId);
        if (item == null) {
            return 0;
        }
        // TODO:Redis
        return item.getStock();
    }

    @Async
    @Override
    public boolean order(Long itemId, Long userId) {
        // TODO:防止超卖
        boolean success = 1 == itemMapper.decreaseStock(itemId);
        if (!success) {
            return false;
        }
        log.info("Order success! Now:{}", new Date());
        return 1 == itemOrderMapper.insertSelective(
                new ItemOrder().setItemId(itemId).setUserId(userId)
        );
    }

    @Override
    public List<ItemOrder> listItemOrders(Long userId) {
        return itemOrderMapper.select(new ItemOrder().setUserId(userId));
    }
}

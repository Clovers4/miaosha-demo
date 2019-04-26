package online.templab.miaoshacore.service.impl;

import online.templab.miaoshabase.entity.Item;
import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshacore.mapper.ItemMapper;
import online.templab.miaoshacore.mapper.ItemOrderMapper;
import online.templab.miaoshacore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean order(Long userId, Long itemId) {
        if (getStock(itemId) <= 0) {
            return false;
        }
        // TODO:防止超卖
        boolean success = 1 == itemMapper.decreaseStock(itemId);
        if (!success) {
            return false;
        }
        return 1 == itemOrderMapper.insertSelective(
                new ItemOrder().setItemId(itemId).setUserId(userId)
        );
    }

    @Override
    public List<ItemOrder> listItemOrders(Long userId) {
        return itemOrderMapper.select(new ItemOrder().setUserId(userId));
    }
}

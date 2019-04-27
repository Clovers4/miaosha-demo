package online.templab.miaoshaweb.service;

import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshaweb.sender.OrderRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CacheOrderService {

    /**
     * 查询库存接口
     *
     * @param itemId
     * @return
     */
    int getStock(Long itemId);

    /**
     * 下单接口
     *
     * @param itemId
     * @param userId
     */
    void order(Long itemId,Long userId);

    /**
     * 查看用户所有订单接口
     *
     * @param userId
     * @return
     */
    List<ItemOrder> listItemOrders(Long userId);

}

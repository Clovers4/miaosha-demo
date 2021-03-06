package online.templab.miaoshacore.service;

import online.templab.miaoshabase.entity.ItemOrder;

import java.util.List;

public interface OrderService {

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
    boolean order(Long itemId,Long userId);

    /**
     * 查看用户所有订单接口
     *
     * @param userId
     * @return
     */
    List<ItemOrder> listItemOrders(Long userId);


}

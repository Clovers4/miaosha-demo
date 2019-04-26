package online.templab.miaoshaweb.controller;

import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshacore.mapper.ItemOrderMapper;
import online.templab.miaoshacore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Clovers4
 */
@RestController
public class MiaoshaController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取一个随机用户id
     *
     * @return
     */
    @GetMapping("/user")
    public int getUserId() {
        return ThreadLocalRandom.current().nextInt(10000);
    }

    @GetMapping("/item/{itemId}")
    public int getStock(@PathVariable Long itemId) {
        return orderService.getStock(itemId);
    }

    @GetMapping("/item/{itemId}/order/{userId}")
    public boolean order(@PathVariable Long userId, @PathVariable Long itemId) {
        return orderService.order(userId, itemId);
    }

    @GetMapping("/user/{userId}/result")
    public List<ItemOrder> getOrderResult(Long userId) {
        return orderService.listItemOrders(userId);
    }

}

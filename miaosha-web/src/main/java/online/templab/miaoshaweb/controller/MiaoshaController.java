package online.templab.miaoshaweb.controller;

import online.templab.miaoshabase.entity.ItemOrder;
import online.templab.miaoshaweb.service.CacheOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Clovers4
 */
@RestController
public class MiaoshaController {

//    @Autowired
//    private OrderService orderService;

    @Autowired
    private CacheOrderService cacheOrderService;

    /**
     * 获取一个随机用户id
     *
     * @return
     */
    @GetMapping("/user")
    public int getUserId() {
        return ThreadLocalRandom.current().nextInt(100);
    }

    @GetMapping("/item/{itemId}")
    public int getStock(@PathVariable Long itemId) {
        return cacheOrderService.getStock(itemId);
    }

    @GetMapping("/item/{itemId}/clean")
    public void cleanStockCache(@PathVariable Long itemId) {
         cacheOrderService.cleanStockCache(itemId);
    }

    @GetMapping("/item/{itemId}/order")
    public void order(@PathVariable Long itemId) {
        Long userId = Long.valueOf(ThreadLocalRandom.current().nextInt(100));
//        orderService.order(itemId, userId);
        cacheOrderService.order(itemId, userId);
    }

    @GetMapping("/item/{itemId}/order/{userId}")
    public void order(@PathVariable Long itemId, @PathVariable Long userId) {
//        orderService.order(itemId, userId);
        cacheOrderService.order(itemId, userId);
    }

    @GetMapping("/user/{userId}/result")
    public List<ItemOrder> getOrderResult(Long userId) {
        return cacheOrderService.listItemOrders(userId);
    }

}

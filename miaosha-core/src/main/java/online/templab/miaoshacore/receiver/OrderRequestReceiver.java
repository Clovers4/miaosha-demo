package online.templab.miaoshacore.receiver;

import online.templab.miaoshabase.dto.OrderRequest;
import online.templab.miaoshacore.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "order-request")
public class OrderRequestReceiver {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void process(OrderRequest orderRequest) {
        orderService.order(orderRequest.getItemId(), orderRequest.getUserid());
    }
}

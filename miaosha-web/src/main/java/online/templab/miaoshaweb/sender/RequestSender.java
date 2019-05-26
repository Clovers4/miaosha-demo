package online.templab.miaoshaweb.sender;

import online.templab.miaoshabase.dto.OrderRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendOrderRequest(Long itemId, Long userId) {
        amqpTemplate.convertAndSend("order-request", new OrderRequest().setUserid(userId).setItemId(itemId));
    }

}

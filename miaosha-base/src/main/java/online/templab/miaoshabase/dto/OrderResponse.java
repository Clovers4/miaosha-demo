package online.templab.miaoshabase.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class OrderResponse implements Serializable {

    private Long itemId;

    private Long userid;

    private boolean success;

    private static final long serialVersionUID = 1L;
}

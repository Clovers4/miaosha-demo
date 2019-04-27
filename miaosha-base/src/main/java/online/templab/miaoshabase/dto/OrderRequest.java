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
public class OrderRequest implements Serializable {

    private Long itemId;

    private Long userid;

    private static final long serialVersionUID = 1L;
}

package online.templab.miaoshabase.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "`item_order`")
public class ItemOrder implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`item_id`")
    private Long itemId;

    @Column(name = "`user_id`")
    private Long userId;

    private static final long serialVersionUID = 1L;
}
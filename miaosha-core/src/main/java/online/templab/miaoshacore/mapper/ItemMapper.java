package online.templab.miaoshacore.mapper;

import online.templab.miaoshabase.entity.Item;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ItemMapper extends Mapper<Item> {

    /**
     * 库存减 1
     *
     * @param itemId
     * @return 1:表示减少成功; 0:表示减少失败,库存不足.
     */
    int decreaseStock(Long itemId);
}
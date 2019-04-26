package online.templab.miaoshacore.mapper;

import online.templab.miaoshabase.entity.Item;
import online.templab.miaoshacore.MiaoshaCoreApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ItemMapperTests extends MiaoshaCoreApplicationTests {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void testDecreaseStock() {
        Item item = new Item().setName("商品1").setStock(10);
        itemMapper.insertSelective(item);
        System.out.println(item);
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(1, itemMapper.decreaseStock(item.getId()));
        }
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(0, itemMapper.decreaseStock(item.getId()));
        }
        Assert.assertEquals(0, itemMapper.selectByPrimaryKey(item.getId()).getStock().intValue());
        System.out.println(itemMapper.selectByPrimaryKey(item.getId()));
    }
}

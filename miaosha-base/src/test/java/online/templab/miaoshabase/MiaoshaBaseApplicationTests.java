package online.templab.miaoshabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshabase.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("online.templab.miaoshabase")
public class MiaoshaBaseApplicationTests {

    @Test
    public void testMain(){

    }
}

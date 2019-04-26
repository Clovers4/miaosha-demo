package online.templab.miaoshacore;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshacore.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaCoreApplicationTests {
}

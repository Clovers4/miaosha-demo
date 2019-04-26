package online.templab.miaoshaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"online.templab.miaoshacore", "online.templab.miaoshaweb"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshacore.mapper")
public class MiaoshaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaWebApplication.class, args);
    }

}

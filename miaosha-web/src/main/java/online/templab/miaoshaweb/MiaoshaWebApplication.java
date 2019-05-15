package online.templab.miaoshaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshabase.mapper")
@ComponentScan(value = {"online.templab.miaoshaweb","online.templab.miaoshabase"})
public class MiaoshaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaWebApplication.class, args);
    }

}

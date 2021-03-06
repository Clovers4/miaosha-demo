package online.templab.miaoshacore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshabase.mapper")
@ComponentScan(value = {"online.templab.miaoshacore","online.templab.miaoshabase"})
public class MiaoshaCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaCoreApplication.class, args);
    }

}

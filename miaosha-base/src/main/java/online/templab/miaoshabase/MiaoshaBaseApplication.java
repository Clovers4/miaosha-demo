package online.templab.miaoshabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.templab.miaoshabase.mapper")
public class MiaoshaBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaBaseApplication.class, args);
    }

}

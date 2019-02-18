package cn.bdqn.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.bdqn.itrip.dao")
@EnableTransactionManagement
public class ItripApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItripApplication.class, args);
    }

}


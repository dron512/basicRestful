package org.pmh.conf;

import org.pmh.components.AA;
import org.pmh.components.BB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.pmh.components")
public class AppConf2 {

//    @Bean
//    public AA aa(){
//        return new AA();
//    }
//
//    @Bean
//    public BB bb(){
//        return new BB();
//    }

}

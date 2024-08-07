package org.pmh;

import org.pmh.components.AA;
import org.pmh.components.AABBService;
import org.pmh.conf.AppConf2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConf2.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .toList().forEach(System.out::println);

        AA aa = applicationContext.getBean(AA.class);
        aa.doPrint();

        AABBService aabbService = applicationContext.getBean(AABBService.class);
        aabbService.doPrint();

    }

}

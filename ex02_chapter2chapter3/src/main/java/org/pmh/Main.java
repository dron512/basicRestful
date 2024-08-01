package org.pmh;


import org.pmh.components.Car;
import org.pmh.components.Engine;
import org.pmh.components.AA;
import org.pmh.conf.AppConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// alt + 1 <<- 브라우저
// esc 소스 영역으로
// alt + insert

/*
@Cofiguration 환경설정
@ComponentScan 패키지를 검사 해서
 @Component객체

 @Controller
 @Service
 @Repository

 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConf.class);

        Car car1 = applicationContext.getBean(Car.class);
        Car car2 = applicationContext.getBean(Car.class);

        System.out.println(car1);
        System.out.println(car2);

        System.out.println(car1==car2);

        AA a1 = applicationContext.getBean(AA.class);
        System.out.println(a1);
        AA a2 = applicationContext.getBean(AA.class);
        System.out.println(a2);

//        Car car3 = new Car(new Engine("X5"));
//        Car car4 = new Car(new Engine("X6"));
//
//        System.out.println(car3);
//        System.out.println(car4);
//
//        car3.setEngine(new Engine("X7"));
//
//        System.out.println(car3);
//        System.out.println(car4);


//        System.out.println(car3==car4);

    }
}

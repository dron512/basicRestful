package org.pmh.conf;

import org.pmh.components.AA;
import org.pmh.components.Car;
import org.pmh.components.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.pmh.components")
public class AppConf {

}

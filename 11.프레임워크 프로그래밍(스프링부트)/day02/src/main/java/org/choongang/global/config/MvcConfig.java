package org.choongang.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableJpaAuditing
@Configuration
@EnableScheduling
public class MvcConfig implements WebMvcConfigurer {

}

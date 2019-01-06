package pl.softwareplant.report;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ReportApplicationConfiguration implements WebMvcConfigurer {

    @Bean
    public DozerBeanMapper dozerBean() {
        return new DozerBeanMapper();
    }
}
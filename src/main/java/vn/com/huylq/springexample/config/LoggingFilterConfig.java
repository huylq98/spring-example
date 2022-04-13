package vn.com.huylq.springexample.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.com.huylq.springexample.filter.CustomURLFilter;

@Configuration
@RequiredArgsConstructor
public class LoggingFilterConfig {
    private final CustomURLFilter customURLFilter;

    @Bean
    public FilterRegistrationBean<CustomURLFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(customURLFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }
}

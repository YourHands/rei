package com.bynow.rei.rest.config;

import com.bynow.rei.core.config.DefaultFastjsonConfig;
import com.bynow.rei.rest.config.properties.RestProperties;
import com.bynow.rei.rest.modular.auth.converter.WithSignMessageConverter;
import com.bynow.rei.core.config.DefaultFastjsonConfig;
import com.bynow.rei.rest.config.properties.RestProperties;
import com.bynow.rei.rest.modular.auth.converter.WithSignMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 签名校验messageConverter
 *
 * @author fengshuonan
 * @date 2017-08-25 16:04
 */
@Configuration
public class MessageConverConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "sign-open", havingValue = "true", matchIfMissing = true)
    public WithSignMessageConverter withSignMessageConverter() {
        WithSignMessageConverter withSignMessageConverter = new WithSignMessageConverter();
        DefaultFastjsonConfig defaultFastjsonConfig = new DefaultFastjsonConfig();
        withSignMessageConverter.setFastJsonConfig(defaultFastjsonConfig.fastjsonConfig());
        withSignMessageConverter.setSupportedMediaTypes(defaultFastjsonConfig.getSupportedMediaType());
        return withSignMessageConverter;
    }
}
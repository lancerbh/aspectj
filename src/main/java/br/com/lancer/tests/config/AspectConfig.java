package br.com.lancer.tests.config;

import br.com.lancer.tests.aspect.ExecutionAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    public ExecutionAspect interceptor() {
        return Aspects.aspectOf(ExecutionAspect.class);
    }

}

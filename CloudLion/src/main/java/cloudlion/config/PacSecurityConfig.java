package cloudlion.config;

import org.pac4j.core.config.Config;
import org.pac4j.springframework.web.RequiresAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "org.pac4j.springframework.web")
public class PacSecurityConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Config config;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequiresAuthenticationInterceptor(config, "Google2Client")).addPathPatterns("/google/*").excludePathPatterns("/google/notprotected.html");
        registry.addInterceptor(new RequiresAuthenticationInterceptor(config, "Google2Client", "admin")).addPathPatterns("/googleadmin/*");
        registry.addInterceptor(new RequiresAuthenticationInterceptor(config, "Google2Client", "custom")).addPathPatterns("/googlecustom/*");
        //registry.addInterceptor(new RequiresAuthenticationInterceptor(config, "FormClient")).addPathPatterns("/form/*");
    }
}

package site.gabriellima.bureau.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    private static final String resourceId = "resources";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/oauth/**").permitAll()
            .antMatchers("/basea/**").hasRole("ADMIN")
            .antMatchers("/baseb/**").hasAnyRole("ADMIN", "CREDITO")
            .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
      resources.resourceId(resourceId);
    }
}
package com.unibuc.assig.FinalProject.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Profile("postgres")
public class SecurityJdbcConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select username,password,enabled "
                            + "from participant "
                            + "where username = ?")
                    .authoritiesByUsernameQuery("select username, authority "
                            + "from authorities "
                            + "where username = ?");
        }*/

    //   @Autowired
    //   JpaUserDetailsService userDetailsService;

    //   @Override
    //   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //       auth.userDetailsService(userDetailsService);
    //   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/participant/**").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/product/new").hasRole("ADMIN")
                .antMatchers("/product/delete/*").hasRole("ADMIN")
                .antMatchers("/product").hasRole("ADMIN")
                .antMatchers("/product/info/*").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/product/list").hasAnyRole("GUEST","ADMIN")
                .and()
                .formLogin().loginPage("/showLogInForm")
                .loginProcessingUrl("/authUser")
                .failureUrl("/login-error").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

    }


}


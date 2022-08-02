package com.practice.contactmanager.conguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.practice.contactmanager.Dao.UserDetailService;

@Configuration
@EnableWebSecurity
public class myConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailService getUserDetailService() {
        return new UserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());

        return daoAuthenticationProvider;
    }

    //// configure method.....
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // http.authorizeRequests().antMatchers("/user/**").hasRole("USER")
    // .antMatchers("/admin/**").hasRole("ADMIN")
    // .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
    // return http.build();
    // }

    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    // return (web) -> web.ignoring().antMatchers("/images/**", "/js/**",
    // "/webjars/**");
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(
    // AuthenticationConfiguration authConfig) throws Exception {
    // return authConfig.getAuthenticationManager();
    // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll().and().formLogin().loginPage("/login")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/user/profile")
                .and().csrf().disable();

    }

}

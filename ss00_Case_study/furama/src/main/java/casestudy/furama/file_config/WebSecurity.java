package casestudy.furama.file_config;

import casestudy.furama.security.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encode pass..*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll() //Khi login bằng URL /login thì khi thành công sẽ vào '/student
                .and()
                .authorizeRequests()
                .antMatchers("/home","/","/**/*.js", "/**/*.css", "/**/*.jpg","/**/*.map", "/**/*.gif","/**/*.jpeg","/**/*.png").permitAll() /*không cần xác thực.*/
                .antMatchers("/**/*.min.css").permitAll() /*không cần xác thực.*/
                .antMatchers("/contract/show").hasRole("EMPLOYEE")
                .antMatchers("/contract/create").hasRole("EMPLOYEE")
                .antMatchers("/customer/showcustomerlist").hasRole("EMPLOYEE")
                .antMatchers("/service/showservice").hasRole("EMPLOYEE")
                .antMatchers("/service/createservice/*").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/employee/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/**").hasRole("ADMIN")

                .anyRequest().authenticated(); // Tất cả request gọi lên server đều phải login

        http.logout().logoutSuccessUrl("/login");
        /*Cấu hình remember me*/
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/templates/error/error403.html");

    }

    /*Cấu hình nơi lưu thông tin login*/
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }

}

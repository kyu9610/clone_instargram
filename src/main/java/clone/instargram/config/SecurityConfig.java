package clone.instargram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder(){
        // 패스워드 암호화
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        http.csrf().disable();

        http.authorizeRequests()
                //.antMatchers("/main", "/item/**").authenticated() // 이 주소로 시작되면 인증이 필요
                .anyRequest().permitAll() // 그게 아닌 모든 주소는 인증 필요 없음
                .and()
                .formLogin()
                .loginPage("/login") // 인증필요한 주소로 접속하면 이 주소로 이동시킴
                .loginProcessingUrl("/login") // 스프링 시큐리티가 로그인 자동 진행 POST방식으로 로그인 진행
                .defaultSuccessUrl("/main"); // 로그인이 정상적이면 "/" 로 이동
//                .antMatchers("/login","/signup").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true);
    }
}

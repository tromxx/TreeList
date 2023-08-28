package com.TreeListProject.TreeList.config;

import com.TreeListProject.TreeList.constant.UserRole;
import com.TreeListProject.TreeList.oauth.MyAccessDeniedHandler;
import com.TreeListProject.TreeList.oauth.MyAuthenticationEntryPoint;
import com.TreeListProject.TreeList.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfiguration {

    private final PrincipalOauth2UserService principalOauth2UserService;
    /**
    * WebSecurityConfigurerAdapter가 Spring Security 5.7.0-M2부터 deprecated 됨.
    * component-based security configuration으로의 사용자 전환 격려 위함.
    * 따라서 아래와 같이 bean으로 등록하여 사용.
    */
    @Bean
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeRequests()
              // 인증
              .antMatchers("/security-login/info").authenticated()
              // 인가
              .antMatchers("/security-login/admin/**").hasAuthority(UserRole.USER.name())
              .anyRequest().permitAll()
              .and()

              // Form Login 방식 적용
              .formLogin()
              // 로그인 할 때 사용할 파라미터들
              .usernameParameter("loginId")
              .passwordParameter("password")
              .loginPage("/security-login/login")     // 로그인 페이지 URL
              .defaultSuccessUrl("/security-login")   // 로그인 성공 시 이동할 URL
              .failureUrl("/security-login/login")    // 로그인 실패 시 이동할 URL
              .and()
              .logout()
              .logoutUrl("/security-login/logout")
              .invalidateHttpSession(true).deleteCookies("JSESSIONID")

              // OAuth 로그인
              .and()
              .oauth2Login()
              .loginPage("/security-login/login")
              .defaultSuccessUrl("/security-login")
              .userInfoEndpoint()
              .userService(principalOauth2UserService)
      ;
      // 로그인 에러시
      http
              .exceptionHandling()
              .authenticationEntryPoint(new MyAuthenticationEntryPoint())
              .accessDeniedHandler(new MyAccessDeniedHandler());
    }
}

//        .oauth2Login()	OAuth2기반으로 로그인 할 경우의 설정을 추가할 수 있다.
//        OAuth2LoginConfigurer를 불러온다
//        .loginPage(String url)	로그인 페이지 경로를 호출한다.
//        .defaultSuccessUrl(String url)	로그인 성공 시 url로 이동한다.
//        .failureUrl(String url)	로그인 실패 시 url로 이동한다.
//        .userInfoEndpoint()	로그인 성공 후 사용자 정보를 가져온다
//        .userService(Class)	userInfoEndpoint()로 가져온 사용자 정보를 처리할 때 사용한다.

//        .authorizeRequests()	Security처리에 HttpServletRequest를 이용한다
//        ExpressionUrlAuthorizationConfigurer을 불러온다.
//        .antMatchers("경로")	특정 경로 지정
//        .anyRequest()	설정한 경로 외의 모든 경로
//        .authenticated()	인증된 사용자만 접근할 수 있다
//        .permitAll()	인증없이 접근할 수 있다
//        .denyAll()	인증없이는 접근할 수 없다
//        .access(String str)	SpEL표현식의 결과가 true이면 접근할 수 있다
//        .hasRole(String role)	사용자가 해당되는 Role이 있다면 접근할 수 있다
//        .hasAnyRole(String role)	사용자가 가진 Role 중 해당되는 Role이 하나라도 존재한다면 접근할 수 있다
//        .anonymous()	익명사용자가 접근할 수 있다
//        .rememberMe()	rememberMe인증 사용자가 접근할 수 있다.
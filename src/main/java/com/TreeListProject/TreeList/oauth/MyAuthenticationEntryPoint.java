package com.TreeListProject.TreeList.oauth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
                       AuthenticationException authException) throws IOException, ServletException {
    // 인증되지 않은 사용자가 접근했을 때의 처리 로직
    // 예: 로그인 페이지로 리다이렉션 또는 에러 메시지 반환
  }
}

package com.TreeListProject.TreeList.sequrity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptConfig {

//    비밀번호를 암호화 해주는 BCRyptPasswordEncoder가 존재
//    이를 Spring에 등록해놓고 비밀번호 암호화, 비밀번호 체크할 때 사용하면 됨
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

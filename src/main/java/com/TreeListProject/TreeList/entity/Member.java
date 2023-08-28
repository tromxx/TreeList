package com.TreeListProject.TreeList.entity;

import com.TreeListProject.TreeList.constant.UserRole;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Builder
@Getter @ToString
@NoArgsConstructor(force = true)
@Table(name = "Member")

public class Member {
    @Id
    @Column(name = "Member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Member_loginId")
    @Nullable
    private String loginId;

    @Column(name = "Member_Email")
    @Nullable
    private String email;

    @Column(name = "Member_name")
    @Nullable
    private String name;

    @Column(name = "Member_pwd")
    @Nullable
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    // OAuth 로그인에 사용
    private String provider;
    private String providerId;

    public Member(Long id,String loginId, String email, String name, String password,
                  UserRole userRole, String provider, String providerId) {
        this.id = id;
        this.loginId = loginId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
        this.provider = provider;
        this.providerId = providerId;
    }
}

package com.TreeListProject.TreeList.entity;

import com.TreeListProject.TreeList.constant.UserRole;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter @ToString
@NoArgsConstructor(force = true)
@Table(name = "Member")

public class Member {
    @Id
    @Column(name = "Member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Builder
    public Member(Long id, String email, String name, String password, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }
}

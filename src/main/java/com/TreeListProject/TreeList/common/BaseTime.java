package com.TreeListProject.TreeList.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 부모 클래스가 자식엔티티에게 매핑정보를 공유하기위해 사용/ BaseTime 클래스를 다른 엔티티에서 상속받아서 사용
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {
    @CreatedDate // 자동으로 해당 필드에 생성시간 기록
    @Column(updatable = false) // 엔티티가 수정될때 업데이트 x
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티가 수정될때 수정시간을 기록
    @Column(updatable = true) // 엔티티 수정될때 업데이트 o
    private LocalDateTime updatedDate;
}

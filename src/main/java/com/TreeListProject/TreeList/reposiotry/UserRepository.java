package com.TreeListProject.TreeList.reposiotry;

import com.TreeListProject.TreeList.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
  boolean existsByLoginId(String loginId);
  boolean existsByNickname(String nickname);
  Optional<Member> findByLoginId(String loginId);
}

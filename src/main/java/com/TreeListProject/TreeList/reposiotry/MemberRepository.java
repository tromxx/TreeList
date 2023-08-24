package com.TreeListProject.TreeList.reposiotry;

import com.TreeListProject.TreeList.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}

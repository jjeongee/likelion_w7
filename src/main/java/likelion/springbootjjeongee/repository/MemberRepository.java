package likelion.springbootjjeongee.repository;

import likelion.springbootjjeongee.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MemberRepository extends JpaRepository<Member,Long>{}


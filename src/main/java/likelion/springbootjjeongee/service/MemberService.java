package likelion.springbootjjeongee.service;

import likelion.springbootjjeongee.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    public void save(Member member);
    public Member findById(Long id);

    public List<Member> findAll();
}

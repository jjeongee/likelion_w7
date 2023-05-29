package likelion.springbootjjeongee.domain;

import jakarta.persistence.*;
import lombok.Data; //수정 왜한거지
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    @Embedded
    private Address address;

    public static Member createMember(String name,Address address){
        Member member = new Member();
        member.name = name;
        member.address=address;
        return member;
    }
}

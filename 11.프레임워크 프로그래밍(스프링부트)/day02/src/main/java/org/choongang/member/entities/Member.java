package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.board.entities.BoardData;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "CH_MEMBER")
//@Table(indexes ={
//@Index(name = "idx_created_at_desc",columnList = "createdAt DESC"),
//@Index(name = "uq_email_password", columnList = "email,password",unique = true)})
public class Member extends BaseEntity {
    @Id @GeneratedValue()
    private Long seq;

    @Column(length = 60, unique=true, nullable=false)
    private String email;

    @Column(length = 65, nullable=false)
    private String password;

    @Column(length = 40, nullable=false)
    private String userName;

    //@Lob
    @Transient
    private String introduction;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_seq")
    private MemberProfile profile;


    @ToString.Exclude // ToString 추가 배제
    @OneToMany(mappedBy = "member" ,cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<BoardData> items;

}

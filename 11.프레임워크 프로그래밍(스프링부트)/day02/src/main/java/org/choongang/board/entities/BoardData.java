package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor

public class BoardData extends BaseEntity {
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne // member_seq(엔티티명_기본키)
    @JoinColumn(name = "mSeq")
    private Member member;

    @Column(nullable = false)
    private String subject;

    @Lob
    private String content;

}

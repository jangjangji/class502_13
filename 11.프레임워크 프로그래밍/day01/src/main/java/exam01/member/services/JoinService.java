package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Service
public class JoinService {
    private final JoinValidator validator;

    private final MemberDao memberDao;
    // 의존 관계 - 없으면 객체 생성 x
//   public JoinService(JoinValidator validator, MemberDao memberDao) {
//        this.validator = validator;
//        this.memberDao = memberDao;
//    }
    public void process(RequestJoin form){
        validator.check(form);

        //데이터 영구 저장 DAO(Data Access Object)
        Member member = Member.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .userName(form.getUserName())
                .regDt(LocalDateTime.now())
                .build();
        memberDao.register(member);
    }
}

package member.services;

import global.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import mappers.member.MemberMapper;
import member.controllers.RequestJoin;
import member.entities.Member;
import member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinValidator validator;
    private final MemberMapper mapper;
    public void process(RequestJoin form){
        validator.check(form);
        //비밀번호 해쉬화후 db저장
        String hash = BCrypt.hashpw(form.getPassword(),BCrypt.gensalt(12));

        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .build();
        int result = mapper.register(member);
        if (result < 1){
            throw  new BadRequestException("실패");
        }
    }
}

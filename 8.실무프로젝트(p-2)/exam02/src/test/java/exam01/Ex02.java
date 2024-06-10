package exam01;

import configs.DBConn;
import mappers.MemberMapper;
import member.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Ex02 {

    private SqlSession session = DBConn.getSession();

    @Test
    void test1() {
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userId("USER" + System.currentTimeMillis())
                .userPw("123456")
                .userNm("사용자..")
                .mobile("01012341234")
                .build();
        int cnt = mapper.register2(member);
        System.out.println(cnt);
        System.out.println(member);
    }

    @Test
    void test2() {
        MemberMapper mapper = session.getMapper(MemberMapper.class);

        Member member = Member.builder()
                .userId("USER01")
                .userPw("123456")
                .userNm("(수정)사용자03")
                .mobile("01000000000")
                .build();

        int cnt = session.update("mappers.MemberMapper.modify", member);
        System.out.println(cnt);
    }

    @Test
    void test3() {
        Member member = Member.builder()
                .userId("USER01")
                .build();
        int cnt = session.delete("mappers.MemberMapper.delete", member);
        System.out.println(cnt);
    }

    @Test
    void test4() {
        MemberMapper mapper = session.getMapper(MemberMapper.class);

        int cnt = mapper.delete("USER03");
        int cnt2 = mapper.delete2("USER04");

        System.out.println(cnt);
        System.out.println(cnt2);
    }
}
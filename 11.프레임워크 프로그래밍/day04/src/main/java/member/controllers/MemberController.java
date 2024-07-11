package member.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(@RequestParam(value = "name",defaultValue = "기본값")String name){
        return "member/join";
    }
    @PostMapping("/member/join")
    public String joinPs(RequestJoin form){
        System.out.println(form);
        return "member/join";
    }
}

package kimshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // 페이지 전환용으로만 사용

    @GetMapping("/")
    public String main() {return "main";}
}

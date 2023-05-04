package com.goott.pj3.common.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*23.04.25 조준모 최초작성
   메인페이지 연결
   메인에는 따로 RequestMapping은 추가하지 않음.*/
@Controller
public class mainController {
    @RequestMapping("/")
    public String main() {
        return "index";
    }

}

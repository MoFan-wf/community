package life.mofan.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 莫凡编程之路
 * @create 2021-06-25-16:56
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name,Model model){
        model.addAttribute("name",name);
        return  "hello";
    }
}

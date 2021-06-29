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
public class IndexController {

    @GetMapping("/")
    public String index(){ return "index"; }
}
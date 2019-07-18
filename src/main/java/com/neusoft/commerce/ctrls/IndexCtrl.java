package com.neusoft.commerce.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Controller
public class IndexCtrl {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}

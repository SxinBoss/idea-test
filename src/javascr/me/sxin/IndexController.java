package me.sxin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mereyu on 2016-05-07.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){

        return "index";
    }
}

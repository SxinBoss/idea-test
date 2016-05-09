package me.sxin;

import me.test.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mereyu on 2016-05-07.
 */
@Controller
public class IndexController {

    @Autowired
    TestBean tb;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void index(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().write(tb.getName()+"<hr />"+tb.getAge());
        //return "index";
    }
}

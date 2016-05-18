package com.escnsoft.controller;

import db.SxinPool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by merey on 2016-05-15.
 */
@Controller
public class LoginAuth {

    @RequestMapping(value = "loginAuth", method = RequestMethod.GET)
    public void loginAuth(HttpServletResponse rp) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("db.SxinPool");
   /*     Connection tmp = SxinPool.getConnection();
        tmp.createStatement().executeQuery("select sleep(10)");
        SxinPool.retConnection(tmp);*/
    }
}

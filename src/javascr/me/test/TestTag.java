package me.test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by merey on 2016-05-08.
 */
public class TestTag extends TagSupport{
    @Override
    public int doEndTag() throws JspException {
        JspWriter jw = pageContext.getOut();
        try {
            jw.write("hello Test!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}

package com.gus.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.net.URLDecoder;

//需要在WEB-INF文件夹下来一个tld文件
public class URLDecodeTag extends SimpleTagSupport {
    private String content;
    private String encode;

    public void setContent(String content) {
        this.content = content;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String str = URLDecoder.decode(content, encode == null ? "utf-8" : encode);
//        到浏览器做输出
        getJspContext().getOut().write(str);
    }
}

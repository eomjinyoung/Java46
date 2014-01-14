package spms.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTagHandler extends SimpleTagSupport {
	String name;

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		String v1 = (String)this.getJspContext().getAttribute("v1");
		JspWriter out = this.getJspContext().getOut();
		out.println(name + "님 반갑습니다.");
		out.println("<h2>" + v1 + "</h2>");
	}
}






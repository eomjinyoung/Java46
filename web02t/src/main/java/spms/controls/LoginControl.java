package spms.controls;

import java.util.Map;

import spms.annotations.Component;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/auth/login.do")
public class LoginControl implements PageControl {
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
  public String execute(Map<String, Object> paramMap,
      Map<String, Object> resultMap) throws Exception {
		String email = (String)paramMap.get("email");
		if (email == null) { //GET 요청
      Map<String,String> cookieMap = 
					(Map<String,String>)paramMap.get("cookieMap");
		  	String cookieEmail = cookieMap.get("email");
		  	if (cookieEmail != null) {
	  			resultMap.put("email", cookieEmail);
	  			resultMap.put("checkSaveEmail", "checked");
	  		}
		  	resultMap.put("pageTitle", "로그인");
		  	return "/auth/login.jsp";
		  	
		} else { //POST 요청
			String password = (String)paramMap.get("password");
			String saveEmail = (String)paramMap.get("saveEmail");

			if (saveEmail != null) {
	  			resultMap.put("cookie:email", email);
	  		} else {
	  			resultMap.put("cookie:email", "null,0");
	  		}
  		
			Member member = memberDao.selectByEmailPassword(email, password);
			resultMap.put("pageTitle", "로그인");
			
			if (member != null) {
				resultMap.put("session:member", member);
				return "redirect:" + 
						(String)paramMap.get("contextPath") + 
						"/main.do";
			} else {
				resultMap.put("Refresh", 
						"1;url=" + 
						(String)paramMap.get("contextPath") + 
						"/auth/login.do");
				return "/auth/loginFail.jsp";
			}
		}
  }
}











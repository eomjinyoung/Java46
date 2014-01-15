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

	@Override
  public String execute(Map<String, Object> paramMap,
      Map<String, Object> resultMap) throws Exception {
		String email = (String)paramMap.get("email");
		if (email == null) { //GET 요청
			Map<String,String> cookieMap = (Map)paramMap.get("cookieMap");
		  	for(String cookieName : cookieMap.keySet()) {
	  			if (cookieName.equals("email")) {
	  				resultMap.put("email", cookieMap.get(cookieName));
	  				resultMap.put("checkSaveEmail", "checked");
	  				break;
	  			}
	  		}
		  	return "/auth/login.jsp";
		  	
		} else { //POST 요청
			String password = (String)paramMap.get("password");
			String saveEmail = (String)paramMap.get("saveEmail");
			/*
	  		if (saveEmail != null) {
	  			response.addCookie(new Cookie("email", email));
	  		} else {
	  			Cookie c = new Cookie("email", null);
	  			c.setMaxAge(0); // 쿠키를 삭제하도록 설정
	  			response.addCookie(c);
	  		}
	  		*/
  		
			Member member = memberDao.selectByEmailPassword(email, password);
			
			if (member != null) {
				resultMap.put("session:member", member);
				return "redirect:../index.jsp";
			} else {
				return "/auth/loginFail.jsp";
			}
		}
  }
}











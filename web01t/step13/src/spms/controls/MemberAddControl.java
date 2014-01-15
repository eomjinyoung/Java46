package spms.controls;

import java.util.Map;

import spms.annotations.Component;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/member/add.do")
public class MemberAddControl implements PageControl {
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> paramMap,
	    Map<String, Object> resultMap) throws Exception {
		Member member = new Member();
		member.setName( (String)paramMap.get("name") );
		member.setEmail( (String)paramMap.get("email") );
		member.setTel( (String)paramMap.get("tel") );
		member.setAge( Integer.parseInt((String)paramMap.get("age")) );
		
		int count = memberDao.insert(member);
		if (count > 0) {
			resultMap.put("message", "등록 성공입니다!");
		} else {
			resultMap.put("message", "등록 실패입니다!");
		}
		
		resultMap.put("Refresh", "1;url=list.do");
		resultMap.put("pageTitle", "회원 등록");
		return "/member/add.jsp";
	}

}

package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberReadControl implements PageControl {
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> paramMap,
	    Map<String, Object> resultMap) throws Exception {
		int no = Integer.parseInt( (String)paramMap.get("no") );
		Member member = memberDao.selectOne(no);
		
		resultMap.put("member", member);
		resultMap.put("pageTitle", "회원 정보");
		return "/member/updateForm.jsp";
	}

}











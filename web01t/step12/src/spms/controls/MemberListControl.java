package spms.controls;

import java.util.ArrayList;
import java.util.Map;

import spms.annotations.Component;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/member/list.do")
public class MemberListControl implements PageControl {
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(
			Map<String, Object> paramMap, Map<String, Object> resultMap)
	    throws Exception {
		
		ArrayList<Member> members = memberDao.selectList();
		resultMap.put("members", members);
		resultMap.put("pageTitle", "회원 목록");
		
		return "/member/list.jsp";
	}

}







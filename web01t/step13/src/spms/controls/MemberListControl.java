package spms.controls;

import java.util.Map;

import spms.annotations.Component;
import spms.dao.MemberDao;

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
		
		resultMap.put("members", memberDao.selectList());
		resultMap.put("pageTitle", "회원 목록");
		
		return "/member/list.jsp";
	}

}







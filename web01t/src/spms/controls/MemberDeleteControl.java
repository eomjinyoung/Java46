package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

public class MemberDeleteControl implements PageControl {
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> paramMap,
	    Map<String, Object> resultMap) throws Exception {
		int count = memberDao.delete(
				Integer.parseInt( (String)paramMap.get("no") ));
		if (count > 0) {
			resultMap.put("message", "삭제 성공입니다.");
		} else {
			resultMap.put("message", "해당 번호의 회원 정보가 없습니다!");
		}
		
		resultMap.put("Refresh", "1;url=list.do");
		resultMap.put("pageTitle", "회원 삭제");
		return "/member/delete.jsp";
	}

}





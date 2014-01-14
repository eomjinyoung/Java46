package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberUpdateControl implements PageControl{
	MemberDao memberDao;
	
	public PageControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
  public String execute(Map<String, Object> paramMap,
      Map<String, Object> resultMap) throws Exception {
		Member member = new Member();
		member.setNo( Integer.parseInt((String)paramMap.get("no")) );
		member.setName( (String)paramMap.get("name") );
		member.setEmail( (String)paramMap.get("email") );
		member.setTel( (String)paramMap.get("tel") );
		member.setAge( Integer.parseInt((String)paramMap.get("age")) );
		
		int count = memberDao.update(member);
		if (count > 0) {
			resultMap.put("message", "변경 성공입니다!");
		} else {
			resultMap.put("message", "해당 번호의 회원 정보를 찾을 수 없습니다!");
		}
		
		resultMap.put("Refresh", "1;url=list.do");
		resultMap.put("pageTitle", "회원 변경");
		
		return "/member/update.jsp";
  }

}








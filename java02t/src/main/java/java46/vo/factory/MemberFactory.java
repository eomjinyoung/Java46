package java46.vo.factory;

import java46.vo.Member;

public class MemberFactory {
	public static Member create() {
		return new Member();
	}
	
	public Member create2() {
		return new Member();
	}
}

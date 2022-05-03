package controller;

import java.util.ArrayList;

public interface MemberController {
	public Member searchMember(String username);
	
	public ArrayList<Member> listMember();
	
	public boolean signUp(Member member, Users users);
	
	public boolean logIn(String username, String passwd);
	
	public void deleteMember(String username);
	
	public boolean modifyProfile(Member member);
}

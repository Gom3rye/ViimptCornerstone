package viimpt.core;

import viimpt.core.member.Grade;
import viimpt.core.member.Member;
import viimpt.core.member.MemberService;
import viimpt.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); //long type이어서 1L 붙여주기
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}

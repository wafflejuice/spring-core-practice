package wafflejuice.core;

import wafflejuice.core.member.Grade;
import wafflejuice.core.member.Member;
import wafflejuice.core.member.MemberService;
import wafflejuice.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

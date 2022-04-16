package wafflejuice.core;

import wafflejuice.core.member.Grade;
import wafflejuice.core.member.Member;
import wafflejuice.core.member.MemberService;
import wafflejuice.core.member.MemberServiceImpl;
import wafflejuice.core.order.Order;
import wafflejuice.core.order.OrderService;
import wafflejuice.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}

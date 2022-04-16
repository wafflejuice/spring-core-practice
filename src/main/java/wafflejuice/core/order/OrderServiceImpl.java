package wafflejuice.core.order;

import wafflejuice.core.discount.DiscountPolicy;
import wafflejuice.core.discount.FixDiscountPolicy;
import wafflejuice.core.discount.RateDiscountPolicy;
import wafflejuice.core.member.Member;
import wafflejuice.core.member.MemberRepository;
import wafflejuice.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;

    // OrderService만 담당해야할 OrderServiceImpl이 직접 DiscountPolicy 객체를 선택하여 생성하고 할당
    // -> DIP 위반. 관심사 분리 필요
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

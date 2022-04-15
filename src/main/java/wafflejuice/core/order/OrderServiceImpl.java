package wafflejuice.core.order;

import wafflejuice.core.discount.DiscountPolicy;
import wafflejuice.core.discount.FixDiscountPolicy;
import wafflejuice.core.discount.RateDiscountPolicy;
import wafflejuice.core.member.Member;
import wafflejuice.core.member.MemberRepository;
import wafflejuice.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

package wafflejuice.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wafflejuice.core.discount.DiscountPolicy;
import wafflejuice.core.member.Member;
import wafflejuice.core.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

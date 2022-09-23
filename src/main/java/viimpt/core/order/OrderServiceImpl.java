package viimpt.core.order;

import viimpt.core.discount.DiscountPolicy;
import viimpt.core.discount.FixDiscountPolicy;
import viimpt.core.member.Member;
import viimpt.core.member.MemberRepository;
import viimpt.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //memberRepository에서 회원 찾아야 하니까 (회원 조회)
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //discountPolicy 필요하니까
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //메모리회원리파지토리와 고정할인정책을 구현체로 생성해서 사용하고 있다.

    @Override //Order입장에서는 discountPolicy 모르니까 단일 책임 원칙 잘 지키며 설계되었다.
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //여러가지 확장성을 생각해서 할인 정책에 회원 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //Order 만들어서 반환해준다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

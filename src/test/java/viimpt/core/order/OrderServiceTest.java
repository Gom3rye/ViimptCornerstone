package viimpt.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import viimpt.core.member.Grade;
import viimpt.core.member.Member;
import viimpt.core.member.MemberService;
import viimpt.core.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L; //Long으로 하면 null을 넣을 수 있는데 long으로 하면 안 됌
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //검증을 soutv로 하는게 아니라 assertions로 하기!
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        //org.assertj를 써야 메서드 체인 ...으로 편하게 테스트를 만들 수 있다.
    }
}

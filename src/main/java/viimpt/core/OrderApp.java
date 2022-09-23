package viimpt.core;

import viimpt.core.member.Grade;
import viimpt.core.member.Member;
import viimpt.core.member.MemberService;
import viimpt.core.member.MemberServiceImpl;
import viimpt.core.order.Order;
import viimpt.core.order.OrderService;
import viimpt.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        //vip 회원 한 명 만들기
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); //memberService를 통해서 얘를 메모리 객체에 넣기
        //(그래야 주문해서 찾아 쓸 수 있으니까)

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order); //toString에 있는 것으로 출력된다.
        //System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}

//물론 이렇게 메인 메소드로 테스트하는 것은 좋지 않다. 자동화된 test를 잘 하는게 중요하다.
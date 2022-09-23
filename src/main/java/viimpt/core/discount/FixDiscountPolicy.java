package viimpt.core.discount;

import viimpt.core.member.Grade;
import viimpt.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 천원 할인
    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){//enum type 은 == 써도 된다.
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}

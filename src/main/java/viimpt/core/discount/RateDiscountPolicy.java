package viimpt.core.discount;

import viimpt.core.member.Grade;
import viimpt.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent / 100; //이 로직 의심스러워,, -> test해보자!
        }else{
            return 0;
        }
    }
}

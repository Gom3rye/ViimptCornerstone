package viimpt.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //VIP를 join 해야 하는데 멤버 서비스가 없으니
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){ //단위 테스트는 정말 빨리 되기 때문에 잘 만드는 것이 중요하다.
        //(여기서 단위 테스트란 스프링이나 컨테이너 도움 없이 순수 자바 코드로만 테스트 하는 것)
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then (검증)
        Assertions.assertThat(member).isEqualTo(findMember); //조인한거랑 찾은거랑 같으면 넣고 빼는 테스트 성공
    }
}

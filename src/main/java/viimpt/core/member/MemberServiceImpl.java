package viimpt.core.member;

public class MemberServiceImpl implements MemberService{

    //= new 전까지는 interface만 만든 것
    private final MemberRepository memberRepository = new MemoryMemberRepository(); //null point exception 발생하지 않게 구현 객체 선택해주기
                  //추상화에도 의존하고                      //구체화에도 의존한다 => BAD, DIP 위반
    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //join에서 save를 호출하면 다형성에 의해
        //MemoryMemberRepository에 있는
        //MemberRepository 인터페이스가 아니라
        //MemoryMemberRepository()에 있는 save 함수가 호출이 될 것
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
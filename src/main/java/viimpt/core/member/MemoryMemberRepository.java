package viimpt.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 저장소니까 Map이 있어야 한다. 동시에 접근하는 동시성 이슈가 있어서 concurrent hash map을 사용해야 하지만 예제니까
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
    //구현체를 인터페이스랑 같은 패키지에 놓는것은 좋지 않지만 그럼 예제가 복잡해지니까
}

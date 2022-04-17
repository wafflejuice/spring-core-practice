package wafflejuice.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Convention: if an interface has only one implementation, name it as {Interface name} + 'Impl'
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired //similar with "ac.getBean(MemberRepository.class)"
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

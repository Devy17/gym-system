package gym.membership.service;

import gym.membership.domain.Membership;
import gym.membership.repo.MembershipRepository;
import java.util.List;

public class MembershipService {

    private static final MembershipRepository membershipRepository = new MembershipRepository();

    // 회원권 조회
    public static List<Membership> getMembershipOptions() {
        return membershipRepository.findAll();
    }
}

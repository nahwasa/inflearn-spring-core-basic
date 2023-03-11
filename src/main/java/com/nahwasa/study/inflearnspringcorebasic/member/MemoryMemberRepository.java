package com.nahwasa.study.inflearnspringcorebasic.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 요구사항 - "회원 데이터는 DB 일수도 있고 외부 시스템일수도 있음 (미확정)"
 * -> 따라서 일단 메모리 저장소
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }
}

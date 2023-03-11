package com.nahwasa.study.inflearnspringcorebasic.member;

/**
 * 요구사항 - "회원을 가입하고 조회 가능"
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}

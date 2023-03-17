package com.develop.liveTogether.application.member.controller;

import com.develop.liveTogether.application.member.dto.request.*;
import com.develop.liveTogether.application.member.service.MemberService;
import com.develop.liveTogether.global.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> joinMember(@Valid @RequestBody JoinRequest request){
        memberService.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request, HttpServletRequest httpServletRequest){
        String memberId = memberService.login(request);

        SessionUtil.createSession(memberId, httpServletRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        SessionUtil.removeSession(session);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/valid/id")
    public ResponseEntity<Void> validateId(@Valid @RequestBody ValidateIdRequest request){
        memberService.isDuplicatedMemberId(request.memberId());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/valid/nickName")
    public ResponseEntity<Void> validateNickname(@Valid @RequestBody ValidateNicknameRequest request){
        memberService.isDuplicatedMemberNickname(request.memberNickname());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/find/id")
    public ResponseEntity<String> findId(@Valid @RequestBody FindIdRequest request){
        String memberId = memberService.findId(request);

        return ResponseEntity.ok(memberId);
    }

    @PostMapping("/find/pw")
    public ResponseEntity<String> findPw(@Valid @RequestBody FindPwRequest request){
        memberService.findPw(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/find/changePw")
    public ResponseEntity<String> findPw(@Valid @RequestBody ChangePwRequest request){
        memberService.changePw(request);

        return ResponseEntity.ok().build();
    }
}

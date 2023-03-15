package com.develop.liveTogether.application.member.controller;

import com.develop.liveTogether.application.member.data.SuccessMessage;
import com.develop.liveTogether.application.member.dto.request.*;
import com.develop.liveTogether.application.member.dto.response.SuccessResponse;
import com.develop.liveTogether.application.member.service.MemberService;
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
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request){
        memberService.login(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/valid/id")
    public ResponseEntity<SuccessResponse> validateId(@Valid @RequestBody ValidateIdRequest request){
        memberService.isDuplicatedMemberId(request.memberId());

        return ResponseEntity.ok(new SuccessResponse(SuccessMessage.AVAILABLE_ID.getMessage()));
    }

    @PostMapping("/valid/nickName")
    public ResponseEntity<SuccessResponse> validateNickname(@Valid @RequestBody ValidateNicknameRequest request){
        memberService.isDuplicatedMemberNickname(request.memberNickname());

        return ResponseEntity.ok(new SuccessResponse(SuccessMessage.AVAILABLE_NICKNAME.getMessage()));
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

}

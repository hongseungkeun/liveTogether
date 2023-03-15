package com.develop.liveTogether.application.member.controller;

import com.develop.liveTogether.application.member.dto.request.FindIdRequest;
import com.develop.liveTogether.application.member.dto.request.JoinRequest;
import com.develop.liveTogether.application.member.dto.request.LoginRequest;
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

    public void logout(){

    }

    @PostMapping("/findId")
    public ResponseEntity<String> findId(@Valid @RequestBody FindIdRequest request){
        String memberId = memberService.findId(request);

        return ResponseEntity.ok(memberId);
    }

    public void findPw(){

    }

}

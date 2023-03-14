package com.develop.liveTogether.application.member.controller;

import com.develop.liveTogether.application.member.dto.JoinRequest;
import com.develop.liveTogether.application.member.dto.LoginRequest;
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

    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request){
        memberService.login(request);

        return ResponseEntity.ok().build();
    }

    public void logout(){

    }

    public void findId(){

    }

    public void findPw(){

    }

}

package com.develop.liveTogether.application.member.controller;

import com.develop.liveTogether.application.member.dto.response.MemberInfoResponse;
import com.develop.liveTogether.application.member.service.MemberMyService;
import com.develop.liveTogether.global.annotation.LoginId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/members/my")
@RequiredArgsConstructor
public class MemberMyPageController {
    private final MemberMyService memberMyService;

    @GetMapping
    public ResponseEntity<MemberInfoResponse> getMyInfo(@LoginId String memberId){
        MemberInfoResponse memberInfo = memberMyService.getMyInfo(memberId);

        return ResponseEntity.ok(memberInfo);
    }
}

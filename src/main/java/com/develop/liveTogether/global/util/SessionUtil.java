package com.develop.liveTogether.global.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    private static final String SESSION_KEY = "memberId";

    private SessionUtil(){

    }

    public static void createSession(String memberId, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();

        createSession(memberId, httpServletRequest.getSession());
    }

    public static void removeSession(HttpSession session) {
        session.invalidate();
    }

    private static void createSession(String memberId, HttpSession session) {
        session.setAttribute(SESSION_KEY, memberId);
    }

}

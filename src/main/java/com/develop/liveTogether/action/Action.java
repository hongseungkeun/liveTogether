package com.develop.liveTogether.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Action {
	public com.develop.liveTogether.action.ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}

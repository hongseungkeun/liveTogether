package com.liveTogether.app.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liveTogether.action.Action;
import com.liveTogether.action.ActionForward;
import com.liveTogether.app.member.dao.MemberDAO;

public class HostDeleteFourthOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ActionForward af = new ActionForward();
		MemberDAO dao = new MemberDAO();
		
		int houseNumber = Integer.parseInt(req.getParameter("houseNumber"));
		dao.roomGuestDelete(houseNumber);
		
		af.setRedirect(true);
		af.setPath(req.getContextPath() + "/member/HostMemberListOk.me");
		return af;
	}

}

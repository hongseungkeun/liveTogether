package com.develop.liveTogether.application.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liveTogether.action.Action;
import com.liveTogether.action.ActionForward;
import com.liveTogether.app.board.dao.BoardDAO;
import com.liveTogether.app.board.dao.FilesDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uploadFolder = req.getSession().getServletContext().getRealPath("/") + "upload";
		int fileSize = 1024 * 1024 * 5;//5M
		HttpSession session = req.getSession();
		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO();
		com.liveTogether.app.board.vo.Board board = new com.liveTogether.app.board.vo.Board();
		ActionForward af = new ActionForward();
		
		//요청객체, 업로드폴더 경로, 파일의 크기, 인코딩 방식, 이름변경정책
		MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		board.setBoardTitle(multi.getParameter("boardTitle"));
		board.setBoardContent(multi.getParameter("boardContent"));
		
		//게시글 추가
		bDao.insert(board);
		
		//파일 추가
		fDao.insert(multi, bDao.getSeq());
		try {Thread.sleep(3000);} catch (InterruptedException e) {;}
		af.setRedirect(true);
		af.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return af;
	}

}

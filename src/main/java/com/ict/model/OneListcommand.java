package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OneListcommand implements command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		VO vo = DAO.getOneList(idx);
		request.setAttribute("vo", vo);
		System.out.println("onelist vo :"+vo.toString());
		System.out.println("onelist idx :"+idx);
		return "view/product_content.jsp";
	}
	
}

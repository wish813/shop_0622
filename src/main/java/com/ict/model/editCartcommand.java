package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;

public class editCartcommand implements command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		MVO mvo = (MVO) request.getSession().getAttribute("mvo");
		String u_idx = mvo.getIdx();

		String s_idx = request.getParameter("idx");
		CVO cvo = new CVO();
		cvo.setS_idx(s_idx);
		cvo.setCount(request.getParameter("su"));
		cvo.setU_idx(u_idx);
		int result = DAO.cupdate(cvo);
		
		
		return "MyController?cmd=showCart";
	}
}

package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;

public class deleteCartcommand implements command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MVO mvo = (MVO) request.getSession().getAttribute("mvo");
		String s_idx = request.getParameter("idx");
		
		String u_idx = mvo.getIdx();
		CVO cvo = new CVO();
		cvo.setS_idx(s_idx);
		cvo.setU_idx(u_idx);
		int result = DAO.cdelete(cvo);
		
		
		return "MyController?cmd=showCart";
	}
}

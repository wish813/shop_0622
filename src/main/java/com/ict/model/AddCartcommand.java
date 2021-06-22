package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;


public class AddCartcommand implements command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String s_idx = request.getParameter("idx");
//		MVO mvo =(MVO) request.getSession().getAttribute("vo");
//		String u_idx = mvo.getIdx(); 
		CVO cvo =  new CVO();
		MVO mvo =(MVO) request.getSession().getAttribute("mvo");
		System.out.println("s_idx : " +s_idx);
		System.out.println("mvo : " +mvo.toString());
		System.out.println("u_idx : " +mvo.getIdx());
		cvo.setS_idx(s_idx);
		cvo.setU_idx(mvo.getIdx());
		int result = DAO.getCart(cvo);		
		
		return "/MyController?cmd=onelist&idx="+s_idx;
	}
}

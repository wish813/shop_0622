package com.ict.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class ShowCartcommand implements command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		List<VO> cartList = new ArrayList<VO>();
		int total = 0;
		MVO mvo =(MVO) request.getSession().getAttribute("mvo");
		String u_idx = mvo.getIdx();
		List<CVO> cvoList = DAO.getCartList(u_idx);
		for(CVO cvo : cvoList) {
			String s_idx = cvo.getS_idx();
			VO vo = DAO.getOneList(s_idx);
			vo.setQuant(Integer.parseInt(cvo.getCount()));
			vo.setTotalPrice(vo.getP_saleprice()*Integer.parseInt(cvo.getCount()));
			total += vo.getTotalPrice();
			cartList.add(vo);
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("total", total);
		return "view/viewcart.jsp";
	}
}

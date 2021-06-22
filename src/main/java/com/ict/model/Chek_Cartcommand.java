package com.ict.model;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class Chek_Cartcommand implements command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String s_idx = request.getParameter("idx");
		MVO mvo = (MVO) request.getSession().getAttribute("mvo");
		System.out.println("checkCart s_idx"+s_idx);
		String u_idx = mvo.getIdx();
		
		List<CVO> cvoList = DAO.checkCart(u_idx);
		Iterator<CVO> it = cvoList.iterator();
		while (it.hasNext()) {
			CVO cvo = (CVO) it.next();
			if (cvo.getS_idx().equalsIgnoreCase(s_idx)) {
				int result =DAO.updateCount(cvo);
				if(result>0) {
				System.out.println("check Cart OK");
				return "/MyController?cmd=onelist&idx="+s_idx;
				}
//				return "view/product_content.jsp";
			}
		}
		
//		request.setAttribute("s_idx", s_idx);
		return "/MyController?cmd=addCart&idx="+s_idx;
	}
}

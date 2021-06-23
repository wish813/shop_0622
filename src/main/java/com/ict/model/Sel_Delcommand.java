package com.ict.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;

public class Sel_Delcommand implements command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String[] slist = request.getParameter("selectDel").split(",");

		MVO mvo = (MVO) request.getSession().getAttribute("mvo");
		List<CVO> list = new ArrayList<CVO>();
		

		for (String s : slist) {
			CVO cvo = new CVO();
			System.out.println("s : " + s);
			cvo.setS_idx(s);
			cvo.setU_idx(mvo.getIdx());
			list.add(cvo);
		}
		for (CVO c : list) {
			System.out.println(c.getS_idx());
			int result = DAO.cdelete(c);
		}

		return "/MyController?cmd=showCart";
		/*
		 * List<CVO> list = new ArrayList<CVO>(); String[] slist =
		 * request.getParameterValues("idxStr"); int result = 0; for (String string :
		 * slist) { System.out.println(string); } String regExp = "^[0-9]+$"; MVO mvo =
		 * (MVO) request.getSession().getAttribute("mvo"); CVO cvo = new CVO(); for
		 * (String s : slist) { System.out.println("s :" + s); if (s.matches(regExp)) {
		 * cvo.setS_idx(s); cvo.setU_idx(mvo.getIdx()); list.add(cvo); } }
		 * System.out.println("selDelComm list" + list);
		 * 
		 * for (CVO c : list) { result += DAO.cdelete(c); } if (result > 0) { return
		 * "/MyController?cmd=showCart"; } return null;
		 */
	}

}

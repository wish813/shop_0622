package com.ict.db;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.ict.db.DAO;

public class DAO {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}

	// 리스트
	public static List<VO> getList(String category) {
		List<VO> list = null;
		list = getSession().selectList("list", category);
		return list;
	}

	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}

	// 로그인
	public static MVO getLogIn(MVO m_vo) {
		MVO mvo = null;
		mvo = getSession().selectOne("login", m_vo);
		return mvo;
	}

	// 상품 등록
	public static int getProductInsert(VO vo) {
		int result = 0;
		result = getSession().insert("product_add", vo);
		ss.commit();
		return result;
	}

	//
	public static int getCart(CVO cvo) {
		int result = 0;
		result = getSession().insert("cart", cvo);
		ss.commit();
		return result;
	}

	public static List<CVO> checkCart(String u_idx) {
		List<CVO> list = null;
		list = getSession().selectList("cartList", u_idx);
		return list;
	} // 상세보기

	public static VO getOnesList(String s_idx) {
		VO vo = null;
		vo = getSession().selectOne("oneslist", s_idx);
		return vo;
	}

	public static int updateCount(CVO cvo) {
		int result = 0;
		result = getSession().update("updateCount", cvo);
		ss.commit();
		return result;
	}

	// 리스트
	public static List<CVO> getCartList(String u_idx) {
		List<CVO> list = null;
		list = getSession().selectList("clist", u_idx);
		return list;
	}
	
	public static int cupdate(CVO cvo) {
		int result = 0;
		result = getSession().update("cupdate", cvo);
		ss.commit();
		return result;
	}
	
	public static int cdelete(CVO cvo) {
		int result = 0;
		result = getSession().delete("cdelete", cvo);
		ss.commit();
		return result;
		
		
	}
	
	
	
}









































package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.AddCartcommand;
import com.ict.model.Admincommand;
import com.ict.model.Chek_Cartcommand;
import com.ict.model.ListCommand;
import com.ict.model.LogOutcommand;
import com.ict.model.Login_OKcommand;
import com.ict.model.Logincommand;
import com.ict.model.OneListcommand;
import com.ict.model.Product_Addcommand;
import com.ict.model.ShowCartcommand;
import com.ict.model.command;
import com.ict.model.deleteCartcommand;
import com.ict.model.editCartcommand;
@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		command comm = null;
		System.out.println("cmd : "+cmd);
		if(cmd.equalsIgnoreCase("list")) {
			comm = new ListCommand();
		}else if(cmd.equalsIgnoreCase("onelist")){
			comm = new OneListcommand();
		}else if(cmd.equalsIgnoreCase("addCart")){
			comm = new AddCartcommand();
		}else if(cmd.equalsIgnoreCase("showCart")){
			comm = new ShowCartcommand();
		}else if(cmd.equalsIgnoreCase("editCart")){
			comm = new editCartcommand();
		}else if(cmd.equalsIgnoreCase("deleteCart")){
			comm = new deleteCartcommand();
		}else if(cmd.equalsIgnoreCase("login")){
			comm = new Logincommand();
		}else if(cmd.equalsIgnoreCase("login_ok")){
			comm = new Login_OKcommand();
		}else if(cmd.equalsIgnoreCase("logout")){
			comm = new LogOutcommand();
		}else if(cmd.equalsIgnoreCase("admin")){
			comm = new Admincommand();
		}else if(cmd.equalsIgnoreCase("product_add")){
			comm = new Product_Addcommand();
		}else if(cmd.equalsIgnoreCase("chek_cart")){
			comm = new Chek_Cartcommand();
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}




























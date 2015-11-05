package com.basket;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.*;
import java.util.*;
import java.text.*;

public class BasketModel implements Model{
	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String no=req.getParameter("no");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		HttpSession session=req.getSession();
		//String id=(String)session.getAttribute("id");
		//String name=(String)session.getAttribute("name");
		
		// DB¿¬µ¿
		BasketDTO d=new BasketDTO();
		d.setNo(Integer.parseInt(no));
		d.setName(name);
		d.setPrice(Integer.parseInt(price));
		
		BasketDAO.basketListData();
		req.setAttribute("no", no);
		req.setAttribute("name", name);
		req.setAttribute("price", price);
		return "cart.do";
	    		
		//return "main/main.jsp";
	}



}

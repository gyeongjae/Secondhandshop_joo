package com.basket;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.util.*;
import java.io.*;

public class BasketDAO {

   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   
   // 데이터 가지고 오기 
   public static List<BasketDTO> basketListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<BasketDTO> list=
			   session.selectList("basketListData",map);
	   session.close();
	   return list;
	   //return ssf.openSession().selectList("boardListData",map);
   }
   
   public static void basketInsert(BasketDTO d)
   {
	   SqlSession session=ssf.openSession(true);
	   session.insert("basketInsert",d);
	   session.close();
   }
}
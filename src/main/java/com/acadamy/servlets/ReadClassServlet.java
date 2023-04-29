package com.acadamy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.learn.entity.EClass;


import org.hibernate.SessionFactory;

import com.acadamy.util.HibernateUtil;
import com.learn.entity.EClass;

/**
 * Servlet implementation class ClassServletCRUD
 */
@WebServlet("/read-a-class")
public class ReadClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body>");
		
		
	 SessionFactory sf=HibernateUtil.buildSessionFactory();
	 Session session = sf.openSession();
	 List<EClass>products =session.createQuery(" from EClass ").list();
	 
	 if(products!=null && products.size()>0) {
		 pw.println("<h1> classes list :- </h1>");
		 pw.println("<style> table,td,th {border :2px solid green;}</style>");
		 pw.println("<table>");
		 pw.println("<tr>");
		 pw.println("<th> Class Name</th>");
		 pw.println("<th> Section Name</th>");
		 pw.println("</tr>");
		 
		 for (EClass p:products) {
			 pw.println("<tr>");
			 pw.println("<td>" +p.getName()+ "</td>");
			 pw.println("<td>"+p.getSection()+"</td>");
			 
			 pw.println("</tr>");
		 }
		 pw.println("</table");
		 
	 }else {
		 pw.println("<center><h1 style='color:red';>there are no records ,please add first</h1></center>");
	 }
	 pw.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

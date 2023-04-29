package com.acadamy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acadamy.util.HibernateUtil;
import com.learn.entity.EClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class DeleteclassServlet
 */
@WebServlet("/delete-a-class")
public class DeleteclassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteclassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the list of classes from the database
        List<EClass> classes = retrieveClasses();

        // Generate HTML code dynamically in the servlet that displays the list of classes as a dropdown menu
        StringBuilder sb = new StringBuilder();
        sb.append("<form method=\"post\">");
        sb.append("<label for=\"class\">Select a class to delete:</label>");
        sb.append("<select name=\"class\" id=\"class\">");
        for (EClass cls : classes) {
            sb.append("<option value=\"" + cls.getId() + "\">" + cls.getName() + "</option>");
        }
        sb.append("</select>");
        sb.append("<button type=\"submit\">Delete Class</button>");
        sb.append("</form>");

        // Write the HTML code to the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Delete Class</title></head><body>");
        out.println(sb.toString());
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classId = request.getParameter("class");

        // Delete the class from the database
        deleteClass(classId);

        // Redirect the user to a success page or display a success message
        response.sendRedirect("delete-class-success.html");
    }

    private List<EClass> retrieveClasses() {
        SessionFactory sf = HibernateUtil.buildSessionFactory();
        Session session = sf.openSession();
        List<EClass> classes = session.createQuery("from EClass").list();
        session.close();
        return classes;
    }

    private void deleteClass(String classId) {
        SessionFactory sf = HibernateUtil.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        EClass cls = session.get(EClass.class, Integer.parseInt(classId));
        if (cls != null) {
            session.delete(cls);
        }
        session.getTransaction().commit();
        session.close();
    }

}

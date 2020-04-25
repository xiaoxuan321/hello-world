package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import dao.JobDAO;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/user/UpdateJobsServlet")
public class UpdateJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  UpdateJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取数据
		request.setCharacterEncoding("utf-8");
		int jid = Integer.parseInt(request.getParameter("jid"));
		String jname = request.getParameter("jname");
		int lowsalary = Integer.parseInt(request.getParameter("lowsalary"));
		int highsalary = Integer.parseInt(request.getParameter("highsalary"));
		//2.处理数据
		JobDAO ddao = new JobDAO();
		ddao.updateJob(jid, jname, lowsalary, highsalary);
		//3.跳转
		response.sendRedirect("QueryJobsServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

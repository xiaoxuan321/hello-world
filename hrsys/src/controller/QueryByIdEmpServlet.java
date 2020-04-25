package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import entity.Department;
import entity.Employee;
import entity.Job;

/**
 * Servlet implementation class QueryByIdDeptServlet
 */
@WebServlet("/user/QueryByIdEmpServlet")
public class QueryByIdEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByIdEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("eid"));
		EmployeeDAO edao = new EmployeeDAO();
		Employee emp = edao.queryByidEmp(eid);
		DepartmentDAO ddao = new DepartmentDAO();
		ArrayList dlist = ddao.queryDept();
		JobDAO jdao = new JobDAO();
		ArrayList jlist = jdao.queryJob();
		HttpSession session = request.getSession();
		session.setAttribute("dlist", dlist);
		session.setAttribute("jlist", jlist);
		session.setAttribute("emp", emp);
		response.sendRedirect("UpdateEmp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

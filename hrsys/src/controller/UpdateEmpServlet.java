package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import dao.EmployeeDAO;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/user/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
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
		int eid = Integer.parseInt(request.getParameter("eid"));
		String ename = request.getParameter("ename");
		int etel = Integer.parseInt(request.getParameter("etel"));
		String eemail = request.getParameter("eemail");
		String eworkdate = request.getParameter("eworkdate");
		int esalary = Integer.parseInt(request.getParameter("esalary"));
		int jid = Integer.parseInt(request.getParameter("jid"));
		int did = Integer.parseInt(request.getParameter("did"));
		//2.处理数据
		EmployeeDAO edao=new EmployeeDAO();
		edao.updateEmp(eid, ename, etel, eemail, eworkdate, esalary, jid, did);
		//3.跳转
		response.sendRedirect("QueryEmpServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

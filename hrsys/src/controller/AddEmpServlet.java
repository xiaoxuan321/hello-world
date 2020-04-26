package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/user/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
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
		int eid =Integer.parseInt(request.getParameter("eid"));
		String ename = request.getParameter("ename");
		String eemail = request.getParameter("eemail");
		int etel =Integer.parseInt(request.getParameter("etel"));
		String eworkdate = request.getParameter("eworkdate");
		int esalary = Integer.parseInt(request.getParameter("esalary"));
		int did = Integer.parseInt(request.getParameter("did"));
		int jid = Integer.parseInt(request.getParameter("jid"));
		
		//2.处理数据
		Employee emp = new Employee();
		emp.setDid(did);
		emp.setJid(jid);
		emp.setEemail(eemail);
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setEsalary(esalary);
		emp.setEworkdate(eworkdate);
		emp.setEtel(etel);
		EmployeeDAO edao = new EmployeeDAO();
		edao.addEmp(emp);
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

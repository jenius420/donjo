package adminService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageMemService;

/**
 * Servlet implementation class DeleteMemServlet
 */
@WebServlet("deleteMem.as")
public class DeleteMemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int flag = Integer.parseInt(request.getParameter("flag"));
		String[] memArr = request.getParameterValues("memArr");
		
		int count = 0;
		
		if(flag == 1) {
			count = new ManageMemService().deleteEmp(memArr);
		}else {
			count = new ManageMemService().deleteOwner(memArr); 
		}
		
		//비동기 처리
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
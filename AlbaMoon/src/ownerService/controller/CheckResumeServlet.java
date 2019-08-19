package ownerService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ownerService.model.service.IncruitService;

/**
 * Servlet implementation class CheckResumeServlet
 */
@WebServlet("/checkResume.os")
public class CheckResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rNum = (int)request.getAttribute("rNum");
		
		int result = new IncruitService().checkResume(rNum);
		
		if(result > 0) {
			request.setAttribute("msg", "처리 성공");	
		}else {
			request.setAttribute("msg", "처리 실패");
		}
		
		response.sendRedirect("manageEmp.os");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
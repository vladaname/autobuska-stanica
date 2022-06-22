package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.LinijaManager;
import model.Korisnik;

/**
 * Servlet implementation class CreateLinijaSERVLET
 */
@WebServlet("/CreateLinijaSERVLET")
public class CreateLinijaSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateLinijaSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/CreateLinijaJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nazivLinije = request.getParameter("nazivLinije");
		String opisLinije = request.getParameter("opisLinije");
		
//		Korisnik k = request.getSession().setAttribute("korisnik", k);
		String message = "";
		
		LinijaManager lm = new LinijaManager();
		if(lm.findLinijaByName(nazivLinije) != null) {
			message = message + " linija postoji ";
		}
		else {
			lm.createLinija(nazivLinije, opisLinije);
			response.sendRedirect("CreateRedVoznjeSERVLET");
			return;
		}
		
	}

}

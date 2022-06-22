package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KorisnikManager;
import model.Korisnik;

/**
 * Servlet implementation class RegistrationSERVLET
 */
@WebServlet("/RegistrationSERVLET")
public class RegistrationSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationSERVLET() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RegistrationJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");
		String adresa = request.getParameter("adresa");
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String passConfirm = request.getParameter("passConfirm");

		String message = "";

		if (!pass.equals(passConfirm)) {
			message = message + "ponovite password";
		}
		KorisnikManager km = new KorisnikManager();

		if (km.findByTel(telefon) != null) {
			message = message + "telefon postoji";
		} else {
			message = "";
		}
		if (km.findByEmail(email) != null) {
			message = message + "email postoji";
		} else {
			message = "";
		}
		if (!message.equals("")) {
			request.getSession().setAttribute("message", "Dogodila se greska: " + message);
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RegistrationJSP.jsp");
			rd.forward(request, response);
		} else {
			km.createKorisnik(ime, prezime, telefon, email, username, passConfirm);
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginJSP.jsp");
			rd.forward(request, response);
		}

	}

}

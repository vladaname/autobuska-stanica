package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RedVoznjeManager;

/**
 * Servlet implementation class CreateRedVoznje2SERVLET
 */
@WebServlet("/CreateRedVoznje2SERVLET")
public class CreateRedVoznje2SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRedVoznje2SERVLET() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idVoznje = request.getParameter("idVoznje");
		String dolazakVreme = request.getParameter("dolazakVreme");
		String polazakVreme = request.getParameter("polazakVreme");

		int idV = Integer.parseInt(idVoznje);

		String date = "2012-07-10";
		String dolazakTime = date + " " + dolazakVreme + ":00";
		String polazakTime = date + " " + polazakVreme + ":00";
		System.out.println(dolazakTime);
		System.out.println(polazakTime);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dolazak = new java.util.Date();
		java.util.Date polazak = new java.util.Date();
		try {
			dolazak = sdf.parse(dolazakTime);
			polazak = sdf.parse(polazakTime);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		String deoNedelje = request.getParameter("deoNedelje");
		RedVoznjeManager rvm = new RedVoznjeManager();
		
		if (deoNedelje.equals("radniDan")) {
			rvm.createRedVoznjeRadniDan(dolazak, polazak, idV);

		} if (deoNedelje.equals("subota")) {
			rvm.createRedVoznjeSubota(dolazak, polazak, idV);

		} if (deoNedelje.equals("nedelja")) {
			rvm.createRedVoznjeNedelja(dolazak, polazak, idV);
		}
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ListaLinijaJSP.jsp");
		rd.forward(request, response);
	}

}

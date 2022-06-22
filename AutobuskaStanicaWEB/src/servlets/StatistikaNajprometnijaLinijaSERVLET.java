package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.ocsp.Req;

import managers.StatistikaManager;

/**
 * Servlet implementation class StatistikaNajprometnijaLinijaSERVLET
 */
@WebServlet("/StatistikaNajprometnijaLinijaSERVLET")
public class StatistikaNajprometnijaLinijaSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatistikaNajprometnijaLinijaSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatistikaManager sm = new StatistikaManager();
		
		List<Object[]> podaci = sm.statistikaRedVoznje();
		request.getSession().setAttribute("podaci", podaci);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/StatistikaNajprometnijaLinijaJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

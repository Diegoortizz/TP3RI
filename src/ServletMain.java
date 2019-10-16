
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.*;
import org.apache.lucene.analysis.Analyzer;

import tp3.*;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMain() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comment = request.getParameter("textareadata");
		String action = request.getParameter("submit");

		System.out.println(action);
		if (action == null) {
			request.getRequestDispatcher("/test.jsp").forward(request, response);
		} else {
			comment = request.getParameter("textareadata");
			System.out.println("comment : " + comment);

			/*
			 * travail TP RI qui doit retourner les titres les plus probables d'être liés au
			 * paragraphe donné en entrée
			 */

			ParagraphToKeyword ptk = new ParagraphToKeyword(comment);
			ArrayList<ArrayList<String>> z = ptk.computeKeywords();
//			System.out.println("here" + " " + z);
			TPRI3 ri = new TPRI3();
			String[] result;
			result = ri.query2(z.get(0), z.get(1));

			for (int i = 0; i < result.length; i++) {
				System.out.println("résultats : " + result[i]);
			}

			request.setAttribute("columnHeaders", result);
			request.setAttribute("text", comment);
			request.getRequestDispatcher("/test.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}

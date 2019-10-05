

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String comment = request.getParameter("textareadata") ;
        String action = request.getParameter("submit") ;
        
        
        System.out.println(action);
        if (action == null) {
        	request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
        	System.out.println(comment);
        	
        	/* travail TP RI qui doit retourner les titres les plus probables d'être liés au paragraphe donné en entrée */
            
        	String[] columnHeaders = {"<a href=\"http://fr.wikibooks.org\">Lien vers Wikilivres</a>", " <a href=\"https://www.w3schools.com/html/\">Visit our HTML tutorial</a> "};
            request.setAttribute("columnHeaders", columnHeaders);
        	
            request.setAttribute("text", comment); // on doit remplacer le comment par une liste de href par exemple
        	
        	
        	
        	
        	
        	
        	
        	request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        
        
        
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);	
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);	
        }

}

package fr.eni.javaee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.bll.CategorieManager;

/**
 * Servlet implementation class ServletCategories
 */
@WebServlet("/ServletCategories")
public class ServletCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletCategories() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager listeCategories = new CategorieManager();
		request.setAttribute("listeCategories", listeCategories.selectionnerToutesLesCategories());
		if (listeCategories.selectionnerToutesLesCategories().isEmpty()) {
			System.out.println("c'est la merde");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		}

}

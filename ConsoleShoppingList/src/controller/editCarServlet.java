package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarItem;

/**
 * Servlet implementation class editCarServlet
 */
@WebServlet("/editCarServlet")
public class editCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarItemHelper car2 = new CarItemHelper();
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		Integer amount = Integer.parseInt(request.getParameter("amount"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CarItem carToUpdate = car2.searchForCarById(tempId);
		
		carToUpdate.setModel(model);
		carToUpdate.setColor(color);
		carToUpdate.setAmount(amount);
	
		car2.updateItem(carToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		
	}

}

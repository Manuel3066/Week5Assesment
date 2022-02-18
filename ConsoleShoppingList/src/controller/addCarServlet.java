package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarItem;

/**
 * Servlet implementation class addCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String amount = request.getParameter("amount");
		
		CarItem car = new CarItem(model,color,Integer.parseInt(amount));
		CarItemHelper car2 = new CarItemHelper();
		car2.insertItem(car);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}

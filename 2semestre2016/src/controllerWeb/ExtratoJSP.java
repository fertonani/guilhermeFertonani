package controllerWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.Extrato;
import model.Login;
import util.JSonFacade;

/**
 * Servlet implementation class ExtratoJSP
 */
@WebServlet("/ExtratoJSP.do")
public class ExtratoJSP extends HttpServlet {
	private Extrato extrato;
	private Conta conta;
	private Login login;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			login = new Login(request.getParameter("agencia"), request.getParameter("conta"), "1111", "111", true);
			System.out.println("login");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			conta = new Conta(login, true);
			System.out.println("conta");
		} catch (SQLException e2) {

		}
		Calendar agora = Calendar.getInstance();
		Calendar aux = Calendar.getInstance();
		aux.add(Calendar.DATE, -360);
		try {
			extrato = new Extrato(conta, aux.getTime(), agora.getTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Extrato> lista = new ArrayList<Extrato>();
		lista.add(extrato);
		request.setAttribute("extrato", extrato);
		RequestDispatcher view = request.getRequestDispatcher("VerExtrato.jsp");
		PrintWriter out = response.getWriter();
		out.println(JSonFacade.listToJSon(lista));
		view.forward(request, response);
	}
}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ItemDAO;
import model.Item;

/**
 * Servlet implementation class VideoList
 */
@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDAO dao = new ItemDAO();
		//すべてのデータを取得
		List<Item> list = dao.get();
		
		System.out.println("daoだお" + list);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String listJson = mapper.writeValueAsString(list);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charaset=UTF-8");
			response.getWriter().write(listJson);
			System.out.println("Jsonっぽいの" + listJson);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
//		System.out.println("htmlに送るよ");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.html");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

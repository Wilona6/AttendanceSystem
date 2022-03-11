package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDao;
import dao.RecordDao.countByDate;

@WebServlet("/CountWithDate")
public class CountWithDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CountWithDate() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecordDao recordDao=new RecordDao();
		List<countByDate>list = new ArrayList<countByDate>();
		list = recordDao.countByDates();
		if (list!=null&&!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("resultOfCountWithDate.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("null.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

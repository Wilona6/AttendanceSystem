package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDao;
import model.Record;

@WebServlet("/ShowRecord")
public class ShowRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowRecord() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		java.sql.Date date = null;
		if(!"".equals(request.getParameter("date"))) {
		try {
			date = new java.sql.Date(sf.parse(request.getParameter("date")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		String attend = request.getParameter("attend");
		Record record = new Record(id, date, attend);
		RecordDao recordDao = new RecordDao();
		List<Record> list = new ArrayList<Record>();
		list = recordDao.listRecord(record);
		if (!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("resultRec.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail_find.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

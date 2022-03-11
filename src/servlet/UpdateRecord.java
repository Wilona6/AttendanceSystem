package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDao;
import model.Record;

@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateRecord() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		try {
			java.sql.Date date=new java.sql.Date(sf.parse(request.getParameter("date")).getTime());
			String attend=request.getParameter("attend");
			Record record=new Record(id, date,attend);
			RecordDao recordDao=new RecordDao();
			try {
				if(recordDao.updateRecord(record)) {
					//²Ù×÷³É¹¦.jsp
					request.getRequestDispatcher("success_update.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("fail_update.jsp").forward(request, response);
					//Ê§°Ü.jsp
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

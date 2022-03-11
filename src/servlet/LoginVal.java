package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.TeacherDao;
import model.*;
@WebServlet("/LoginVal")
public class LoginVal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginVal() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pwd=request.getParameter("password");
		String userName=request.getParameter("id");
		String ident=request.getParameter("identity");
		if("student".equals(ident)) {
			Student student=new Student(userName, pwd);
			StudentDao studentDao=new StudentDao();
			try {
				if(studentDao.val_student(student)) {
					request.setAttribute("student", student);
					request.getRequestDispatcher("ShowStudent").forward(request, response);
				}
				else {
					request.setAttribute("error", "error");
					request.getRequestDispatcher("fail_loginstu.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Teacher teacher=new Teacher(userName, pwd);
			TeacherDao teacherDao=new TeacherDao();
			try {
				if(teacherDao.valTeacher(teacher)) {
					//teacher_menu.jsp
					request.getRequestDispatcher("main.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("fail_login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

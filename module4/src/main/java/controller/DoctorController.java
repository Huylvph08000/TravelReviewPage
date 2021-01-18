package controller.admin;

import dao.DoctorDAO;
import model.DoctorModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-doctor"})
public class DoctorController extends HttpServlet {

    private DoctorDAO doctorDAO;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DoctorModel> listDoctor = doctorDAO.findAll() ;

        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/doctorlist/doctor-list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


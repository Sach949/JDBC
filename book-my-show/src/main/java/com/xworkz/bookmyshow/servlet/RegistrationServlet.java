package com.xworkz.bookmyshow.servlet;


import com.xworkz.bookmyshow.entity.RegistrationEntity;
import com.xworkz.bookmyshow.service.RegistrationService;
import com.xworkz.bookmyshow.service.RegistrationServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/signUp")
public class RegistrationServlet extends HttpServlet {

    private RegistrationService service = new RegistrationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String dateStr = req.getParameter("dob");
        LocalDate dob = LocalDate.parse(dateStr);
        String email = req.getParameter("email");
        Long mob = Long.parseLong(req.getParameter("mobile"));
        String country = req.getParameter("country");
        LocalDate reg_date = LocalDate.now();


        System.out.println(name);
        System.out.println(dob);
        System.out.println(email);
        System.out.println(mob);
        System.out.println(country);

        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setName(name);
        registrationEntity.setDob(dob);
        registrationEntity.setMobileNo(mob);
        registrationEntity.setEmail(email);
        registrationEntity.setCountry(country);
        registrationEntity.setReg_Date(reg_date);

        service.saveUser(registrationEntity);
        

        //req.setAttribute("Entity", registrationEntity);
        RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
        rd.forward(req, resp);
        resp.getWriter().write("saved successfully");
    }
}

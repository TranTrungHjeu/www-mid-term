package com.example.wwwmidterm.controller;

import com.example.wwwmidterm.dao.ToaNhaDAO;
import com.example.wwwmidterm.impl.ToaNhaDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ToaNhaServlet extends HttpServlet {
    private final ToaNhaDAO toanhaDAO = new ToaNhaDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("danhsachToaNha", toanhaDAO.getAll());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

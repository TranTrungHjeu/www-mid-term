package com.example.wwwmidterm.controller;

import com.example.wwwmidterm.dao.CanHoDAO;
import com.example.wwwmidterm.dao.ToaNhaDAO;
import com.example.wwwmidterm.impl.CanHoDAOImpl;
import com.example.wwwmidterm.impl.ToaNhaDAOImpl;
import com.example.wwwmidterm.model.CanHo;
import com.example.wwwmidterm.model.ToaNha;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;

public class CanHoServlet extends HttpServlet {
    private final CanHoDAO canhoDAO = new CanHoDAOImpl();
    private final ToaNhaDAO toanhaDAO = new ToaNhaDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "detail":
                detail(request, response);
                break;
            case "byToanha":
                byToanha(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            update(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dsCanHo", canhoDAO.getAll());
        request.setAttribute("ddsToaNha", toanhaDAO.getAll());
        request.getRequestDispatcher("/canho-list.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maCanHo = request.getParameter("id");
        request.setAttribute("canHo", canhoDAO.findById(maCanHo));
        request.getRequestDispatcher("/canho-detail.jsp").forward(request, response);
    }

    private void byToanha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maToa = request.getParameter("maToa");
        request.setAttribute("dsCanHo", canhoDAO.findByToaNha(maToa));
        request.setAttribute("dsToaNha", toanhaDAO.getAll());
        request.setAttribute("selectedMaToa", maToa);
        request.getRequestDispatcher("/canho-list.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        request.setAttribute("dsCanHo", canhoDAO.findByName(keyword));
        request.setAttribute("dsToaNha", toanhaDAO.getAll());
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/canho-list.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maCanHo = request.getParameter("id");
        request.setAttribute("canHo", canhoDAO.findById(maCanHo));
        request.setAttribute("dsToaNha", toanhaDAO.getAll());
        request.getRequestDispatcher("/canho-edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String maCanHo = request.getParameter("maCanHo");
        String tenCanHo = request.getParameter("tenCanHo");
        BigDecimal giaThue = new BigDecimal(request.getParameter("giaThue"));
        float dienTich = Float.parseFloat(request.getParameter("dienTich"));
        String hinhAnh = request.getParameter("hinhAnh");
        String maToa = request.getParameter("maToa");

        ToaNha toanha = toanhaDAO.findById(maToa);
        CanHo canho = new CanHo(maCanHo, tenCanHo, giaThue, dienTich, hinhAnh, toanha);

        canhoDAO.update(canho);
        response.sendRedirect("canho");
    }
}

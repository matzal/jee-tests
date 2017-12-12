package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<User, Integer> statistics = statisticsRepositoryDao.getAllStatistics();

        PrintWriter printWriter = resp.getWriter();
        req.setAttribute("list", statistics);

        for (Map.Entry<User, Integer> entry : statistics.entrySet()) {
            printWriter.println(entry.getKey().getName() + ": " + entry.getValue());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

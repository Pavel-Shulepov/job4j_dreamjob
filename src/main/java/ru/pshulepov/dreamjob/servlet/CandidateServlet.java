package ru.pshulepov.dreamjob.servlet;

import ru.pshulepov.dreamjob.model.Candidate;
import ru.pshulepov.dreamjob.service.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store
                .instOf()
                .save(new Candidate(0, req.getParameter("name"),
                        req.getParameter("surname"),
                        Integer.parseInt(req.getParameter("yearBirth")),
                        Integer.parseInt(req.getParameter("experience")),
                        req.getParameter("telNumber")));
        resp.sendRedirect(req.getContextPath() + "/candidates.jsp");
    }
}

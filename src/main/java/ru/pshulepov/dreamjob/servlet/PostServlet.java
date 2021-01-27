package ru.pshulepov.dreamjob.servlet;

import ru.pshulepov.dreamjob.model.Post;
import ru.pshulepov.dreamjob.service.Store;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Store
                .instOf()
                .save((new Post(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("description"),
                        LocalDateTime.now())));
        resp.sendRedirect(req.getContextPath() + "/posts.jsp");
    }

}

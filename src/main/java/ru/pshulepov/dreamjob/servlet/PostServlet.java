package ru.pshulepov.dreamjob.servlet;

import ru.pshulepov.dreamjob.model.Post;
import ru.pshulepov.dreamjob.service.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        MemStore
                .instOf()
                .save((new Post(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("description"),
                        LocalDateTime.now())));
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", MemStore.instOf().findAllPosts());
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }
}

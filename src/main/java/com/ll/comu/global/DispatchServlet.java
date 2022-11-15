package com.ll.comu.global;

import com.ll.comu.article.controller.ArticleController;
import com.ll.comu.member.controller.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI();

        switch (url) {
            case "/usr/article/list":
                articleController.showList(rq);
            case "/usr/member/login":
                memberController.showLogin(rq);
            case "/usr/article/write":
                articleController.showWrite(rq);
        }
    }
}

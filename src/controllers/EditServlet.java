package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 該当のIDのメッセージ1件のみをデータベースから取得
        Tasklist m = em.find(Tasklist.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // メッセージ情報とセッションIDをリクエストスコープに登録
        request.setAttribute("tasklist", m);
        request.setAttribute("_token", request.getSession().getId());

        // メッセージIDをセッションスコープに登録
        request.getSession().setAttribute("tasklist_id", m.getId());

     // メッセージデータが存在しているときのみ
        // メッセージIDをセッションスコープに登録
        if(m != null) {
            request.getSession().setAttribute("tasklist_id", m.getId());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
        rd.forward(request, response);
    }
}

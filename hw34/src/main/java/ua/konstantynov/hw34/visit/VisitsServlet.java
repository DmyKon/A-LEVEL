package ua.konstantynov.hw34.visit;

import com.google.gson.Gson;
import ua.konstantynov.hw34.statistics.StatisticsSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentLinkedDeque;

@WebServlet("/visits")
public class VisitsServlet extends HttpServlet {
    ConcurrentLinkedDeque<Visit> deque = new ConcurrentLinkedDeque<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StatisticsSingleton.getInstance().incrementQueryCount();
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("application/json");
        responseBody.println(new Gson().toJson(deque));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StatisticsSingleton.getInstance().incrementQueryCount();
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("application/json");
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String city = req.getParameter("city");
        Visit visit = new Visit(name, date, city);
        if (deque.size() >= 3) {
            deque.removeFirst();
        }
        deque.add(visit);
        responseBody.println(new Gson().toJson(visit));
    }
}
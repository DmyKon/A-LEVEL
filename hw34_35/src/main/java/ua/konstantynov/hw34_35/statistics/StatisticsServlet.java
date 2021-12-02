package ua.konstantynov.hw34_35.statistics;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("application/json");
        StatisticsSingleton.getInstance().incrementQueryCount();
        responseBody.println(new Gson().toJson(StatisticsSingleton.getInstance()));
    }
}
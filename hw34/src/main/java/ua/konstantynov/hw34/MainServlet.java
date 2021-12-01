package ua.konstantynov.hw34;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    LinkedList<Map.Entry<String, String>> list = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        Map.Entry<String, String> entry =
                new AbstractMap.SimpleEntry<>(req.getRemoteHost(), req.getHeader("user-agent"));
        if (list.stream().noneMatch(x->x.getKey().equals(req.getRemoteHost()))) {
            list.addLast(entry);
        }
        list.forEach(x -> {
            if (x.equals(entry)) {
                responseBody.println("<p align=\"center\"><b>" +
                        x.getKey() + " :: " + x.getValue() + "<b/></p>");
            } else {
                responseBody.println("<p align=\"center\">" +
                        x.getKey() + " :: " + x.getValue() + "</p>");
            }
        });
        if (list.size() >= 5) {
            list.removeFirst();
        }
    }
}

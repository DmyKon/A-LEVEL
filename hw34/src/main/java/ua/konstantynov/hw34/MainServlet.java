package ua.konstantynov.hw34;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    ConcurrentLinkedDeque<Map.Entry<String, String>> deque = new ConcurrentLinkedDeque<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        Map.Entry<String, String> entry =
                new AbstractMap.SimpleEntry<>(req.getRemoteHost(), req.getHeader("user-agent"));
        if (deque.stream().anyMatch(x -> x.getKey().equals(req.getRemoteHost()))) {
            deque.remove(entry);
        }
        deque.addLast(entry);
        deque.forEach(x -> {
            if (x.equals(entry)) {
                responseBody.println("<p align=\"center\"><b>" + x.getKey() + " :: " + x.getValue() + "</b></p>");
            } else {
                responseBody.println("<p align=\"center\">" + x.getKey() + " :: " + x.getValue() + "</p>");
            }
        });
        if (deque.size() >= 5) {
            deque.removeFirst();
        }
    }
}

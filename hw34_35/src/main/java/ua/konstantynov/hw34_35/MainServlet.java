//#34
//1. Преобразовать текущий maven проект в мультимодульный.
//Таким образом у вас получится один родительский модуль, в котором будет 2 подмодуля,
//один для прошлых ДЗ, один для ДЗ по сервлетам.
//2. Реализовать веб-приложение, которое принимает GET запросы, и хранит в памяти список последних 5 уникальных ip адресов,
//сделавших к нему запрос, и соответствующих значений http-заголовка User-Agent
//При запросе выдает html документ с текущим списком
//( при этом IP и User-Agent пользователя, сделавшего запрос - выделить жирным текстом - html тег <b></b>)
//#35
//Разработать приложение, которое обрабатывает следующие запросы:
//- GET /visits – получить все визиты в порядке добавления
//- POST /visits – добавить новый визит (передать 3 параметра: имя - name, дата - date, город - city)
//P.S. Хранятся только последние 3 визита.
//- GET /statistics – получает данные об общем количестве запросов и текущую дату.
//Создать класс, который будет отвечать за подсчет общего количества запросов,
// т.е. пришел любой запрос из 3, которые мы обрабатываем – инкрементим счетчик.
//Все ответы возвращаем в JSON формате.
package ua.konstantynov.hw34_35;

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
        if (deque.size() > 5) {
            deque.removeFirst();
        }
        responseBody.println("<h1><p align=\"center\"><br><br><a href=\"visits\">visits</a></p></h1>");
        responseBody.println("<h1><p align=\"center\"><a href=\"/form.jsp\">add new visit</a></p></h1>");
        responseBody.println("<h1><p align=\"center\"><a href=\"statistics\">statistics</a></p></h1>");
    }
}

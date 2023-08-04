package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TyHalvorsen
 */
public class shoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        String logOut = request.getParameter("logout");
        String username = request.getParameter("username");
        ArrayList<String> items = (ArrayList<String>) httpSession.getAttribute("items");

        if (username == null || username.equals("")) {
            items = new ArrayList<>();
            httpSession.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (logOut != null) {
            request.setAttribute("logOutMessage", "Thank you for visiting, you are logged out!");
            httpSession.invalidate();
            request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        httpSession.setAttribute("username", username);
        httpSession.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        String username = request.getParameter("username");
        String radioButton = request.getParameter("radioButton");
        String textButton = request.getParameter("textButton");
        ArrayList<String> items = (ArrayList<String>) httpSession.getAttribute("items");
        String addToList = request.getParameter("addToList");

        if ("addItem".equalsIgnoreCase(textButton)) {
            items.add(addToList);
            httpSession.setAttribute("items", items);
            request.setAttribute("item", addToList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } else if ("Delete".equalsIgnoreCase(textButton)) {
            items.remove(radioButton);
            httpSession.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        httpSession.setAttribute("username", username);
        httpSession.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }

}

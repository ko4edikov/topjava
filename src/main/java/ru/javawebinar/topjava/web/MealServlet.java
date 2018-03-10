package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.MealDAOImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final MealDAO mealDAO = new MealDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals.jsp");

        req.setCharacterEncoding("UTF-8");


        String action = req.getParameter("action");
        log.debug("Action : " + action);
        String id = req.getParameter("id");

        if (Objects.equals(action,"edit")) {
            Meal meal = mealDAO.getById(Long.parseLong(id));
            req.setAttribute("meal", meal);
            req.getRequestDispatcher("/form.jsp").forward(req, resp);
            return;
        } else if (Objects.equals(action,"add")) {

            req.getRequestDispatcher("/form.jsp").forward(req, resp);
            return;
        } else if (Objects.equals(action, "delete")) {

            mealDAO.delete(Long.parseLong(id));


        }


        List<MealWithExceed> mealsWithExceeded = MealsUtil.getAllMealsWithExceeded(mealDAO.getAll(), 2000);
        req.setAttribute("mealsWithExceeded", mealsWithExceeded);
        req.setAttribute("dateFormat", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("\n\nCreateMealServlet");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("meal-id");

        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("meal-datetime"));

        String description = req.getParameter("meal-description");

        int caloriesPerDay = req.getParameter("meal-calories") == null ?
                0 : Integer.parseInt(req.getParameter("meal-calories"));

        if (id == null || id.equals("")) {
            Meal meal = new Meal(dateTime, description, caloriesPerDay);
            mealDAO.addMeal(meal);

        } else {
            Meal meal = new Meal(Long.parseLong(id), dateTime, description, caloriesPerDay);
            mealDAO.update(meal);
        }

        resp.sendRedirect("meals");

    }
}

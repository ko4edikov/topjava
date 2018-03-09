package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class MealDAOImpl implements MealDAO {

    private Map<Long, Meal> mealMap = new HashMap<>();


    private static List<Meal> meals = new ArrayList<>(Arrays.asList(
            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    ));

    @Override
    public boolean addMeal(Meal meal) {
        return meals.add(meal);

    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public boolean update(Meal meal) {
        Meal tmp = getById(meal.getId());
        int index = meals.indexOf(tmp);
        meals.set(index, meal);
        return true;
    }

    @Override
    public Meal getById(Long id) {
        return meals.stream()
                .filter(tmp -> tmp.getId() == id)
                .findFirst().get();
    }

    @Override
    public boolean delete(Long id) {
        return meals.removeIf(m -> m.getId() == id);

    }


}
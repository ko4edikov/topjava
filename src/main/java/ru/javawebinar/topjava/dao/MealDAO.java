package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDAO {

    boolean addMeal(Meal meal);

    List<Meal> getAll();




    boolean update(Meal meal);

    Meal getById(Long id);


    boolean delete(Long id);
}

package com.example.refresher.repository;

import android.app.Application;

import com.example.refresher.database.AppDatabase;
import com.example.refresher.database.ExpenseDAO;
import com.example.refresher.models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {
    Application application;
    AppDatabase appDatabase;
    ExpenseDAO expenseDAO;
    List<Expense> expenses = new ArrayList<>();
    List<Expense> selectedCategoryExpenses = new ArrayList<>();

    public ExpenseRepository(Application application) {
        this.application = application;

        appDatabase = AppDatabase.getAppDatabase(application);

        expenseDAO = appDatabase.expenseDAO();
    }

    public void addExpense(Expense expense) {
        expenseDAO.insertExpense(expense);
    }

    public void deleteExpense(Expense expense) {
        expenseDAO.deleteExpense(expense);
    }

    public List<Expense> getExpenses() {
        expenses = expenseDAO.getExpenses();
        return expenses;
    }

    public List<Expense> getSelectedCategoryExpenses(int linkedCategoryId) {
        selectedCategoryExpenses = expenseDAO.getSelectedCategoryExpenses(linkedCategoryId);
        return selectedCategoryExpenses;
    }



}

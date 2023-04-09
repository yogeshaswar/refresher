package com.example.refresher.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.refresher.models.Expense;
import com.example.refresher.repository.ExpenseRepository;

import java.util.List;

public class MAViewModel extends AndroidViewModel {
    private MutableLiveData<List<Expense>> expenseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Expense>> selectedCategoryExpensesData = new MutableLiveData<>();
    ExpenseRepository expenseRepository;
    public MAViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
    }

    public void addExpense(Expense expense) {
        expenseRepository.addExpense(expense);
    }

    public MutableLiveData<List<Expense>> getExpense() {
        List<Expense> expenses = expenseRepository.getExpenses();
        expenseMutableLiveData.setValue(expenses);
        return expenseMutableLiveData;
    }

    public MutableLiveData<List<Expense>> getSelectedCategoryExpenses(int linkedCategoryId) {
        List<Expense> selectedCategoryExpenses = expenseRepository.getSelectedCategoryExpenses(linkedCategoryId);
        selectedCategoryExpensesData.setValue(selectedCategoryExpenses);
        return selectedCategoryExpensesData;

    }

}

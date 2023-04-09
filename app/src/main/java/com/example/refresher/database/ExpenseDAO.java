package com.example.refresher.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.refresher.models.Expense;

import java.util.List;

@Dao
public interface ExpenseDAO {

    @Insert
    void insertExpense(Expense expense);

    @Delete
    void deleteExpense(Expense expense);

    @Query("SELECT * FROM expense_table")
    List<Expense> getExpenses();

    @Query("SELECT * FROM expense_table WHERE linkedCategoryId =:linkedCategoryId")
    List<Expense> getSelectedCategoryExpenses(int linkedCategoryId);

}

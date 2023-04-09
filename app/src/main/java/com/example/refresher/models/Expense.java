package com.example.refresher.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense_table")
public class Expense {
    @PrimaryKey(autoGenerate = true)
    int expenseId;

    String expenseTitle;

    String expenseAmount;

    String expenseDescription;

    int linkedCategoryId;

    public Expense(int expenseId, String expenseTitle, String expenseAmount, String expenseDescription, int linkedCategoryId) {
        this.expenseId = expenseId;
        this.expenseTitle = expenseTitle;
        this.expenseAmount = expenseAmount;
        this.expenseDescription = expenseDescription;
        this.linkedCategoryId = linkedCategoryId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public int getLinkedCategoryId() {
        return linkedCategoryId;
    }

    public void setLinkedCategoryId(int linkedCategoryId) {
        this.linkedCategoryId = linkedCategoryId;
    }
}

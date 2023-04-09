package com.example.refresher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.refresher.models.Expense;
import com.example.refresher.viewmodel.MAViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MAViewModel maViewModel;
    LiveData<List<Expense>> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maViewModel = new ViewModelProvider(this).get(MAViewModel.class);
        addExpenses();
        expenses = maViewModel.getExpense();
        expenses.observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expensesList) {
                Toast.makeText(MainActivity.this, "fetched list size" + expensesList.size(), Toast.LENGTH_SHORT).show();

                Log.i("EXPENSE", expensesList.get(0).getExpenseTitle());
                Log.i("EXPENSE", expensesList.get(0).getExpenseAmount());
                Log.i("EXPENSE", expensesList.get(0).getExpenseDescription());
                Log.i("EXPENSE", String.valueOf(expensesList.get(0).getExpenseId()));
            }
        });
    }

    private void addExpenses() {
        Expense expense1 = new Expense(0, "eOne", "120", "this is an expense one", 0);

        maViewModel.addExpense(expense1);
    }
}
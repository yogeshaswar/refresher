package com.example.refresher.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.refresher.models.Expense;

@Database(entities = {Expense.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "expense_app.db";

    public abstract ExpenseDAO expenseDAO();

    public static AppDatabase appDatabase;

    public static synchronized AppDatabase getAppDatabase(Context context) {

        if(appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return appDatabase;
    }



}

package com.example.awesome.be_calculator.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by j on 19.04.2015.
 */
public class ProductDatabaseHelper extends SQLiteOpenHelper {

    public ProductDatabaseHelper(Context context) {
        super(context, "products", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table products(" +
                "id integer primary key autoincrement" +
                "name varchar(20) not null)");

        db.execSQL("insert into products(name) values (\'Banane\')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

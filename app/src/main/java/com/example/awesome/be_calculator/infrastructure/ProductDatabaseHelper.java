package com.example.awesome.be_calculator.infrastructure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.awesome.be_calculator.model.Product;
import com.example.awesome.be_calculator.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 19.04.2015.
 */
public class ProductDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BE_Calculator";
    private static final String TABLE_PRODUCTS = "products";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_BE = "BE";
    private static final String KEY_UNIT = "unit";
    private static final int DATABASE_VERSION = 1;

    public ProductDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL(
                "CREATE TABLE "+ TABLE_PRODUCTS +
                        "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT," +
                KEY_AMOUNT + " INTEGER," +
                KEY_BE + " DOUBLE," +
                KEY_UNIT + " TEXT" +
                        ")"
        );
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        // Create tables again
        onCreate(db);
    }

    // Fügt ein neues Product der Datenbank hinzu.
    public void addProduct(Product newProduct) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, newProduct.Name);
        values.put(KEY_AMOUNT, newProduct.getAmount());
        values.put(KEY_BE, newProduct.getBE());
        values.put(KEY_UNIT, newProduct.getUnit());

        // Zeile einfügen
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Datenbankverbindung schliessen
    }

    // Erhalte alle Produkte.
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                double amount = Integer.parseInt(cursor.getString(2));
                double be = Double.parseDouble(cursor.getString(3));
                String unit = cursor.getString(4);

                Product.Unit productUnit = null;
                if (unit.equals("g"))
                    productUnit = Product.Unit.GRAM;
                if (unit.equals("ml"))
                    productUnit = Product.Unit.MILLILITRE;

                Product product = new Product(name, ProductCategory.MilkproductsAndEggs, amount, be, productUnit);
                // Adding contact to list
                productList.add(product);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productList;
    }

}

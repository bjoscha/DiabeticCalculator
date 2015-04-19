package com.example.awesome.be_calculator.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.awesome.be_calculator.R;
import com.example.awesome.be_calculator.business.BusinessState;
import com.example.awesome.be_calculator.model.ProductCategory;


public class Overview extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setCategory(View view) {
        ImageButton buttonView = (ImageButton) view;
        BusinessState state = BusinessState.getInstance();

        state.setCurrentCategory(ProductCategory.Drinks);

        switch (view.getId())
        {
            case R.id.btnCategory_BreadAndCeralAndCornflakes : state.setCurrentCategory(ProductCategory.BreadAndCerealsAndCornflakes); break;
            case R.id.btnCategory_Drinks : state.setCurrentCategory(ProductCategory.Drinks); break;
            case R.id.btnCategory_FishAndSeafood : state.setCurrentCategory(ProductCategory.FishAndSeafood); break;
            case R.id.btnCategory_fruitsAndVegetablesAndSalads : state.setCurrentCategory(ProductCategory.FruitsAndVegetablesAndSalads); break;
            case R.id.btnCategory_instantMealAndTinnedFoodAndPasta : state.setCurrentCategory(ProductCategory.InstantMealAndTinnedFood); break;
            case R.id.btnCategory_MeatAndColdmeat : state.setCurrentCategory(ProductCategory.MeatAndColdmeat); break;
            case R.id.btnCategory_MilkProductsAndEggs : state.setCurrentCategory(ProductCategory.MilkproductsAndEggs); break;
            case R.id.btnCategory_SpiceryAndOilsAndGrease : state.setCurrentCategory(ProductCategory.SpiceryAndOilsAndGrease); break;
            case R.id.btnCategory_SpreadAndCovering : state.setCurrentCategory(ProductCategory.SpreadAndCovering); break;
            case R.id.btnCategory_SweetsAndSnacks : state.setCurrentCategory(ProductCategory.SweetsAndSnacks); break;
            default:break;
        }

        Intent intent = new Intent(this, CategoryProductsActivity.class);
        startActivity(intent);
    }
}

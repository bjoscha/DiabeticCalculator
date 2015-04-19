package com.example.awesome.be_calculator.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.awesome.be_calculator.R;
import com.example.awesome.be_calculator.adapter.ProductAdapter;
import com.example.awesome.be_calculator.business.BusinessState;
import com.example.awesome.be_calculator.model.ProductCategory;
import com.example.awesome.be_calculator.business.TestProducts;


public class CategoryProductsActivity extends ListActivity {

    @Override
    protected void onStart() {
        super.onStart();

//        ProductAdapter adapter = new ProductAdapter(this, BusinessState.getInstance().getAllProducts());
//        setListAdapter(adapter);

        ProductAdapter productAdapter = (ProductAdapter)getListAdapter();
        productAdapter.setProducts(BusinessState.getInstance().getProductsOfCurrentCategory());
        productAdapter.notifyDataSetChanged();

    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_category_products);

        ProductAdapter adapter = new ProductAdapter(this, BusinessState.getInstance().getAllProducts());
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position).toString();
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }

    public void addProduct(View view) {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }
}

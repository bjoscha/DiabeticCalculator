package com.example.awesome.be_calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.awesome.be_calculator.R;
import com.example.awesome.be_calculator.model.Product;
import com.example.awesome.be_calculator.model.ProductCategory;

import java.util.LinkedList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private List<Product> values;

    public ProductAdapter(Context context, List<Product> values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    public void setProducts(List<Product> products)
    {
        values = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values.get(position).Name);
        // Change the icon for Windows and iPhone
        ProductCategory category = values.get(position).Category;

//        switch (category)
//        {
//            case BreadAndCerealsAndCornflakes: imageView.setImageResource(R.drawable.bread_and_cereals_and_cornflakes); break;
//            case Drinks: imageView.setImageResource(R.drawable.drinks); break;
//            case FishAndSeafood: imageView.setImageResource(R.drawable.fish_and_seafood); break;
//            case FruitsAndVegetablesAndSalads: imageView.setImageResource(R.drawable.fruits_and_vegetables_and_salads); break;
//            case InstantMealAndTinnedFood: imageView.setImageResource(R.drawable.instant_meal_and_tinned_food_and_pasta); break;
//            case MeatAndColdmeat: imageView.setImageResource(R.drawable.meat_and_coldmeat); break;
//            case MilkproductsAndEggs: imageView.setImageResource(R.drawable.milk_products_and_eggs); break;
//            case SpiceryAndOilsAndGrease: imageView.setImageResource(R.drawable.spicery_and_oils_and_grease); break;
//            case SpreadAndCovering: imageView.setImageResource(R.drawable.spread_and_covering); break;
//            case SweetsAndSnacks: imageView.setImageResource(R.drawable.sweets_and_snacks); break;
//            default:break;
//        }

        return rowView;
    }

    public int getCount() {
        return values.size();
    }

    public Product getItem(int position) {
        return values.get(position);
    }
}
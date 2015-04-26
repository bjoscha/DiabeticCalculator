package com.example.awesome.be_calculator.model;

/**
 * Created by j on 06.04.2015.
 */
public class Product {
    public ProductCategory Category;
    public String Name;
    public static enum Unit {GRAM, MILLILITRE}
    private double amountPerUnit;
    private double bePerUnit;
    private Unit ofUnit;
    
    public String toString()
    {
        return Name;
    }

    public double gtBE(double amount)
    {
        return amount / amountPerUnit * bePerUnit;
    }

    public int getAmount(){
        return (int)amountPerUnit;
    }

    public double getBE()
    {
        return bePerUnit;
    }

    public String getUnit()
    {
        if (ofUnit.equals(Unit.GRAM))
            return "g";
        if (ofUnit.equals(Unit.MILLILITRE))
            return "ml";

        return "unbekannte Einheit";
    }


    public Product(String name, ProductCategory category, double amountPerUnit, double bePerUnit, Unit unit) {
        this.Name = name;
        this.Category = category;
        this.amountPerUnit = amountPerUnit;
        this.bePerUnit = bePerUnit;
        this.ofUnit = unit;
    }

    public Unit getUnitType()
    {
        return this.ofUnit;
    }
}


package com.ltprgmone.ahandas;

public class Building {
    private String name;
    private int bClass;
    private String address;
    private int occupents;
    private double value;
    private int flamability;
    private int danger;

    public Building(String nameString, int bClassInt, String addressString, int occupentsInt, double valueDouble, int flamabilityInt, int dangerInt)
    {
        bClass=bClassInt;
        name=nameString;
        address=addressString;
        occupents=occupentsInt;
        value=valueDouble;
        flamability=flamabilityInt;
        danger=dangerInt;
    }

    public String toString()
    {
        return "name: "+ name + " class: " + bClass + " address: " + address + " occupents: " + occupents+" value: "+value + " flamability" + flamability + " danger "+danger;
    }
    public String contractInfoString()
    {
        String occupentRating="null";
        int difficulty=(flamability-danger);
        String difficultyRating="null";

        if (occupents==0)
        {
            occupentRating="no";
        }
        else if (occupents<=50)
        {
            occupentRating="some";
        }
        else if (occupents>50 && occupents<100)
        {
            occupentRating="quite a few";
        }
        else if (occupents>=100)
        {
            occupentRating="a lot of";
        }

        if (difficulty<=0)
        {
            difficultyRating="extremely hard";
        }
        else if (difficulty<=5)
        {
            difficultyRating="very hard";
        }
        else if (difficulty>5 && difficulty<7)
        {
            difficultyRating="challenging";
        }
        else if (difficulty>=7)
        {
            difficultyRating="pretty easy";
        }

        return ("building known as "+"'"+name+"'"+" at the address "+address+". There are "+occupentRating+" people inside. This job will be "+difficultyRating+".");
    }
    public int difficultyFinder()
    {
        return (flamability-danger);
    }
}

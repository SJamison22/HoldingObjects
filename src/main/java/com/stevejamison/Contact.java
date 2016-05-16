package com.stevejamison;

import java.util.ArrayList;

/**
 * Created by stevejaminson on 5/16/16.
 */
public class Contact {

    private String name;
    private ArrayList<String> numbers = new ArrayList<String>();

    public Contact(){

    }
    public Contact(String name, String number){
        this.name = name;
        this.numbers.add(number);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }
}

package com.stevejamison;

import java.util.*;

/**
 * Created by stevejaminson on 5/16/16.
 */
public class PhoneBook {

    public Map<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<String, ArrayList<String>>();
    }

    public void addContact(Contact contact) {
        phoneBook.put(contact.getName(), contact.getNumbers());
    }

    public String lookup(String name) {
        String num = "";
        if (phoneBook.containsKey(name)) {
            for (int i = 0; i < phoneBook.get(name).size(); i++) {
                num += phoneBook.get(name).get(i) + "\n";
            }
        } else {
            num = "No entry found";
        }
        return num;
    }

    public void addNumber(String name, String number) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        }
    }

    public void removeNumber(String num) {
        for(Map.Entry<String,ArrayList<String>> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            for(int i = 0; i < entry.getValue().size(); i++) {
                String val = entry.getValue().get(i);
                if(num.equals(val)){
                    entry.getValue().remove(num);
                }
            }
        }
    }

    public String listContacts() {
        String list = "";
        for(Map.Entry<String,ArrayList<String>> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            list += key + " :\n";
            for(int i = 0; i < entry.getValue().size(); i++) {
                String val = entry.getValue().get(i);
                list += val + "\n";
            }
        }
        return list;
    }

    public String reverseLookup(String number){
        String name = "";
        for(Map.Entry<String,ArrayList<String>> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            for(int i = 0; i < entry.getValue().size(); i++) {
                String val = entry.getValue().get(i);
                if(number.equals(val)){
                    name = key;
                }
            }
        }
        return name;
    }

    public void removeRecord(String name){
        phoneBook.remove(name);
    }
}


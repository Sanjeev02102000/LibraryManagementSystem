package com.lms.Patron;

import com.lms.Book.Book;

import java.util.HashMap;
import java.util.Map;

public class PatronManagement {
    Map<String, Patron> patrons;

    public PatronManagement() {
        patrons = new HashMap<>();
    }

    public void addPatron(Patron patron) {
        if(patron == null) {
            System.out.println("Failed Adding Patron. Details are null. Patron: " + patron);
            return;
        }
        patrons.put(patron.getId(), patron);
        System.out.println("Patron added successfully. Patron name:" + patron.getName());
    }

    public Patron removePatron(Patron patron) {
        if(!patrons.containsValue(patron)) {
            System.out.println("Unable to remove Patron. Patron does not exist. Patron details: " + patron.getName());
            return null;
        }
        Patron removedPatron = patrons.remove(patron.getId());
        System.out.println("Patron removed. Patron name: " + patron.getName());
        return removedPatron;
    }

    public void updatePatron(String id, String name, String emailAddress, String mobileNumber, String gender, int age) {
        Patron patron = patrons.get(id);
        if(patron == null) {
            System.out.println("Unable to find Patron with id: "+ id);
            return;
        }
        patron.setAge(age);
        patron.setName(name);
        patron.setGender(gender);
        patron.setEmailAddress(emailAddress);
        patron.setMobileNumber(mobileNumber);
    }

    public Patron getPatronById(String id) {
        if(!patrons.containsKey(id)) {
            System.out.println("Unable to get Patron by supplied id: " + id);
            return null;
        }
        return patrons.get(id);
    }

}

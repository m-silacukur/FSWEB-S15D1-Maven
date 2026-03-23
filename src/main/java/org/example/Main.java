package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

public class Main {

    public static void main(String[] args) {


        System.out.println("\n=GROCERY CHALLENGE =");

        Grocery.addItems("apple, banana, tomato");
        Grocery.addItems("orange");
        Grocery.addItems("apple");
        Grocery.printSorted();

        Grocery.removeItems("banana, orange");
        Grocery.printSorted();


        System.out.println("\n= MOBILE PHONE CHALLENGE =");

        MobilePhone phone = new MobilePhone("0555-123-4567");


        Contact bob   = Contact.createContact("Bob",   "31415926");
        Contact alice = Contact.createContact("Alice", "16180339");
        Contact tom   = Contact.createContact("Tom",   "11235813");
        Contact jane  = Contact.createContact("Jane",  "23571113");


        System.out.println("Bob eklendi   : " + phone.addNewContact(bob));
        System.out.println("Alice eklendi : " + phone.addNewContact(alice));
        System.out.println("Tom eklendi   : " + phone.addNewContact(tom));
        System.out.println("Jane eklendi  : " + phone.addNewContact(jane));
        System.out.println("Bob tekrar    : " + phone.addNewContact(bob));

        System.out.println();
        phone.printContact();


        Contact updatedTom = Contact.createContact("Tom", "99999999");
        System.out.println("\nTom güncellendi: " + phone.updateContact(tom, updatedTom));


        System.out.println("Jane silindi   : " + phone.removeContact(jane));

        System.out.println();
        phone.printContact();

        Contact found = phone.queryContact("Alice");
        System.out.println("\nAlice sorgulandı: " + (found != null ? found.getName() + " -> " + found.getPhoneNumber() : "bulunamadı"));

        System.out.println("Bob'un indeksi  : " + phone.findContact("Bob"));
        System.out.println("Jane'in indeksi : " + phone.findContact("Jane"));
    }
}
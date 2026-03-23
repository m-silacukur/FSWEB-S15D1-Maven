package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0 → Çıkış");
            System.out.println("1 → Ürün Ekle");
            System.out.println("2 → Ürün Çıkar");
            System.out.print("Seçiminiz: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "0" -> {
                    running = false;
                }
                case "1" -> {
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    addItems(scanner.nextLine().trim());
                    printSorted();
                }
                case "2" -> {
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    removeItems(scanner.nextLine().trim());
                    printSorted();
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (trimmed.isEmpty()) continue;

            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (trimmed.isEmpty()) continue;

            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        for (String item : groceryList) {
            if (item.equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }

    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("Liste boş.");
            return;
        }
        Collections.sort(groceryList);
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }
}
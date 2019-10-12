package hw2.otus;

import java.util.Collections;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DIArrayList<String> myarrlst = new DIArrayList();
        ArrayList<String> defarrlst = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            defarrlst.add("DefaultArrayList - " + i);
        }

        for (int i1 = 1; i1 <= 40; i1++) {
            myarrlst.add("MyArrayList - " + i1);
        }

        try {
            Collections.copy(myarrlst, defarrlst);
        } catch (Exception e) {
            System.out.println("Ошибка копирования Collections.copy - " + e);
        }

        try {
            Collections.addAll(myarrlst, "first add", "second add", "third add", "forth add");
            myarrlst.addAll(defarrlst);
        } catch (Exception e) {
            System.out.println("Ошибка добавления элементов Collections.addAll - " + e);
        }

        try {
            //Collections.sort(myarrlst, null);
            myarrlst.sort(null);
        } catch (Exception e) {
            System.out.println("Ошибка сортировки  - Collections.sort" + e);
        }


        for (int jj = 0; jj <= myarrlst.size() - 1; jj++) {
            System.out.println(myarrlst.get(jj));
        }
    }
}

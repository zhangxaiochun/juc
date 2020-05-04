package jvm.pack;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list1.add("1");
        list2.add(1);
        String s = list1.get(0);
        System.out.println(list1.get(0).getClass());
        System.out.println(list2.get(0).getClass());
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }
}

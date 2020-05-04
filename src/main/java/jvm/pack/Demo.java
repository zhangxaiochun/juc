package jvm.pack;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));
        StringBuffer  stringBuffer = new StringBuffer("123");
        stringBuffer.append(1);
        /*==和equals区别
        https://www.jianshu.com/p/5aae671a70d7
         */

        System.out.println(stringBuffer);
        System.out.println("===========");
        //https://www.jianshu.com/p/e561704be431
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        System.out.println("=========");

    }
}

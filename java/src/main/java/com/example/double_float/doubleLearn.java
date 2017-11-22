package com.example.double_float;

/**
 * Created by haichen.cui on 2017.08.28
 */

public class doubleLearn {
    public static void main(String[] args) {
        //虽然0.1用float并不能精确表示，但是这里赋值，不进行计算，然后直接输出，显示结果还是0.1
//        float f = 0.1f;
//        System.out.println(f);

//        String f1 = "0.1";
//        String f2 = "0.01";
//        String f3 = "0.001";
//        String f4 = "0.0001";
//        String f5 = "0.00001";
//        double r1 = Double.valueOf(f1);
//        double r2 = Double.valueOf(f2);
//        double r3 = Double.valueOf(f3);
//        double r4 = Double.valueOf(f4);
//        double r5 = Double.valueOf(f5);
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(r3);
//        System.out.println(r4);
//        System.out.println(r5);
//
//        r1 *= 0.1;
//        System.out.println(r1);

        long l = -1;
        long b = 1;
        System.out.println(System.currentTimeMillis());
        System.out.println(l + "");
        System.out.println(System.currentTimeMillis());
        System.out.println(String.valueOf(l));
        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        System.out.println(b + "");
        System.out.println(System.currentTimeMillis());
        System.out.println(String.valueOf(b));
        System.out.println(System.currentTimeMillis());

    }


}

package com.example.double_float;

/**
 * Created by haichen.cui on 2017.08.28
 */

public class doubleLearn {
    public static void main(String[] args) {
        //虽然0.1用float并不能精确表示，但是这里赋值，不进行计算，然后直接输出，显示结果还是0.1
//        float f = 0.1f;
//        System.out.println(f);

        String f = "0.1";
        double result = Double.valueOf(f);
        System.out.println(result);

        result *= 0.1;
        System.out.println(result);

    }


}

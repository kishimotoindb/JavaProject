package com.example.initialize;

/**
 * Created by haichen.cui on 10/07/2017.
 * 静态代码块和静态变量，按照出现的先后顺序进行赋值操作。因为生成类构造器<clinit>时，赋值语句是按照
 * 由上到下的顺序收集的。。
   1)第一种情况
    static {
        i = 2;
     }
    static int i = 1;
    结果：i=1

    2）第二种情况
    static int i = 1;
    static {
        i = 2;
    }
    结果：i=2
 */

public class InitializeSquenceOfStaticAndStaticCodeBlock implements A{
    static {
        i = 2;
        i=a;
    }
    static int i = 1;

    public static void main(String[] args){
        System.out.println(i);
    }

}

interface A{
    int a = 1;
}

package com.example.Basic.classloader;

public class Test {
    public static void main(String[] args) {
        /*
         * 加载静态内部类，如果没有使用外部类，同样不会加载外部类
         */
//        new Outer.StaticInnerClass();

        classDoInitialize();
    }

    private static void classDoInitialize() {
        /*
         * 调用ClassDoInitialize的整型常量，是否会触发类执行"初始化"阶段?
         *
         * 结论：
         * 不会，因为可以从常量池中直接读取
         */
        int a = ClassDoInitialize.COUNT;

        System.out.println("reading int constant complete");

        /*
         * 调用ClassDoInitialize的引用类型常量，是否会触发执行"初始化"阶段？
         *
         * 结论：
         * 会，因为引用类型的常量并不会被保存在常量池中。
         */
        Object o = ClassDoInitialize.OUTER;

    }
}

package com.example.reusing_classes.a;

/*
 * 问题列表
 * 1.创建子类对象的时候
 * 1）子类构造调用了父类构造super()
 * 2）super()中调用了父类中的方法father()
 * 3）Father()方法在子类中进行了重写
 * 那么，此种情况下，执行的是子类还是父类的father()方法
 * 答：子类的father()方法
 * log日志：
 *  child class Father
 *  child class constructor
 *
 *
 */

class ChildClass extends BaseClass {
    public Object o1 = new Object();

    public static void main(String[] args) {
        new ChildClass().first();
    }

    public ChildClass() {
//        System.out.println("child class constructor");
//        super.Father();
//        System.out.println("child" + o1);
    }

    @Override
    protected void father() {
        System.out.println("child class Father");
    }
}


package com.example.Basic.inherit;

/**
 * Created by BigFaceBear on 2019.06.20
 */

public class FatherClassThisReprecentWho {
    public static void main(String[] args) {
        new Child().did();
    }

    /*
     * 对于父类来说，不能决定是调用自己还是子类的方法。
     * 按道理来说的确应该是这样，因为父类并不知道自己有没有子类，所以怎么能提前决定调用自己还是子类
     * 的方法，所以如果子类重新了某个方法，父类只可以调用子类重写后的方法。
     * 但是子类因为知道当前有两个方法，所以可以随意调用自己还是父类的同名方法。
     */
    static class Super {
        Super() {
//            this.print();
        }

        void did(){
            this.print();
        }

        void print() {
            System.out.println("super3");
        }
    }

    static class Child extends Super {
        Child(){
            print();
        }

        @Override
        void print() {
            System.out.println("child3");
        }
    }
}

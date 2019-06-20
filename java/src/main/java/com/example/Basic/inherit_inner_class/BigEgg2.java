package com.example.Basic.inherit_inner_class;

/**
 * Created by cuihaichen on 17-5-5.
 */

class Egg2 {
    protected class Yolk {
        public Yolk() { System.out.print("Egg2.Yolk()"); }
        public void f() { System.out.print("Egg2.Yolk.f()");}
    }
    private Yolk y = new Yolk();
    public Egg2() { System.out.print("New Egg2()"); }
    public void insertYolk(Yolk yy) { y = yy; }
    public void g() { y.f(); }
}
public class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk {
        public Yolk() { System.out.print("BigEgg2.Yolk()"); }
        public void f() { System.out.print("BigEgg2.Yolk.f()"); }
    }
    public BigEgg2() { insertYolk(new Yolk()); }
    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
} 

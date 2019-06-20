package com.example.Basic.inner_class;

/**
 * Created by BigFaceBear on 2017.11.22
 * <p>
 * 内部类的内部类，也持有最外层内部类的引用
 */

public class nest_nest_class {
    private void nestNest() {
    }

    class level1 {
        void level1() {
            nestNest();
        }

        class level2 {

            void level2() {
                nestNest();
            }

            class level3 {

                void level3() {
                    nestNest();
                }
            }
        }
    }
}

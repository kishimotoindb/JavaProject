package com.example.Basic.inherit_class_inner_class_member_scope.a;

/**
 * Created by cuihaichen on 17-5-5.
 */

/*
 * 内部类access specifier说明:
 * 假设：
 * 外部类：BaseClass
 * 内部类：BaseInnerClass
 * 结构如下：
 *  public class BaseClass {
        protected class BaseInnerClass{
            int i;
        }

        void method() {
            new BaseInnerClass();
        }
    }
 *
 * 总体说明：
 * 静态内部类的修饰符和非静态内部类的，进入权限上是完全一致的。两者在修饰符维度是没有差别的。
 *
 * 1.内部类自身access specifier
 *     类自身的修饰符，用于限定其他类（除外部类以外）对于内部类的access权限，同成员变量等的规则。对于外部
 *  类，内部类的类修饰符没有意义。外部类可以进入内部类的任何成员。
 *
 *  1)private
 *   其他类不可见。
 *  2)package
 *   与外部类BaseClass同包下的其他类可见。可创建对象，可继承。
 *  3)protected
 *   与外部类BaseClass同包下的其他类可见。可创建对象，可继承。
 *   与外部类BaseClass不同包,但是继承外部类BaseClass的其他类可见。只可继承内部类，不能创建内部类
 *   BaseInnerClass的对象。（
 *     为什么不能创建内部类对象，而只能直接使用内部类？
 *     答：这需要理解protected修饰符的限定作用。protected修饰的成员，只可以直接在继承类中使用，
 *     而不能通过"父类对象.protectedMember"的形式使用。说白了，protected修饰的变量，是不能通过
 *     对象进行调用了，必须在子类中直接调用"protectedMember"，protectedMember前面不能有“父类.”。
 *     所以不能创建protected内部类的对象。
 *         目前的理解还需要在看完jvm原理之后进行补充。不够充分。
 *         不论什么形式，只要是在继承类内访问，就可以。
 *
 *      public class BaseClass {
            public class BaseInnerClass{
                protected int i;
            }

            protected int a;

            void method() {
                new BaseInnerClass();
            }
        }
 *
 *      class OtherPackageInnerClass extends BaseClass.BaseInnerClass {
            OtherPackageInnerClass(BaseClass baseClass) {
                baseClass.super();
                i = 1;
                //这种形式是可以的
                new OtherPackageInnerClass(new BaseClass()).i = 1;
            }
        }
 *   ）
 *   与外部类BaseClass不同包,并且未继承外部类BaseClass的其他类不可见。
 *  4)public
 *   任意可见。
 *
 * 2.内部类成员access specifier
 *      内部类自身的修饰符已经间接的对内部类中成员的access权限产生了一定的影响，所以成员的修饰符是一个
 *   补充，并不能完全决定成员自身的access权限。
 *      首先看内部类自身的限定符，然后再看内部类成员的修饰符。
 *
 *  1)private
 *   任意不可见。
 *  2)package
 *   首先，其他类需要能看到内部类，在内部类对其可见的前提下，内部类成员对其他类等同于普通类成员的包权限。
 *   两个类在同一个包下，
 *   public class BaseClass {
        class BaseInnerClass{
            int i;
        }
      }

      public class PackageClass {
        void method() {
            BaseClass.BaseInnerClass bic = new BaseClass().new BaseInnerClass();
            bic.i=1;
        }
      }

      从上面也可以看出，如果内部类是package的权限，其成员只有(public,protected,package)和(private)
      这两种实际权限。当前情形下，public,protected,package三者限制能力是相同的。

 *  3)protected
 *   与外部类BaseClass同包下的其他类如果可见该内部类。当i的权限为包权限时，包内可见。
 *   与外部类BaseClass不同包,但是继承外部类BaseClass的其他类如果可见该内部类。只可继承内部类，不能创建
 *   内部类BaseInnerClass的对象。在继承类中i可见。
 *
 *   从上面也可以看出，如果内部类是package的权限，其成员只有(public,protected)\(package)\(private)
 *   这三种实际权限。当前情形下，public,protected两者限制能力是相同的。
 *
 *  4)public
 *    任意可见。
 *
 *
 */
public class BaseClass {
    public static class BaseInnerClass{
        protected static int i;
    }

    protected int a;

    void method() {
        new BaseInnerClass();
    }
}

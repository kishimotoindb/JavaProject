package com.example.inherit_class_inner_class_member_scope.b;

import com.example.inherit_class_inner_class_member_scope.a.BaseClass;

/**
 * Created by cuihaichen on 17-5-5.
 */

public class OtherPackageClass {
    void method() {
//        new OtherPackageInnerClass(new BaseClass());
//        new BaseClass().new BaseInnerClass().i;
//        new BaseInnerClass();
//        a = 1;//可以直接使用a，但是不能 new BaseClass().a=1;说明protected的变量在对象外是不可见的
//        new OtherPackageInnerClass(new BaseClass()).i = 1; //!wrong, i is protected
//        new OtherPackageClass().new BaseInnerClass(); !wrong
    }

    class OtherPackageInnerClass extends BaseClass.BaseInnerClass {
        OtherPackageInnerClass() {
            i = 1;
            new OtherPackageInnerClass().i = 1;
        }
    }


}

class A extends BaseClass {

}
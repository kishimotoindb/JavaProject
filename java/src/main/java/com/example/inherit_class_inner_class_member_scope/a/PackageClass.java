package com.example.inherit_class_inner_class_member_scope.a;

/**
 * Created by cuihaichen on 17-5-6.
 */

public class PackageClass {
    void method() {
        BaseClass.BaseInnerClass bic = new BaseClass().new BaseInnerClass();
    }

    class PackageInnerClass extends BaseClass.BaseInnerClass {
        PackageInnerClass(BaseClass bs) {
            bs.super();
        }
    }
}

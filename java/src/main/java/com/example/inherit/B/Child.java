package com.example.inherit.B;

import com.example.inherit.A.Father;
import com.example.inherit.A.FatherHolder;

/**
 * Created by cuihaichen on 17-6-2.
 */

//这里的泛型，只是编译时有效，Father类用的还是ChildHolder的父类FatherHolder，只有
//当Child继承Father的方法set后，在Child中的set方法的参数才是ChildHolder．所以只要
//ChildHolder不是private的，就能写到Father后面的<>中，并且与access identifier
//的权限规则不冲突．
public class Child extends Father<Child.ChildHolder> {


    @Override
    protected void get(ChildHolder c) {
    }

    @Override
    protected void set(ChildHolder childHolder) {

    }

    class ChildHolder extends FatherHolder {
    }
}


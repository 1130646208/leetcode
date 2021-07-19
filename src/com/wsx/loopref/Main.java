package com.wsx.loopref;

/**
 * @author shuangxing.wang
 * @date 2021/7/16
 */
public class Main {
    static A a = new A();
    static B b = new B();

    public static void main(String[] args) {
        a.b = b;
        b.a = a;
    }
}


class A {
    Object b;
}

class B {
    Object a;
}


package com.ouyangliuy.Memory;




public class StaticClassTest  extends ParentStaticClass {


    Integer res;
    static  String init;
    static {
        init = "ddx";
    }

    public StaticClassTest() {
        System.out.println("firs?");
        res = 1;
        System.out.println(res);
        System.out.println(init);
    }
}

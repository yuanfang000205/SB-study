package com.yuanfang.test;

/**
 * @ClassName TestMyArr
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/22
 **/
public class TestMyArr {
    public static void main(String[] args) {
        Operation o = new Operation(4);
        MyArr<Integer> m1 = new MyArr<>(666);
        MyArr<String> m2 = new MyArr<>("你好");
        MyArr<Boolean> m3 = new MyArr<>(false);
        MyArr<Boolean> m4 = new MyArr<>(true);
        o.add(m1);
        o.add(m2);
        o.add(m3);
        o.add(m4);
        o.print();
        System.out.println(o.get(1));


    }
}

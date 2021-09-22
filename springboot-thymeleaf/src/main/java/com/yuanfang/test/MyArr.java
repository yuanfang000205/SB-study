package com.yuanfang.test;

/**
 * @ClassName MyArr
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/22
 **/
public class MyArr<T> {
   private T data;

    public MyArr(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyArr{" +
                "data=" + data +
                '}';
    }
}
class Operation<T>{
    private MyArr[] m;
    /**
     * 记录数组长度*/
    private int length;
    /**创建泛型数组 */
    public Operation(int s){
        if (s > 0){
            this.m = new MyArr[s];
        }else {
            System.out.println("创建异常");
        }
    }
    public void add(T t) {
        if (length < m.length) {
            m[length] = (MyArr) t;
            length++;
        }else {
            System.out.println("数组已满,请创建新的数组！！！");
        }
    }
    public T get(int index){
        T t = null;
        if (index < 0){
            System.out.println("该下标异常，请重新输入！！！");
        }else if (index > m.length-1){
            System.out.println("该下标出现数组越界，请重新输入有效值！！！");
        }else {
            t = (T) m[index];
        }
        return t;
    }
    public void print() {
        for (MyArr myArr : m) {
            System.out.println(myArr);
        }
    }
}

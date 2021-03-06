package com.liuy.test;

/**
 * @className: _lamdba
 * @description: 测试下lambda程序
 * @author: liuy
 * @create: 2021-03-06 15:26
 **/

public class _lamdba {
    /*
    * (parameters) -> expression
    * (parameters) ->{ statements; }
    *
    *
    *
    *
    *
     */
    public void PrintHello(HelloWorld helloWorld){
         for(int i=0;i<10;i++){
             helloWorld.sayHello(i);
         }
    }
    public static void main(String[] args) {
//        HelloWorld c= new HelloWorld() {
//            (s) -> {System.out.println(s);}
//        };
    _lamdba la=new _lamdba();
    HelloWorld helloWorld=(s)->{System.out.println(s);};
    la.PrintHello((s)->{System.out.println(s);});
    }
}

package com.example.demo.hystrixdemo;

import org.junit.Test;

/**
 * @Author zhouguanya
 * @Date 2018/4/1
 * @Description
 */
public class HelloWorldHystrixCommandTest {

    @Test
    public void test() {
        HelloWorldHystrixCommand helloWorldHystrixCommand = new HelloWorldHystrixCommand("张三");
        String result = (String) helloWorldHystrixCommand.execute();
        System.out.println(result);
    }
}

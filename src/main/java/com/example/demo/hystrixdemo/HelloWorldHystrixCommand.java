package com.example.demo.hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Author zhouguanya
 * @Date 2018/4/1
 * @Description HelloWorldHystrixCommand要使用Hystrix功能
 */
public class HelloWorldHystrixCommand extends HystrixCommand {
    private final String name;
    public HelloWorldHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    /**
     * 如果继承的是HystrixObservableCommand，要重写Observable construct()
     * @return
     */
    @Override
    protected String run() {
        return "Hello " + name;
    }

    /**
     * 降级
     * @return
     */
    @Override
    protected String getFallback() {
        return "fallback: " + name;
    }
}

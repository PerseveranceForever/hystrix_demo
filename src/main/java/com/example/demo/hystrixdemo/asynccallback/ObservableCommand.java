package com.example.demo.hystrixdemo.asynccallback;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * @Author zhouguanya
 * @Date 2018/5/21
 * @Description
 */
public class ObservableCommand extends HystrixObservableCommand {

    private final String name;

    protected ObservableCommand(String name) {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ObservableCommand"));
        this.name = name;
    }

    @Override
    protected Observable construct() {
        return null;
    }

    public static void main(String[] args) {

    }
}

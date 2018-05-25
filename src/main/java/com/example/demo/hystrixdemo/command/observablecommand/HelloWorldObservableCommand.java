package com.example.demo.hystrixdemo.command.observablecommand;

import com.example.demo.hystrixdemo.command.HelloWorldCommand;
import rx.Observable;
import rx.Observer;

/**
 * @Author zhouguanya
 * @Date 2018/5/21
 * @Description 注册异步事件回调执行
 */
public class HelloWorldObservableCommand {
    public static void main(String[] args) {
        //注册观察者事件拦截
        Observable<String> observe = new HelloWorldCommand("HelloWorldObservableCommand").observe();

        //注册结果回调事件
        observe.subscribe(result -> {
            //执行结果处理,result 为HelloWorldCommand返回的结果
            //用户对结果做二次处理.
            System.out.printf("拿到执行结果，可以进一步处理%s%n", result);

        });

        //注册完整执行生命周期事件
        observe.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError called");
                e.printStackTrace();
            }

            @Override
            public void onNext(String v) {
                // 获取结果后回调
                System.out.println("onNext: " + v);
            }
        });
    }
}

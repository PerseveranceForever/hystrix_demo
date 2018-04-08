非HystrixBadRequestException异常：以demo为例，当抛出HystrixBadRequestException时，调用程序可以捕获异常，
没有触发getFallback()，而其他异常则会触发getFallback()，调用程序将获得getFallback()的返回


run()/construct()运行超时：以demo为例，使用无限while循环或sleep模拟超时，触发了getFallback()


熔断器启动：以demo为例，我们配置10s内请求数大于3个时就启动熔断器，请求错误率大于80%时就熔断，
然后for循环发起请求，当请求符合熔断条件时将触发getFallback()。更多熔断策略见下文


线程池/信号量已满：以demo为例，我们配置线程池数目为3，然后先用一个for循环执行queue()，触发的run()sleep 2s，
然后再用第2个for循环执行execute()，发现所有execute()都触发了fallback，这是因为第1个for的线程还在sleep，
占用着线程池所有线程，导致第2个for的所有命令都无法获取到线程


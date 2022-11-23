Access Forbidden异常未被处理

> @ExceptionHandler() 局部处理controller层抛出的异常
>
> 而

> [SpringMVC 异常处理体系深入分析__江南一点雨的博客-CSDN博客_mvc重写异常处理](https://blog.csdn.net/u012702547/article/details/115732704#:~:text=首先调用 shouldApplyTo 方法判断当前解析器是否可以处理传入的处理器所抛出的异常，如果不支持，则直接返回 null，这个异常将交给下一个 HandlerExceptionResolver,去处理。 调用 prepareResponse 方法处理 response。)
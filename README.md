# 动态注册广播跟静态注册广播区别
前面我们写了Demo，也介绍了动态注册广播跟静态注册广播,这里我再来总结一下:
- 动态注册  广播的生命周期自己灵活控制,消耗资源少。
- 静态注册  广播一直存在，除非软件卸载。消耗资源稍微大一些。当然现在的手机硬件都跟的上了，这点资源可以忽略不计。

### 广播注意事项
我们都知道收到了广播就会执行onReceive方法，但是在这个方法里面不能做耗时超过10秒的事情，否则会弹出ANR(Application NoResponse)的对话框。如果有需要就另外启动一个Thread处理耗时操作。

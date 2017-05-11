package com.chris.app2;

import dagger.Component;

/**
 * Email: suoyiman@163.coom
 */
//用@Component表示这个接口是一个连接器，能用@Component注解的只能是interface或者抽象类
//Component会从MainModule类中拿那些用@Provides注解的方法来生成需要注入的实例
@Component(modules = MainModule.class)
public interface MainComponent {
    /**
     * 参数是需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
     void inject(MainActivity activity);
}

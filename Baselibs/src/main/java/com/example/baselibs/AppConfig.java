package com.example.baselibs;

//在Baselibs模块中定义AppConfig类，其中的moduleApps是一个静态的String数组
//我们将需要初始化的组件的Application的完整类名放到这个数组中
public class AppConfig {
    private static final String LoginApp = "com.example.login";
    public static String[] moduleApps = {
      LoginApp
    };
}

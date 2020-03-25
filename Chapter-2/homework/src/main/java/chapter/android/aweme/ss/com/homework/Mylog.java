package chapter.android.aweme.ss.com.homework;

import android.app.Application;
import android.util.Log;


public class Mylog extends Application {

    private String logText;
    private int position;

    //log内容初始化
    public void initlogText(){
        logText="";
    }

    //返回log内容
    public String getLogText(){
        return logText;
    }

    //添加log内容
    public void logAppend(String str){
        logText+=str;
    }

}

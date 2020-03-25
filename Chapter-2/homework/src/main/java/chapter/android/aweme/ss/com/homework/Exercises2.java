package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */

public class Exercises2 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        tv=findViewById(R.id.tv_center);
        tv.setText(String.valueOf(getAllChildViewCount(findViewById(R.id.myLayout))));
    }

    public int getAllChildViewCount(View view) {
        int count=0;

        if(view==null){
            return 0;
        }

        if(view instanceof ViewGroup){
            for(int i=0;i<((ViewGroup) view).getChildCount();i++){
                View tmp=((ViewGroup) view).getChildAt(i);
                if(tmp instanceof ViewGroup){
                    count+=getAllChildViewCount(tmp);
                } else{
                    count++;
                }
            }
        }
        return count;
    }
}

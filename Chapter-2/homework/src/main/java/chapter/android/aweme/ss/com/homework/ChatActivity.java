package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    private TextView textItem;
    private TextView textHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        //接收数据
        Intent intent=getIntent();
        String data = "这是第"+intent.getStringExtra("extra_data")+"个item.";
        String data1=intent.getStringExtra("extra_data1");

        //显示
        textItem=findViewById(R.id.tv_content_info);
        textItem.setText(data);
        textHeader=findViewById(R.id.tv_with_name);
        textHeader.setText(data1);

    }

}

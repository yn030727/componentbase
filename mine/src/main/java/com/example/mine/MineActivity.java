package com.example.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

import eventbus.EventMessage;

//这里我们又新建了一个mine模块，和分享模块类似
//只不过这里展示的是用户的个人信息，为了区分EventBus和接口+实现的两种之间的区别。
//所以我们在mine模块进行了注册
@Route(path = "/mine/mine1")
public class MineActivity extends AppCompatActivity {
    TextView mineTextview;

    //在准备订阅事件的组件中注册订阅者
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Ning", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        mineTextview = findViewById(R.id.mine_textview);
        //注册EventBus
        Log.d("Ning", "register");
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ning","unregister");
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void showEventMessage(EventMessage message){
        Log.d("Ning","setText");
        mineTextview.setText(message.getAccount());
    }
}

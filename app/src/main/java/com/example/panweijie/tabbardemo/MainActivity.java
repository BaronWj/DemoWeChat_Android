package com.example.panweijie.tabbardemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;

    private ContentFragment mWeixin;
    private FriendFragment mFriend;
    private FindFragment mFind;
    private SettingFragment mSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void bindFragment(){

    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWeixin = new ContentFragment();
//        mWeixin = new WeixinFragment();
        transaction.replace(R.id.id_content, mWeixin);
        transaction.commit();
    }


    private void bindViews() {
        radioGroup = (RadioGroup) findViewById(R.id.tab_menu);
        btn_one = (Button) findViewById(R.id.rbChat);
        btn_two = (Button) findViewById(R.id.rbAddress);
        btn_three = (Button) findViewById(R.id.rbFind);
        btn_four = (Button) findViewById(R.id.rbMe);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId()) {

            case R.id.rbChat:

                if (mWeixin == null)
                {
                    mWeixin = new ContentFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mWeixin);

                Toast.makeText(getApplicationContext(), "rbChat",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbAddress:

                if (mFriend == null)
                {
                    mFriend = new FriendFragment();
                }
                transaction.replace(R.id.id_content, mFriend);
                Toast.makeText(getApplicationContext(), "rbAdress",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbFind:
                if (mFind == null)
                {
                    mFind = new FindFragment();
                }
                transaction.replace(R.id.id_content, mFind);

                Toast.makeText(getApplicationContext(), "rbFind",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbMe:
                if (mSetting == null)
                {
                    mSetting = new SettingFragment();
                }
                transaction.replace(R.id.id_content, mSetting);

                Toast.makeText(getApplicationContext(), "rbMe",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        // 事务提交
        transaction.commit();
    }


//    private void createFragement() {
//        //步骤一：添加一个FragmentTransaction的实例
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//        //步骤二：用add()方法加上Fragment的对象rightFragment
//        MainActivityFragment rightFragment = new MainActivityFragment();
//        transaction.add(rightFragment, "11");
//
//        //步骤三：调用commit()方法使得FragmentTransaction实例的改变生效
//        transaction.commit();
//
//    }


}

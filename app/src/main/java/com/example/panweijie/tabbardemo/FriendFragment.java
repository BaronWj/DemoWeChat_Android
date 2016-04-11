package com.example.panweijie.tabbardemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FriendAdspter;
import util.FriendCategory;
import util.MyAdspter;

/**
 * Created by panweijie on 16/3/15.
 */
public class FriendFragment extends Fragment{

    private ListView listView = null;
    private View mView;
    private Context mActivity = null;

    private List<String> listTag = new ArrayList<String>();
    private List<String> list = new ArrayList<String>();

    private FriendAdspter friendAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return mView;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_friend, null, false);
        listView = (ListView) mView.findViewById(R.id.friendlist);
//        List<Map<String, Object>> list = getData();
        ArrayList<FriendCategory> listData = getData();
        friendAdapter = new FriendAdspter(getActivity().getBaseContext(), listData);

        listView.setAdapter(friendAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getBaseContext(),  (String)friendAdapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void onAttach(Activity context) {
        super.onAttach(context);
        mActivity = context;
    }

    /**
     * 创建测试数据
     */
    private ArrayList<FriendCategory> getData() {
        ArrayList<FriendCategory> listData = new ArrayList<FriendCategory>();
        FriendCategory categoryOne = new FriendCategory("路人甲");
        categoryOne.addItem("马三立");
        categoryOne.addItem("赵本山");
        categoryOne.addItem("郭德纲");
        categoryOne.addItem("周立波");
        FriendCategory categoryTwo = new FriendCategory("事件乙");
        categoryTwo.addItem("**贪污");
        categoryTwo.addItem("**照门");
        FriendCategory categoryThree = new FriendCategory("书籍丙");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("**大全");
        categoryThree.addItem("**秘籍");
        categoryThree.addItem("**宝典");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        categoryThree.addItem("10天学会***");
        FriendCategory categoryFour = new FriendCategory("书籍丙");
        categoryFour.addItem("河南");
        categoryFour.addItem("天津");
        categoryFour.addItem("北京");
        categoryFour.addItem("上海");
        categoryFour.addItem("广州");
        categoryFour.addItem("湖北");
        categoryFour.addItem("重庆");
        categoryFour.addItem("山东");
        categoryFour.addItem("陕西");

        listData.add(categoryOne);
        listData.add(categoryTwo);
        listData.add(categoryThree);
        listData.add(categoryFour);

        return listData;
    }



}

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

import util.FindAdspter;
import util.FriendAdspter;
import util.FriendCategory;
import util.MyAdspter;

/**
 * Created by panweijie on 16/3/15.
 */
public class FindFragment extends Fragment {
    private ListView listView;
    private View mView;
    private FindAdspter findAdspter;
    private Context mActivity = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_find, null, false);
        listView = (ListView) mView.findViewById(R.id.find_list);
//        List<Map<String, Object>> list = getData();
        List<Map<String, Object>> listData = getData();
        findAdspter = new FindAdspter(getActivity().getBaseContext(), listData);
        listView.setAdapter(findAdspter);

    }

    public void onAttach(Activity context) {
        super.onAttach(context);
        mActivity = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return mView;
    }


    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.mipmap.ic_launcher);
            map.put("title", "朋友圈" + i);
            list.add(map);
        }
        return list;
    }

}

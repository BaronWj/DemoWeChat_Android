package com.example.panweijie.tabbardemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.MyAdspter;

/**
 * Created by panweijie on 16/3/15.
 */
public class ContentFragment extends Fragment {
    private ListView listView = null;
    private View mView;
    private Context mActivity = null;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return mView;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_content, null, false);
        listView = (ListView) mView.findViewById(R.id.listaa);
        List<Map<String, Object>> list = getData();
        listView.setAdapter(new MyAdspter(mActivity, list));
    }


    public void onAttach(Activity context) {
        super.onAttach(context);
        mActivity = context;
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.head11);
            map.put("title", "这是一个标题" + i);
            map.put("info", "这是一个详细信息" + i);
            list.add(map);
        }
        return list;
    }

}

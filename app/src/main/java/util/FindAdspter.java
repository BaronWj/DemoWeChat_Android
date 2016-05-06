package util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.panweijie.tabbardemo.R;

import java.util.List;
import java.util.Map;

/**
 * Created by panweijie on 16/4/14.
 */
public class FindAdspter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public final class Widget_find {
        public ImageView imageView_find;
        public TextView textView_find;
    }


    public FindAdspter(Context context, List<Map<String, Object>> data) {
        this.data = data;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Widget_find widget_find = null;
        if (convertView == null) {
            widget_find = new Widget_find();
            //获得组件，实例化组件
            convertView = layoutInflater.inflate(R.layout.find_list, null);
            widget_find.imageView_find = (ImageView) convertView.findViewById(R.id.icon_find);
            widget_find.textView_find = (TextView) convertView.findViewById(R.id.title_find);
            convertView.setTag(widget_find);
        } else {
            widget_find = (Widget_find) convertView.getTag();
        }
        //绑定数据
        widget_find.imageView_find.setBackgroundResource((Integer) data.get(position).get("image"));
        widget_find.textView_find.setText((String) data.get(position).get("title"));
        return convertView;
    }

}

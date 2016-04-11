package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panweijie on 16/3/28.
 */
public class FriendCategory {

    private String mCategoryName;
    private List<String> mCategoryItem = new ArrayList<String>();

    public FriendCategory(String mCategroyName) {
        mCategoryName = mCategroyName;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public void addItem(String pItemName) {
        mCategoryItem.add(pItemName);
    }

    /**
     *  获取Item内容
     *
     * @param pPosition
     * @return
     */
    public String getItem(int pPosition) {
        // Category排在第一位
        if (pPosition == 0) {
            return mCategoryName;
        } else {
            return mCategoryItem.get(pPosition - 1);
        }
    }

    /**
     * 当前类别Item总数。Category也需要占用一个Item
     * @return
     */
    public int getItemCount() {
        return mCategoryItem.size() + 1;
    }
}

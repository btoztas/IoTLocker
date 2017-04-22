package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brunofgo on 22/04/17.
 */

public class UserAdapter extends BaseAdapter {

    private List<User.UserBean> mUserItem;
    private Context mContext;
    private LayoutInflater inflater;

    public UserAdapter(List<User.UserBean> mUserItem, Context mContext) {
        this.mUserItem = mUserItem;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mUserItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.users_item, parent, false);

        User.UserBean item = (User.UserBean)getItem(position);

        TextView id = (TextView)rowView.findViewById(R.id.user_id);
        TextView name = (TextView)rowView.findViewById(R.id.user_name);
        TextView day = (TextView)rowView.findViewById(R.id.regday);
        TextView hour = (TextView)rowView.findViewById(R.id.reghour);

        id.setText(item.getId());
        name.setText(item.getName());
        day.setText(item.getRegday());
        hour.setText(item.getReghour());

        return rowView;
    }
}

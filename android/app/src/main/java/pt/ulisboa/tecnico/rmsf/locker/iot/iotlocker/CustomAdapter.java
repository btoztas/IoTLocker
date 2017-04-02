package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Response.UserBean> userItem;
    private Context uContext;
    private LayoutInflater inflater;

    public CustomAdapter(List<Response.UserBean> uUserItem, Context uContext) {
        this.userItem = uUserItem;
        this.uContext = uContext;
    }

    @Override
    public int getCount() {
        return userItem.size();
    }

    @Override
    public Object getItem(int position) {
        return userItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)uContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.users_item, parent, false);

        Response.UserBean item = (Response.UserBean)getItem(position);

        TextView user_id = (TextView)rowView.findViewById(R.id.user_id);
        TextView user_name = (TextView)rowView.findViewById(R.id.user_name);

        user_id.setText(item.getId());
        user_name.setText(item.getName());

        return rowView;
    }
}

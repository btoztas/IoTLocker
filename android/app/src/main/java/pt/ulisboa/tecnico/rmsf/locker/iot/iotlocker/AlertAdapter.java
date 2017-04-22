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

public class AlertAdapter extends BaseAdapter {

    private List<Alert.AlertBean> mAlertItem;
    private Context mContext;
    private LayoutInflater inflater;


    public AlertAdapter(List<Alert.AlertBean> mAlertItem, Context mContext) {
        this.mAlertItem = mAlertItem;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mAlertItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mAlertItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.alert_item, parent, false);

        Alert.AlertBean item = (Alert.AlertBean)getItem(position);

        TextView id = (TextView)rowView.findViewById(R.id.alert_id);
        TextView day = (TextView)rowView.findViewById(R.id.day);
        TextView hour = (TextView)rowView.findViewById(R.id.hour);
        TextView description = (TextView)rowView.findViewById(R.id.alert_description);

        id.setText(item.getId());
        day.setText(item.getDay());
        hour.setText(item.getHour());
        description.setText(item.getDescription());

        return rowView;
    }
}

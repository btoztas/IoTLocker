package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brunofgo on 02/04/17.
 */

public class HistoryAdapter extends BaseAdapter{

    private List<History.HistoryBean> historyItem;
    private Context mContext;
    private LayoutInflater inflater;

    public HistoryAdapter(List<History.HistoryBean> historyItem, Context mContext) {
        this.historyItem = historyItem;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return historyItem.size();
    }

    @Override
    public Object getItem(int position) {
        return historyItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.history_item, parent, false);

        History.HistoryBean item = (History.HistoryBean) getItem(position);

        TextView user_id = (TextView)rowView.findViewById(R.id.user_id);
        TextView user_name = (TextView)rowView.findViewById(R.id.user_name);
        TextView hour = (TextView)rowView.findViewById(R.id.hour);
        TextView day = (TextView)rowView.findViewById(R.id.day);

        user_id.setText(item.getId());
        user_name.setText(item.getName());
        hour.setText(item.getHour());
        day.setText(item.getDay());


        return rowView;







    }
}

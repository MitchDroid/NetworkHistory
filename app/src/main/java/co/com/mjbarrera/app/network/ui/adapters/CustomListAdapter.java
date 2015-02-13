package co.com.mjbarrera.app.network.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;

/**
 * Created by Miller Barrera on 28/10/2014.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public CustomListAdapter(Context context, String[] objects) {
        super(context, R.layout.custom_list_view, objects);

        this.context = context;
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_view, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.content = (TextView) rowView.findViewById(R.id.listContent);
        holder.icon = (ImageView) rowView.findViewById(R.id.iconList);


        holder.content.setText(values[position]);


        return rowView;
    }

    static class ViewHolder {
        TextView content;
        ImageView icon;

    }

}

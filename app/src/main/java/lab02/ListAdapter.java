package lab02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication2.app.R;

import java.util.List;

import lab02.database.Tasks;

/**
 * Created by Silwest on 09.04.14.
 */
public class ListAdapter extends ArrayAdapter<Tasks> {
    private final Context context;

    private final List<Tasks> entryList;

    public ListAdapter(Context context, List<Tasks> entryList) {
        super(context, R.layout.lab02_main, entryList);
        this.context = context;
        this.entryList = entryList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.lab02_main, parent, false);

        TextView entryText = (TextView) view.findViewById(R.id.lab02_text);

        entryText.setText(entryList.get(position).getText());
        return view;
    }
}

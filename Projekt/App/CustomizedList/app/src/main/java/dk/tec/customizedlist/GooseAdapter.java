package dk.tec.customizedlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GooseAdapter extends BaseAdapter
{
    private final List<Goose> geese;
    private final MainActivity mainActivity;

    public GooseAdapter(List<Goose> geese, MainActivity mainActivity)
    {
        this.geese  = geese;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return geese.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Goose theGoose = geese.get(position);

        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.custom_item, null);

        ImageView imv = v.findViewById(R.id.imvGoose);
        imv.setImageResource(theGoose.getPicture());

        TextView txtName = v.findViewById(R.id.txtName);
        txtName.setText(theGoose.getName());

        TextView txtDescription = v.findViewById(R.id.txtDescription);
        txtDescription.setText(theGoose.getDescription());

        return v;
    }
}








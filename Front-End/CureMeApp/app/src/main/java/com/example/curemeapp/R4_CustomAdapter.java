package com.example.curemeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class R4_CustomAdapter extends BaseAdapter {

    Context context;
    List<String> password, date;
    LayoutInflater inflater;

    public R4_CustomAdapter(Context c, ArrayList<String> p, ArrayList<String> d){
        context=c;
        password=p;
        date=d;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return password.size();
    }

    @Override
    public Object getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.r4_activity_visits_list_view, null);

        TextView lastVisitText= (TextView) view.findViewById(R.id.R4_lastVisitText);
        TextView dateText= (TextView) view.findViewById(R.id.R4_dateText);
        TextView passwordServiceText= (TextView) view.findViewById(R.id.R4_passwordServiceText);
        TextView passwordText= (TextView) view.findViewById(R.id.R4_passwordText);

        lastVisitText.setText("Προηγούμενη Επίσκεψη: ");
        dateText.setText(date.get(i));
        passwordServiceText.setText("Κωδικός Υπηρεσίας: ");
        passwordText.setText(password.get(i));

        return view;
    }
}
package com.example.g2int101experience.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g2int101experience.R;
import com.example.g2int101experience.models.Desafio;

import java.util.List;

public class ListDesafiosAdapter extends BaseAdapter {

    private Context context;
    private List<Desafio> desafioList;

    public ListDesafiosAdapter(Context context, List<Desafio> desafioList) {
        this.context = context;
        this.desafioList = desafioList;
    }

    @Override
    public int getCount() {
        return desafioList.size();
    }

    @Override
    public Object getItem(int position) {
        return desafioList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_cardview_item, parent, false);
        }

        ImageView imgDesafio = convertView.findViewById(R.id.ivDesafioButton);
        TextView tvDesafio = convertView.findViewById(R.id.tvDesafioButton);

        Desafio desafio = desafioList.get(position);

        //imgDesafio.setImageResource((ImageView) desafio.getImgUlr());
        tvDesafio.setText(desafio.getTitulo());

        return convertView;
    }
}

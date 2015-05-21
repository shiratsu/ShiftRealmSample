package indival.co.jp.shiftrealmsample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import indival.co.jp.shiftrealmsample.R;
import indival.co.jp.shiftrealmsample.model.Area;
import indival.co.jp.shiftrealmsample.model.Pref;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;


/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class PrefAdapter extends RealmBaseAdapter<Pref> implements ListAdapter
{
    private static class ViewHolder {
        public TextView mContent;
        public ViewHolder(View v) {
            mContent = (TextView)v.findViewById(R.id.row_content);
        }
    }

    public PrefAdapter(Context context, RealmResults<Pref> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_condition_row, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mContent.setText(realmResults.get(position).getPrefName());

        return convertView;
    }
}

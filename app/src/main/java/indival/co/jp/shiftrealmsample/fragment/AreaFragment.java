package indival.co.jp.shiftrealmsample.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import indival.co.jp.shiftrealmsample.R;
import indival.co.jp.shiftrealmsample.adapter.AreaAdapter;
import indival.co.jp.shiftrealmsample.common.AppController;
import indival.co.jp.shiftrealmsample.common.OnFragmentInteractionListener;
import indival.co.jp.shiftrealmsample.model.Area;
import io.realm.Realm;
import io.realm.RealmResults;


/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class AreaFragment extends ListFragment
{
    private static final String TAG = AreaFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;
    private Realm mRealm;
    private RealmResults<Area> mItems;

    public static AreaFragment newInstance() {
        return new AreaFragment();
    }

    public AreaFragment() {}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getInstance(getActivity(), "shift_for_shuhu");
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_condition_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mItems = mRealm.allObjects(Area.class);

        AreaAdapter adapter = new AreaAdapter(getActivity(), mItems, true);
        ListView lv = (ListView) view.findViewById(android.R.id.list);
        lv.setAdapter(adapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }
}

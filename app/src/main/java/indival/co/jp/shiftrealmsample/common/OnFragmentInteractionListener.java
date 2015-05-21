package indival.co.jp.shiftrealmsample.common;

import io.realm.RealmObject;

/**
 * Created by Ritsuki Sugiyama <sugiyamari@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public interface OnFragmentInteractionListener {
    public void onFragmentInteraction(RealmObject realm, int mode);
    public void onClickBackToTop();
}

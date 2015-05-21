package indival.co.jp.shiftrealmsample.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class Area extends RealmObject {
    private int id;
    private String AreaCode;
    private String AreaName;
    private RealmList<Pref> prefs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public RealmList<Pref> getPrefs() {
        return prefs;
    }

    public void setPrefs(RealmList<Pref> prefs) {
        this.prefs = prefs;
    }
}
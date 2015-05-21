package indival.co.jp.shiftrealmsample.model;

import io.realm.RealmObject;

/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class Pref extends RealmObject {
    private int id;
    private String PrefCode;
    private String PrefName;
    private Area area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefCode() {
        return PrefCode;
    }

    public void setPrefCode(String prefCode) {
        PrefCode = prefCode;
    }

    public String getPrefName() {
        return PrefName;
    }

    public void setPrefName(String prefName) {
        PrefName = prefName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}

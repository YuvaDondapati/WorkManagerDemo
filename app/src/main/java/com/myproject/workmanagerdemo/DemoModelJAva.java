package com.myproject.workmanagerdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class DemoModelJAva implements Parcelable {
    protected DemoModelJAva(Parcel in) {
    }

    public static final Creator<DemoModelJAva> CREATOR = new Creator<DemoModelJAva>() {
        @Override
        public DemoModelJAva createFromParcel(Parcel in) {
            return new DemoModelJAva(in);
        }

        @Override
        public DemoModelJAva[] newArray(int size) {
            return new DemoModelJAva[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

}

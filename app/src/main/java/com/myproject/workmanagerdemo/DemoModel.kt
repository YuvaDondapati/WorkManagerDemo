package com.myproject.workmanagerdemo

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class DemoModel() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<DemoModel> {
        override fun createFromParcel(parcel: Parcel): DemoModel {
            return DemoModel(parcel)
        }

        override fun newArray(size: Int): Array<DemoModel?> {
            return arrayOfNulls(size)
        }
    }
}
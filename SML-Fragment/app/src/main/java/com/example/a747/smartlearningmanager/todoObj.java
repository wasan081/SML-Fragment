package com.example.a747.smartlearningmanager;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 747 on 27-Aug-16.
 */
public class todoObj implements Parcelable,Serializable{
    private String topic;
    private String desc;
    private Date date;
    private DateTime time;

    public todoObj() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public static final Creator<todoObj> CREATOR = new Creator<todoObj>() {
        @Override
        public todoObj createFromParcel(Parcel in) {
            return new todoObj(in);
        }

        @Override
        public todoObj[] newArray(int size) {
            return new todoObj[size];
        }
    };

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public todoObj(Parcel in) {
        this.topic = in.readString();
        this.desc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(topic);
        dest.writeString(desc);
    }
}

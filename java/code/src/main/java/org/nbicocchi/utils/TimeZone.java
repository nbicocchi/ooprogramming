package org.nbicocchi.utils;

public class TimeZone {
    String name;
    int hour;
    int minute;
    int second;

    public TimeZone() {
        super();
    }

    public TimeZone(String name, int hour, int minute, int second) {
        super();
        this.name = name;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "name='" + name + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}

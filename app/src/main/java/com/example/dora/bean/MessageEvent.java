package com.example.dora.bean;

public class MessageEvent {

    public static final int EVENT_TEST_EVENT_BUS = 0x00;
    public int what;

    public MessageEvent(int what) {
        this.what = what;
    }
}

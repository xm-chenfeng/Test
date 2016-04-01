package com.wind.test.models;

import android.util.Log;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class TestBody extends SugarRecord {
    // {
    // "errorCode": 200,
    // "errorMsg": "ok",
    // "data": {...}
    // }
    private int errorCode;
    private String errorMsg;
    private TestData data;

    public TestBody() {}

    public TestBody(int errorCode, String errorMsg, TestData data) {
        Log.e("Keith", "TestBody::TestBody()");

        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

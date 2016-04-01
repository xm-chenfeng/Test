package com.wind.test.models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class TestData extends SugarRecord {
    int data_item;

    public TestData() {}

    public TestData(int data_item) {
        this.data_item = data_item;
    }

    public int getData_item() {
        return data_item;
    }

    public void setData_item(int data_item) {
        this.data_item = data_item;
    }

}

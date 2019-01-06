package com.example.andrew.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Define a data class that would have the following items:


// This is a holder of the data that would be used for your app.
public class DataItem {
    private int itemId;
    private String itemName;
    private String x;
    private String y;
    private String xax;
    private String yax;
    private String cbt;
    private String zbt;
    private String timestamp;

    public DataItem( int itemId, String itemName, String x, String y, String xax, String yax, String cbt, String zbt, String timestamp) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.x = x;
        this.y = y;
        this.xax = xax;
        this.yax = yax;
        this.zbt = zbt;
        this.cbt = cbt;
        this.timestamp = timestamp;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getXax() {
        return xax;
    }

    public void setXax(String xax) { this.xax = xax; }

    public String getYax() {
        return yax;
    }

    public void setYax(String yax) {
        this.yax = yax;
    }

    public String getCbt() {
        return cbt;
    }

    public void setCbt(String cbt) {
        this.cbt = cbt;
    }

    public String getZbt() {
        return zbt;
    }

    public void setZbt(String zbt) { this.zbt = zbt; }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                "  X='" + x + '\'' +
                ", Y='" + y + '\'' +
                ", X-Axis='" + xax + '\'' +
                "  Y-Axis='" + yax + '\'' +
                ", C-Button='" + cbt + '\'' +
                ", Z-Button='" + zbt + '\'' +
                "  Timestamp='" + timestamp + '\'' +
                '}';
    }
}
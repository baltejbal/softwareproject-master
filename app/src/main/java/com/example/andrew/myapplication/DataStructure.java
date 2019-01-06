package com.example.andrew.myapplication;

public class DataStructure {
        private String name;
        private String x;
        private String y;
        private String xax;
        private String yax;
        private String cbt;
        private String zbt;
        private String timestamp;

        public DataStructure(){

        }
        public DataStructure(String name, String x, String y, String xax, String yax, String cbt, String zbt, String timestamp) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.xax = xax;
            this.yax = yax;
            this.zbt = zbt;
            this.cbt = cbt;
            this.timestamp = timestamp;
        }

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
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
    }



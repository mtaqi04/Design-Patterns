package com.assignment.dp;

public interface SmartBulb {
    String getBrand();
    int getPowerUsage();                 // watts
    void setPowerUsage(int watts);
    void loadUsageFromFile(String path); // sets power usage after creation
}

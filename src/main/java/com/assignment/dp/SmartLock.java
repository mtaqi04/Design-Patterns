package com.assignment.dp;

public interface SmartLock {
    String getBrand();
    int getBatteryConsumption();                 // mAh/day (example unit)
    void setBatteryConsumption(int mahPerDay);
    void loadUsageFromFile(String path);         // sets battery after creation
}

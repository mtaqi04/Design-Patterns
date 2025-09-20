package com.assignment.dp;

public class Demo {
    public static void main(String[] args) {
        // Brand A Bulb
        SmartDeviceFactory brandA = new BrandAFactory();
        SmartBulb bulbA = brandA.createBulb();
        bulbA.loadUsageFromFile("data/brandA_bulb.txt");
        System.out.printf("Bulb: brand=%s, power=%dw%n", bulbA.getBrand(), bulbA.getPowerUsage());

        // Brand B Lock
        SmartDeviceFactory brandB = new BrandBFactory();
        SmartLock lockB = brandB.createLock();
        lockB.loadUsageFromFile("data/brandB_lock.txt");
        System.out.printf("Lock: brand=%s, battery=%d mAh/day%n",
                lockB.getBrand(), lockB.getBatteryConsumption());
    }
}

package com.assignment.dp;

public class BrandAFactory implements SmartDeviceFactory {
    @Override
    public SmartBulb createBulb() {
        return new BrandABulb();
    }

    @Override
    public SmartLock createLock() {
        return new BrandALock();
    }
}

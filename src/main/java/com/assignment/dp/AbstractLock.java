package com.assignment.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractLock implements SmartLock {
    protected final String brand;
    protected int batteryConsumption = 0;

    protected AbstractLock(String brand) { this.brand = brand; }

    @Override public String getBrand() { return brand; }
    @Override public int getBatteryConsumption() { return batteryConsumption; }
    @Override public void setBatteryConsumption(int mahPerDay) { this.batteryConsumption = mahPerDay; }

    // ---------- Factory Method ----------
    // Subclasses can override to parse brand-specific formats.
    protected int readUsage(Path path) throws IOException {
        String firstLine = Files.readAllLines(path).get(0).trim();
        return Integer.parseInt(firstLine);
    }

    @Override
    public void loadUsageFromFile(String filePath) {
        try {
            int value = readUsage(Path.of(filePath));
            setBatteryConsumption(value);
        } catch (Exception e) {
            // Graceful fallback so demo/tests don’t crash
            setBatteryConsumption(120);
            System.err.println("Lock usage load failed, using default: " + e.getMessage());
        }
    }
}

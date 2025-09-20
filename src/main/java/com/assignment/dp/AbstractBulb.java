package com.assignment.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractBulb implements SmartBulb {
    protected final String brand;
    protected int powerUsage = 0;

    protected AbstractBulb(String brand) { this.brand = brand; }

    @Override public String getBrand() { return brand; }
    @Override public int getPowerUsage() { return powerUsage; }
    @Override public void setPowerUsage(int watts) { this.powerUsage = watts; }

    // ---------- Factory Method ----------
    // Subclasses can override to support different file formats.
    protected int readUsage(Path path) throws IOException {
        String firstLine = Files.readAllLines(path).get(0).trim();
        return Integer.parseInt(firstLine);
    }

    @Override
    public void loadUsageFromFile(String filePath) {
        try {
            int value = readUsage(Path.of(filePath));
            setPowerUsage(value);
        } catch (Exception e) {
            // graceful fallback so demo/tests never crash
            setPowerUsage(9);
            System.err.println("Bulb usage load failed, using default: " + e.getMessage());
        }
    }
}

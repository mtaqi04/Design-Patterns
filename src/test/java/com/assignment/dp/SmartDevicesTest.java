package com.assignment.dp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDevicesTest {
    private Path tmpDir;

    private Path createTempDir() throws IOException {
        if (tmpDir == null) tmpDir = Files.createTempDirectory("dp-test-" + UUID.randomUUID());
        return tmpDir;
    }

    @AfterEach
    void cleanup() throws IOException {
        if (tmpDir != null && Files.exists(tmpDir)) {
            try (var s = Files.walk(tmpDir)) {
                s.sorted((a,b) -> b.compareTo(a)).forEach(p -> { try { Files.deleteIfExists(p); } catch (IOException ignored) {} });
            }
        }
    }

    @Test
    void brandABulb_loadsIntegerWattsFromFile() throws IOException {
        SmartDeviceFactory factory = new BrandAFactory();
        SmartBulb bulb = factory.createBulb();

        Path file = createTempDir().resolve("brandA_bulb.txt");
        Files.writeString(file, "9\n");

        bulb.loadUsageFromFile(file.toString());

        assertEquals("BrandA", bulb.getBrand());
        assertEquals(9, bulb.getPowerUsage());
    }

    @Test
    void brandBLock_loadsBatteryKeyValueFromFile() throws IOException {
        SmartDeviceFactory factory = new BrandBFactory();
        SmartLock lock = factory.createLock();

        Path file = createTempDir().resolve("brandB_lock.txt");
        Files.writeString(file, "battery=150\n");

        lock.loadUsageFromFile(file.toString());

        assertEquals("BrandB", lock.getBrand());
        assertEquals(150, lock.getBatteryConsumption());
    }

    @Test
    void bulb_defaultOnMissingFile() {
        SmartBulb bulb = new BrandABulb();
        bulb.loadUsageFromFile("/definitely/missing.txt");
        assertTrue(bulb.getPowerUsage() > 0);
    }

    @Test
    void lock_defaultOnInvalidContent() throws IOException {
        SmartLock lock = new BrandBLock();
        Path file = createTempDir().resolve("bad.txt");
        Files.writeString(file, "not_valid\n");
        lock.loadUsageFromFile(file.toString());
        assertTrue(lock.getBatteryConsumption() > 0);
    }
}

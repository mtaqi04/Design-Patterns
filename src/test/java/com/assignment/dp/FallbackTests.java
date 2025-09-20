package com.assignment.dp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FallbackTests {

    private static Path tempFile(String name, String content) throws IOException {
        Path dir = Files.createTempDirectory("dp-fallback-");
        Path file = dir.resolve(name);
        Files.writeString(file, content);
        return file;
    }

    @Test
    void brandALock_defaultOnMissingFile() {
        SmartLock lock = new BrandALock();
        // Intentionally missing path -> should fall back to default
        lock.loadUsageFromFile("/surely/does/not/exist.txt");
        assertTrue(lock.getBatteryConsumption() > 0);
    }

    @Test
    void brandBBulb_defaultOnInvalidContent() throws IOException {
        SmartBulb bulb = new BrandBBulb();
        // Invalid content -> should fall back to default
        Path bad = tempFile("bad_power.txt", "power=notanumber");
        bulb.loadUsageFromFile(bad.toString());
        assertTrue(bulb.getPowerUsage() > 0);
    }
}

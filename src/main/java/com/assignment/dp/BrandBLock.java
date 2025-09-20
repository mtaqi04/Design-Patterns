package com.assignment.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrandBLock extends AbstractLock {
    public BrandBLock() { super("BrandB"); }

    @Override
    protected int readUsage(Path path) throws IOException {
        for (String line : Files.readAllLines(path)) {
            line = line.trim();
            if (line.startsWith("battery=")) {
                return Integer.parseInt(line.substring("battery=".length()).trim());
            }
        }
        throw new IOException("battery= not found");
    }
}

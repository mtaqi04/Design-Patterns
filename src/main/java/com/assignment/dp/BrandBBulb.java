package com.assignment.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrandBBulb extends AbstractBulb {
    public BrandBBulb() { super("BrandB"); }

    @Override
    protected int readUsage(Path path) throws IOException {
        for (String line : Files.readAllLines(path)) {
            line = line.trim();
            if (line.startsWith("power=")) {
                return Integer.parseInt(line.substring("power=".length()).trim());
            }
        }
        throw new IOException("power= not found");
    }
}

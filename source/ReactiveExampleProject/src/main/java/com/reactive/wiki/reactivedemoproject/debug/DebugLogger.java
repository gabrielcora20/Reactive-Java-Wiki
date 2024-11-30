package com.reactive.wiki.reactivedemoproject.debug;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugLogger {
    private static final Map<String, List<LogEntry>> logsByPackage = new HashMap<>();

    public static void log(String packageName, String variableName, Object value, String location) {
        logsByPackage.computeIfAbsent(packageName, k -> new ArrayList<>())
                .add(new LogEntry(variableName, value != null ? value.toString() : "null", location));
    }

    public static void generateReadmeForPackages(String basePath) {
        for (Map.Entry<String, List<LogEntry>> entry : logsByPackage.entrySet()) {
            String packageName = entry.getKey();
            List<LogEntry> logs = entry.getValue();

            String packagePath = basePath + "/" + packageName.replace(".", "/");
            String filePath = packagePath + "/README.md";

            StringBuilder markdown = new StringBuilder();

            markdown.append("# Debug Log Table for ").append(packageName).append("\n\n");
            markdown.append("| Variable Name | Value        | Location              |\n");
            markdown.append("|---------------|--------------|-----------------------|\n");

            for (LogEntry log : logs) {
                markdown.append(String.format("| %s | %s | %s |\n", log.variableName, log.value, log.location));
            }

            try {
                // Create directories if they don't exist
                java.nio.file.Files.createDirectories(java.nio.file.Paths.get(packagePath));

                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(markdown.toString());
                    System.out.println("Generated README.md for package: " + packageName);
                }
            } catch (IOException e) {
                System.err.println("Error writing README.md for package " + packageName + ": " + e.getMessage());
            }
        }
    }

    private static class LogEntry {
        private final String variableName;
        private final String value;
        private final String location;

        public LogEntry(String variableName, String value, String location) {
            this.variableName = variableName;
            this.value = value;
            this.location = location;
        }
    }
}


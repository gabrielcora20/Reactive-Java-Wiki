package com.reactive.wiki.reactivedemoproject.debug;

import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;

@Component
public class DebugFinalizer {

    @PreDestroy
    public void onShutdown() {
        DebugLogger.generateReadmeForPackages("logs");
    }
}

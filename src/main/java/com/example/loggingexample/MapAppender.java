package com.example.loggingexample;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class MapAppender extends AppenderBase<ILoggingEvent> {

    private final ConcurrentMap<String, ILoggingEvent> eventMap
        = new ConcurrentHashMap<>();

    private String prefix;

    @Override
    protected void append(final ILoggingEvent event) {
        if (prefix == null || "".equals(prefix)) {
            addError("Prefix is not set for MapAppender.");
            return;
        }

        eventMap.put(prefix + System.currentTimeMillis(), event);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    public Map<String, ILoggingEvent> getEventMap() {
        return eventMap;
    }

}
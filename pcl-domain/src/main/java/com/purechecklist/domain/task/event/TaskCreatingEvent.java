package com.purechecklist.domain.task.event;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskCreatingEvent {
    private UUID uuid;
    private UUID listUuid;
    private String text;
    private boolean isCompleted;
}

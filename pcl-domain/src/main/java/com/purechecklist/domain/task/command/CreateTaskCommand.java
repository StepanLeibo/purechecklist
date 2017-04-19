package com.purechecklist.domain.task.command;

import com.purechecklist.domain.task.Task;
import lombok.Value;

import java.util.UUID;

@Value
public class CreateTaskCommand {
    private final UUID uuid;
    private final UUID listUuid;
    private final String text;
    private final boolean isCompleted;
}

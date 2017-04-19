package com.purechecklist.domain.task.command;

import lombok.Value;

import java.util.UUID;

@Value
public class CompleteTaskCommand {
    private final UUID taskUuid;
}

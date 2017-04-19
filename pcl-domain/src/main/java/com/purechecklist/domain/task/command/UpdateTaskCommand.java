package com.purechecklist.domain.task.command;

import com.purechecklist.domain.task.Task;
import lombok.Value;

@Value
public class UpdateTaskCommand {
    private final Task task;
}

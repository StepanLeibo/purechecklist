package com.purechecklist.domain.task.event;

import com.purechecklist.domain.task.Task;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class TaskUpdatedEvent {
    private final Task task;
}

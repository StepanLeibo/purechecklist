package com.purechecklist.domain.task.event;

import com.purechecklist.domain.task.Task;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode
public class TaskCompletedEvent {
    private final UUID taskUuid;
}

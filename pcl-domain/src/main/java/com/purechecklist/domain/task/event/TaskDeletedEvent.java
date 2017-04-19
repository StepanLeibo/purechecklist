package com.purechecklist.domain.task.event;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode
public class TaskDeletedEvent {
    private final UUID taskUuid;
}

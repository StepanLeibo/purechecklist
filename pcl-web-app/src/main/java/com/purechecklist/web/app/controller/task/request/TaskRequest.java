package com.purechecklist.web.app.controller.task.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.UUID;

@Value
public class TaskRequest {
    @JsonProperty
    private final UUID listUuid;

    @JsonProperty
    private final UUID uuid;

    @JsonProperty
    private final String text;

    @JsonProperty
    private final boolean isCompleted;
}

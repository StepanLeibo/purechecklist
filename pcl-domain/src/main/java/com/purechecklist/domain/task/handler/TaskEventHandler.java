package com.purechecklist.domain.task.handler;

import com.purechecklist.domain.task.event.TaskCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;

@Component
public class TaskEventHandler {

    @EventHandler
    public void on(TaskCreatedEvent taskCreatedEvent) {
        System.out.println(taskCreatedEvent);
    }
}

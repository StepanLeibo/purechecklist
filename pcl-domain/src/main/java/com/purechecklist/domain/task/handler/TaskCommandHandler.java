package com.purechecklist.domain.task.handler;

import com.purechecklist.domain.task.command.CreateTaskCommand;
import com.purechecklist.domain.task.event.TaskCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
import static org.axonframework.eventhandling.GenericEventMessage.asEventMessage;

public class TaskCommandHandler {

    private final EventBus eventBus;

    public TaskCommandHandler(EventBus eventBus) {
        this.eventBus = eventBus;
    }

//    @CommandHandler
//    public void handle(CreateTaskCommand createTask) {
////        eventBus.publish(asEventMessage(new TaskCreatedEvent(createTask.getTask())));
//        apply(new TaskCreatedEvent(createTask.getTask()));
//    }

    @EventHandler
    public void on(TaskCreatedEvent taskCreatedEvent) {
        System.out.println(taskCreatedEvent);
    }
}

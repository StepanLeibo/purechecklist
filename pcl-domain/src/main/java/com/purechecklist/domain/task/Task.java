package com.purechecklist.domain.task;

import com.purechecklist.domain.task.command.CreateTaskCommand;
import com.purechecklist.domain.task.event.TaskCreatedEvent;
import com.purechecklist.domain.task.event.TaskCreatingEvent;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Getter
@Aggregate
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @AggregateIdentifier
    private UUID uuid;
    private UUID listUuid;
    private String text;
    private boolean isCompleted;

    @CommandHandler
    public Task(CreateTaskCommand createTask) {
        apply(new TaskCreatingEvent(createTask.getUuid(), createTask.getListUuid(), createTask.getText(), createTask.isCompleted()));
    }

    @EventSourcingHandler
    public void source(TaskCreatingEvent event) {
        this.uuid = event.getUuid();
        this.text = event.getText();
        this.listUuid = event.getListUuid();
        this.isCompleted = event.isCompleted();
    }
}

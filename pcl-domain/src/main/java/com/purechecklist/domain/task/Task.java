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
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Getter
//@AggregateRoot
@Aggregate(repository = "taskAggregateRepository")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = -8034410893990202694L;

    @AggregateIdentifier
    private UUID uuid;
    private UUID listUuid;
    private String text;
    private boolean isCompleted;

    @CommandHandler
    public Task(CreateTaskCommand createTask) {
        apply(new TaskCreatingEvent(createTask.getUuid(), createTask.getListUuid(), createTask.getText(), createTask.isCompleted()));
    }

    @EventHandler
    public void source(TaskCreatingEvent event) {
        this.uuid = event.getUuid();
        this.text = event.getText();
        this.listUuid = event.getListUuid();
        this.isCompleted = event.isCompleted();
    }
}

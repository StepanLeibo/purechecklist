package com.purechecklist.web.app.controller.task;

import com.purechecklist.domain.task.Task;
import com.purechecklist.domain.task.command.CreateTaskCommand;
import com.purechecklist.web.app.controller.task.request.TaskRequest;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

@RestController
public class TaskController {
    private final CommandGateway commandGateway;
    private final CommandBus commandBus;

    @Autowired
    public TaskController(CommandGateway commandGateway, CommandBus commandBus) {
        this.commandGateway = commandGateway;
        this.commandBus = commandBus;
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "task", method = RequestMethod.POST)
    public void createTask(@RequestBody TaskRequest task) {
        commandGateway.send(new CreateTaskCommand(UUID.randomUUID(), task.getListUuid(), task.getText(), task.isCompleted()));
        commandBus.dispatch(asCommandMessage(new CreateTaskCommand(UUID.randomUUID(), task.getListUuid(), task.getText(), task.isCompleted())));
    }
}

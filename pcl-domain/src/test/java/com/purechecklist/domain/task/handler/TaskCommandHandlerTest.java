package com.purechecklist.domain.task.handler;

import com.purechecklist.domain.task.Task;
import com.purechecklist.domain.task.command.CreateTaskCommand;
import com.purechecklist.domain.task.event.TaskCreatingEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.jfairy.Fairy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.UUID;

public class TaskCommandHandlerTest {

    private FixtureConfiguration<Task> testFixture;
    private static final Fairy FAIRY = Fairy.create();

    @Before
    public void setUp() throws Exception {
        testFixture = new AggregateTestFixture<>(Task.class);

        testFixture.registerAnnotatedCommandHandler(new TaskCommandHandler(testFixture.getEventBus()));

    }

    @Test
    public void handle() throws Exception {
        UUID uuid = UUID.randomUUID();
        UUID listUuid = UUID.randomUUID();
        String text = FAIRY.textProducer().word();
        boolean isCompleted = FAIRY.baseProducer().trueOrFalse();
        testFixture.givenNoPriorActivity()
            .when(new CreateTaskCommand(uuid, listUuid, text, isCompleted))
            .expectEvents(new TaskCreatingEvent(uuid, listUuid, text, isCompleted));
    }

}
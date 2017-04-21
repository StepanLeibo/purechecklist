package com.purechecklist.domain;

import com.mongodb.MongoClient;
import com.purechecklist.domain.task.Task;
import com.purechecklist.domain.task.handler.TaskCommandHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.config.Configurer;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.commandhandling.gateway.CommandGatewayFactoryBean;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ComponentScan
//@EnableAxon
public class DomainConfig {
//    @Bean
//    public Configurer axonConfigurer() {
//        Configurer configurer = DefaultConfigurer.defaultConfiguration();
//        return configurer;
//    }

//    @Bean
//    public org.axonframework.config.Configuration axonConfiguration(Configurer configurer) {
//        configurer.registerCommandHandler((item) -> new Task());
////        configurer.
////        configurer.configureAggregate(Task.class);
//        return configurer.buildConfiguration();
//    }
//
    @Bean
    EventBus eventBus() {
        return new SimpleEventBus();
    }

    @Bean
    CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean(CommandBus commandBus) {
        CommandGatewayFactoryBean<CommandGateway> factory = new CommandGatewayFactoryBean<>();
        factory.setCommandBus(commandBus);
        return factory;
    }

    @Bean
    public MongoClient mongo() {
        // todo: move to configuration or service discovery
        return new MongoClient("127.0.0.1", 27017);
    }

    @Bean
    public MongoTemplate mongoSpringTemplate()  {
        return new MongoTemplate(mongo(), "pcl");
    }

    @Bean
    public org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate mongoTemplate()  {
        return new DefaultMongoTemplate(mongo(), "pcl", "domainevents", "snapshotevents");
    }
//
    @Bean
    public EventStore eventStore()  {
        return new EmbeddedEventStore(eventStorageEngine());
    }
//
    @Bean
    public MongoEventStorageEngine eventStorageEngine()  {
        return new MongoEventStorageEngine(mongoTemplate());
    }

//    @Autowired
//    public void configure(EventHandlingConfiguration config) {
//        config.registerEventHandler((b) -> new Task());
//        config.usingTrackingProcessors(); // default all processors to tracking mode.
//    }

//f
    @Bean
    public Repository<Task> taskAggregateRepository(EventStore eventStore)  {
        return new EventSourcingRepository<>(Task.class, eventStore);
    }

//    @Bean
//    public TaskCommandHandler taskCommandHandler(EventBus eventBus) {
//        return new TaskCommandHandler(eventBus);
//    }

//    @Bean
//    public TodoListCommandHandler todoListCommandHandler() throws UnknownHostException {
//        return new TodoListCommandHandler(todoListCommandRepository());
//    }
}

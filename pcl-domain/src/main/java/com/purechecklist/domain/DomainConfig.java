package com.purechecklist.domain;

import com.mongodb.MongoClient;
import com.purechecklist.domain.task.Task;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.config.SagaConfiguration;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.config.AxonConfiguration;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ComponentScan
public class DomainConfig {
//    @Bean
//    public Configurer axonConfigurer() {
//        Configurer configurer = DefaultConfigurer.defaultConfiguration();
//        return configurer;
//    }

//    @Bean
//    public org.axonframework.config.Configuration axonConfiguration(Configurer configurer) {
//        return configurer.buildConfiguration();
//    }

    @Bean
    EventBus eventBus() {
        return new SimpleEventBus();
    }

    @Bean
    public MongoClient mongo() {
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

    @Bean
    public EventStore eventStore()  {
        return new EmbeddedEventStore(eventStorageEngine());
    }

    @Bean
    public MongoEventStorageEngine eventStorageEngine()  {
        return new MongoEventStorageEngine(mongoTemplate());
    }

    @Bean
    public Repository<Task> todoListCommandRepository()  {
        return new EventSourcingRepository<>(Task.class, eventStore());
    }

//    @Bean
//    public TodoListCommandHandler todoListCommandHandler() throws UnknownHostException {
//        return new TodoListCommandHandler(todoListCommandRepository());
//    }
}

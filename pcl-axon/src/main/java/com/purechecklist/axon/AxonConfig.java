package com.purechecklist.axon;

import org.springframework.context.annotation.Configuration;

//@Configuration
public class AxonConfig {
//    @Bean
//    public AnnotationEventListenerBeanPostProcessor annotationEventListenerBeanPostProcessor() {
//        AnnotationEventListenerBeanPostProcessor processor = new AnnotationEventListenerBeanPostProcessor();
//        processor.setEventBus(eventBus());
//        return processor;
//    }
//
//    @Bean
//    public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
//        AnnotationCommandHandlerBeanPostProcessor processor = new AnnotationCommandHandlerBeanPostProcessor();
//        processor.setCommandBus(commandBus());
//        return processor;
//    }
//
//    @Bean
//    public CommandBus commandBus() {
//        SimpleCommandBus commandBus = new SimpleCommandBus();
//        commandBus.setHandlerInterceptors(Arrays.asList(new BeanValidationInterceptor()));
////		commandBus.setTransactionManager(new SpringTransactionManager(transactionManager));
//        return commandBus;
//    }
//
//    @Bean
//    public EventBus eventBus() {
//        return new SimpleEventBus();
//    }
//
//    @Bean
//    public CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean() {
//        CommandGatewayFactoryBean<CommandGateway> factory = new CommandGatewayFactoryBean<CommandGateway>();
//        factory.setCommandBus(commandBus());
//        return factory;
//    }

//	@Bean
//	public EntityManagerProvider entityManagerProvider() {
//		return new ContainerManagedEntityManagerProvider();
//	}

//    @Bean
//    public EventSourcingRepository<Task> taskRepository() {
//        FileSystemEventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("data/evenstore")));
//        EventSourcingRepository<Task> repository = new EventSourcingRepository<Task>(Task.class, eventStore);
//        repository.setEventBus(eventBus());
//        return repository;
//    }
//
//    @Bean
//    public AggregateAnnotationCommandHandler<Task> taskCommandHandler() {
//        AggregateAnnotationCommandHandler<Task> commandHandler = AggregateAnnotationCommandHandler.subscribe(Task.class, taskRepository(), commandBus());
//        return commandHandler;
//    }
}

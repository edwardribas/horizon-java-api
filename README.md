### My first Java Spring-boot API

Initial empty template by https://start.spring.io/. \
Application made using Maven as build system. \
After running the project, you access Swagger on http://localhost:8080/swagger-ui/index.html#/.

Some of the skills I've used/learned:
- Reactive programming with MongoDB
- Implementing Swagger
- Common folder structure/conventions with Java Spring-boot
- Download new dependencies with Maven
- ~~Always check if the dependencies are compatible and not creating another application.properties~~

After finished, I received some feedback and made the following improvements:
- Removed Autowired annotation, using @RequiredArgsConstructor from Lombok
- Removed return logic from the controller
- Implemented getters in the Space entity and made the original properties private
- Fixed the name of SpaceService and SpaceServiceImpl after noticing they were inverted
- Stopped using ReactiveMongoTemplate and moved to @Query and @Update annotations
- Domains were taking place of response/request models.
- Discovered and implemented a better way to throw exceptions

Plans to study:
- https://refactoring.guru/design-patterns/factory-method

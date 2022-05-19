# Quickstarts
## Quarkus App as a ReST server

This is an example of a Quarkus application acting as a server to expose a REST endpoint.

The implementation only requires a class annotated with 'javax.ws.rs' annotations.

The implementation contains an example of a standard as well as a reactive endpoint.

The reactive endpoint display codes that returns Uni, Multi and CompletionStage types.

# 
## Notes

1) A ReST server returns a Response object that encapsulates data as well as header... 

2) Json transformation is implicit as long as there is either the jackson or the jsonb dependency in the pom.xml

3) configuration such as server HTTP port, host, headers... are in application.properties

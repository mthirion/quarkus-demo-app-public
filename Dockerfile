FROM registry.access.redhat.com/ubi8/openjdk-11:1.3
COPY target/quarkus-app /deployments
WORKDIR /deployments
ENTRYPOINT "java -jar /deployments/quarkus-app/quarkus-run.jar"
CMD ["java", "-jar", "/deployments/quarkus-app/quarkus-run.jar" ]
EXPOSE 8090

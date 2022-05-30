FROM registry.access.redhat.com/ubi8/openjdk-11:1.3
RUN mkdir /tmp/deployments && cp -r /workspace/source/target/quarkus-app /tmp/deployments
WORKDIR /tmp/deployments
ENTRYPOINT "java -jar /tmp/deployments/quarkus-app/quarkus-run.jar"
CMD ["java", "-jar", "/tmp/deployments/quarkus-app/quarkus-run.jar" ]
EXPOSE 8090

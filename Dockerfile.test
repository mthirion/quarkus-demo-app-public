FROM openshift/ubi8-openjdk-11:1.3
RUN cd /tmp && git clone https://github.com/mthirion/quarkus-demo-app-public && cd quarkus-demo-app-public && mvn package && cp -r target/quarkus-app /deployments
WORKDIR /deployments
ENTRYPOINT "java -jar /deployments/quarkus-app/quarkus-run.jar"
CMD ["java", "-jar", "/deployments/quarkus-app/quarkus-run.jar" ]
EXPOSE 8090

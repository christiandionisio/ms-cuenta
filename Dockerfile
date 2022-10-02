FROM openjdk:8
ENV SPRING_PROFILES_ACTIVE prod
VOLUME /tmp
EXPOSE 8081
ADD ./target/ms-cuenta-0.0.1-SNAPSHOT.jar ms-cuenta.jar
ENTRYPOINT ["java","-jar","/ms-cuenta.jar"]
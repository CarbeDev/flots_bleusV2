FROM amazoncorretto:17-alpine-jdk

WORKDIR ./app

COPY V2/.mvn .mvn
COPY V2/mvnw ./
COPY V2/pom.xml ./

RUN ./mvnw dependency:resolve
COPY V2/src ./src

CMD ["./mvnw", "spring-boot:run"]

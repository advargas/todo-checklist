FROM davidcaste/alpine-java-unlimited-jce:jre8
WORKDIR /opt
ADD todo-checklist/target/todo-checklist-*.jar /opt/app.jar
RUN sh -c 'touch /opt/app.jar'
ENV spring.application.name todo-checklist
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dloader.classpath=$PWD", "-jar","/opt/app.jar"]

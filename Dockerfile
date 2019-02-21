FROM davidcaste/alpine-java-unlimited-jce:jre8
WORKDIR /opt
ADD target/todo-checklist-*.jar /opt/app.jar
RUN sh -c 'touch /opt/app.jar'
ENV spring.application.name todo-checklist
ENTRYPOINT ["java", "-Dloader.path=/opt","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

FROM java:8
VOLUME /src/temp
ADD target/AdaptiveGameEngine-0.0.1-SNAPSHOT.jar src/app.jar
WORKDIR src/
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java","-jar","app.jar"]

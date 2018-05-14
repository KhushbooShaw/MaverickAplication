FROM java:8
VOLUME /tmp
ADD target/GameRecommendation-0.0.1-SNAPSHOT.jar usr/app.jar
WORKDIR usr/
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java","-jar","app.jar"]
#FROM maven

# Copy the project source code

#COPY . /usr/src

#WORKDIR /usr/src

# This will build the entire project, i.e., all the services of the project and produces a target folder

#RUN mvn clean package -DskipTests=true

#CMD ["java", "-jar", "/usr/src/target/GameRecommendation-0.0.1-SNAPSHOT.jar"]

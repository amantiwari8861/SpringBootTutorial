FROM openjdk:17
ADD target/hello-spring.jar hello-spring.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","hello-spring.jar"]

#docker build -f Dockerfile -t amantiwari8861/hello-spring .
#docker images
#docker run -p 8085:8080 amantiwari8861/hello-spring
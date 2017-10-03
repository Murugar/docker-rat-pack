FROM openjdk:8-jre-alpine
COPY maven/docker-rat-pack.jar /usr/local/myapp/
COPY maven/lib                       /usr/local/myapp/lib
EXPOSE 5050
WORKDIR /usr/local/myapp
CMD exec java -cp "docker-rat-pack.jar:lib/*" com.iqmsoft.docker.ratpack.Application

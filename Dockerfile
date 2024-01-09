FROM --platform=linux/amd64 openjdk:17-alpine
COPY ./*form-*.jar form-service.jar
EXPOSE 8080
ENV CONFIG_ENV=prod
ENTRYPOINT java -jar -Dspring.profiles.active=${CONFIG_ENV} form-service.jar
FROM gradle:jdk11 as builder
WORKDIR /builder
COPY . /builder
RUN gradle build

FROM openjdk:11-jre-slim as runner
EXPOSE 3000

RUN useradd -m demo
USER demo

WORKDIR /home/demo
COPY --from=builder --chown=demo:demo /builder/build/libs/*.jar ./application.jar


ENTRYPOINT ["java"]
CMD ["-jar", "./application.jar", "--spring.profiles.default=docker"]

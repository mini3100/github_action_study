# FROM -> 어떤 가상 환경에서 실행을 할 것인가 선택(jdk)
# ARG -> argument(변수) 대문자, 스네이크로 표기 (ex. TEST_NAME=test)
# CMD -> command 도커환경에서 명령어를 실행할 수 있음(1번만 가능)
# COPY -> TEST_NAME aaa (as)
# ENTRYPOINT ["java", "-Dspring.profiles.active=prod1" "-Dserver.env=green" "-jar", "파일명.jar"]
# 배열이므로 띄어쓰기로 합쳐진다. 옵션을 줄 수 있음(yml 파일의 환경 변수 값을 변경할 수 있다.)

FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
ARG PROFILES
ARG ENV
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.jar"]
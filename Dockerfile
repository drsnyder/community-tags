FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/community-tags.jar /community-tags/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/community-tags/app.jar"]

./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=venkatakrishnan/library-management-jib-maven
docker run -p 8080:8080 --name library-management-jib-maven venkatakrishnan/library-management-jib-maven:latest
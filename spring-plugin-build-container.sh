./mvnw spring-boot:build-image
docker run -p 8080:8080 --name library-management-spring-plugin venkatakrishnan/librarymanagement:latest
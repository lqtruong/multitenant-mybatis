# multitenant-mybatis
Multi-tenancy using different MySQL schemas

# Build Jar file
Use maven to build jar file `mvn clean install -DskipTests`

# Build Docker image
Use `Dockerfile` to build & run the app on Docker container
- Command `docker build -t turong/multitenant-mybatis .` to build the image with tag
- Command `docker run -p 8080:8080 turong/multitenant-mybatis` to run the app on Docker container

Note: the docker service should be installed at your local.
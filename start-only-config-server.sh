cd config-server
mvn package docker:build -DskipTests
cd..
docker-compose up -d config-server
docker-compose logs

# to close it:
# docker ps
# docker stop *id_of_config_server_from_ps_command*

# config server test url to return book-service's configs
# http://localhost:8888/book-service/default

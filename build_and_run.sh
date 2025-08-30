#!/bin/sh
./docker-clean.sh

maven_clean_install_and_build_docker(){
  mvn clean install
  mvn docker:build
}

cd config-server
maven_clean_install_and_build_docker

cd ..
cd discovery-server
maven_clean_install_and_build_docker

cd ..
cd book-service
maven_clean_install_and_build_docker

cd ..
cd book-service-client
maven_clean_install_and_build_docker

cd ..
cd zipkin
maven_clean_install_and_build_docker

cd ..
cd hystrix-dashboard
maven_clean_install_and_build_docker

cd ..
cd zuul-proxy
maven_clean_install_and_build_docker

cd ..
docker-compose up

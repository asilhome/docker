# jenkins

## image
get jenkins image (old version)
```
$ docker pull jenkins
```
run in detached mode
```
$ docker run -p 8080:8080 --name=jenkins-master -d jenkins
```
check logs
```
$ docker logs jenkins-master
```
go to: http://192.168.99.100:8080

run bash
```
$ docker exec -it jenkins-master bash
```
open `/var/jenkins_home/secrets/initialAdminPassword`, copy password
```
$ cat initialAdminPassword
```
exit from bash
```
$ exit
```
start/stop container will maintain the state of the app
```
$ docker stop <container>  # or 'docker start'
```
remove 1st if to start `docker run` again (will generate new initial password)
```
$ docker rm <container>
```
## jenkins
- choose install suggested plugins after enter password
- v2.89.2
- create first admin user
- install gitlab plugin (1.5.2)
- manage jenkins > configure system > gitlab
  - uncheck `Enable authentication for '/project' end-point`

### jenkins-to-gitLab authentication
send build status messages to gitLab
```
gitlab > profile settings > access tokens
```
test connection
```
jenkins > manage jenkins > configure system > gitlab
```
* credentials: gitlab api token > gitlab user profile access token
* api-level: `v3`

## network
- $ docker network create --driver bridge --subnet=10.10.2.00/16 --gateway=10.10.2.38 dockernet
- $ $ docker run -p 10.10.2.38:8080:8080 --name=jenkins-master --network=dockernet-d jenkins

## deploy container to server

hazizurin-gitlab-token
yzP5icdXccYsZ6QQdP1-

http://192.168.99.100:8080/project/jenkins-boot-dev01-branch
docker run -p 192.168.10.20:80:80 mywebserver

docker network ls  # list networks
docker network inspect <network-name>  # a network info
docker network create --driver bridge <network-name>  # create network
docker network rm <network-name>  # remove network

user specified IP address is supported on user defined networks only.

$ docker network create --driver bridge --subnet=10.10.2.00/16 --gateway=10.10.2.38 dockernet

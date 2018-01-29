# jenkins

## image
get jenkins image
```
$ docker pull jenkins
```
run in detached mode
```
$ docker run -p 8080:8080 --name=jenkins-master -d jenkins
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
start/stop container will maintain the state of the app

## deploy container to server

# jenkins

## image
get jenkins image (old version)
```
$ docker pull jenkins
```
try this https://hub.docker.com/r/jenkins/jenkins/

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

## jenkins job
General
- Project name: jenkins-boot-dev01
- Discard old builds
- GitLab connection: gitlab-connection
Source Code Management
- Git
  - Repositories
    - Repository URL: git@10.10.11.50:test_automation_grp/jenkins-boot.git
    - Name: origin
    - Refspec: +refs/heads/*:refs/remotes/origin/* +refs/merge-requests/*/head:refs/remotes/origin/merge-requests/*
  - Branches to build
    - Branch Specifier (blank for 'any'): refs/heads/dev01
Build Triggers
- Build when a change is pushed to GitLab. GitLab CI Service URL: http://10.10.1.201:8080/project/jenkins-boot-dev01
  - Enabled GitLab triggers: Accepted Merge Request Events
Build
- Invoke top-level Maven targets
  - Maven version: manage jenkins > global tool configuration > maven > name
  - Goals: clean package
Post-build Actions
- Archive the artifacts: `**/target/*.jar`
- Publish JUnit test result report: `**/target/surefire-reports/*.xml`
- Publish build status to GitLab commit (GitLab 8.1+ required)
- Email notification

## network
```
docker network ls  # list networks
```

## deploy container to server

hazizurin-gitlab-token
yzP5icdXccYsZ6QQdP1-

http://192.168.99.100:8080/project/jenkins-boot-dev01-branch
docker run -p 192.168.10.20:80:80 mywebserver

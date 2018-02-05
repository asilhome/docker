# jenkins
## image (v2.60.3 - old version)
new, try this https://hub.docker.com/r/jenkins/jenkins/
```
$ docker pull jenkins
```

## run
in detached mode
```
$ docker run -p 8080:8080 --name=jenkins-master -d jenkins
```
remove 1st if to start `docker run` again (will generate new initial password)

### port-forwarding (optional)
add/update > goto: `http://<static-ip>:8080`

## jenkins
### initial admin password
run bash in container
```
$ docker exec -it jenkins-master bash
$ cd /var/jenkins_home/secrets
$ cat initialAdminPassword  # copy password
$ exit  # from bash
```
### customize
1. install suggested plugins
2. create first admin user

### install gitlab plugin (1.5.3)
```
manage jenkins > manage plugins > available > filter: `gitlab` > install without restart
```

### configure system
```
manage jenkins > configure system
```

1. gitlab (send build status to gitLab)
  - uncheck `Enable authentication for '/project' end-point`
  - gitLab connections
    - connection name, gitlab host url
    - credentials: add > jenkins
      - kind: gitlab api token
      - api token: gitlab api token > profile settings > access tokens > create personal access token
    - api level: `v3` (advance)
    - test connection
2. e-mail notification: smtp server: `mail.infopro.com.my` > test configuration
3. maven
```
manage jenkins > global tool configuration > maven > add maven
```
 - name, install automatically

## jenkins job
1. item name: `jenkins-boot-dev01`
2. free style project > ok
3. general
   - project name: `jenkins-boot-dev01`
   - Discard old builds > Max # of builds to keep: 2
   - GitLab connection: gitlab-connection
4. Source Code Management: Git
- Repositories
  - Repository URL: http://10.10.11.50/test_automation_grp/jenkins-boot.git or git@10.10.11.50:test_automation_grp/jenkins-boot.git (ssh???)
  - Advance
    - Name: `origin`
    - Refspec: `+refs/heads/*:refs/remotes/origin/* +refs/merge-requests/*/head:refs/remotes/origin/merge-requests/*`
  - Branches to build > Branch Specifier (blank for 'any'): `refs/heads/dev01`
5. Build Triggers
  - Build when a change is pushed to GitLab. GitLab CI Service URL: `http://<jenkins-host:port>/project/job`
    - Enabled GitLab triggers: `Accepted Merge Request Events`
6. build > add build step
  - invoke top-level maven targets
    - maven version: `manage jenkins > global tool configuration > maven > name`
    - Goals: `clean package`
7. post-build actions > add post-build action
  - archive the artifacts > files to archive: `**/target/*.jar`
  - Publish JUnit test result report: `**/target/surefire-reports/*.xml`
  - Publish build status to GitLab commit (GitLab 8.1+ required)
  - Email notification

## gitlab webhooks
- url
```
http://JENKINS-HOST/project/JOB
```
- trigger: `merge request events`
- enable ssl verification: `uncheck`

## deploy container to server

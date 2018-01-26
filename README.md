# docker v18.01.0-ce
https://docs.docker.com/get-started/

## installation
- windows 10
  - https://www.docker.com/community-edition#/download
- windows 7
  - https://docs.docker.com/toolbox/toolbox_install_windows/
  - not install virtualbox

### test run
docker quickstart terminal (bash)
```
$ docker run hello-world
```
## shared directories
TBD

## signup
https://cloud.docker.com/

## image
- Dockerfile

### build
```
$ docker build -t <image> .
```

### run
```
$ docker run -p 4000:80 <image>
```
goto `http://<docker-machine-ip>:4000` # docker toolbox windows 7

## container
### stop
```
$ CTRL-C
```
windows:
```
$ docker container ls
$ docker container stop <Container NAME or ID>
```
#### detached mode
```
$ docker run -d -p 4000:80 <image>
$ docker container stop <Container NAME or ID>
```

## share image to repository
https://cloud.docker.com/
```
$ docker login
$ docker tag <image> <username>/<repository>:<tag>
```

### publish
```
$ docker push <username>/<repository>:<tag>
```
### run
```
$ docker run -p 4000:80 <username>/<repository>:<tag>
```

## with java
soon.

https://github.com/docker/labs/tree/master/developer-tools/java/

## bash
```
$ docker --version
$ docker images / docker image ls
$ docker-machine ip
```

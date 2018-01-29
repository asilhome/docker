# docker v18.01.0-ce
https://docs.docker.com/get-started/

## projects
- [jenkins](/jenkins/README.md)

## installation
- windows 10
  - https://www.docker.com/community-edition#/download
- windows 7
  - https://docs.docker.com/toolbox/toolbox_install_windows/
  - don't install virtualbox, if already installed

## terminal
open `docker quickstart terminal (bash)`

### test run
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

## commands
```
$ docker --version
$ docker ps  # check for errors
$ docker info  # system-wide info
$ docker-machine ip
$ docker system prune -a  # remove unused data/total cleanup
$ docker image ls -a  # List all images on this machine
$ docker container ls  # List all running containers
$ docker container ls -a  # List all containers, even those not running
```

## from docker
```
docker build -t friendlyhello .  # Create image using this directory's Dockerfile
docker run -p 4000:80 friendlyhello  # Run "friendlyname" mapping port 4000 to 80
docker run -d -p 4000:80 friendlyhello         # Same thing, but in detached mode
docker container ls                                # List all running containers
docker container ls -a             # List all containers, even those not running
docker container stop <hash>           # Gracefully stop the specified container
docker container kill <hash>         # Force shutdown of the specified container
docker container rm <hash>        # Remove specified container from this machine
docker container rm $(docker container ls -a -q)         # Remove all containers
docker image ls -a                             # List all images on this machine
docker image rm <image id>            # Remove specified image from this machine
docker image rm $(docker image ls -a -q)   # Remove all images from this machine
docker login             # Log in this CLI session using your Docker credentials
docker tag <image> username/repository:tag  # Tag <image> for upload to registry
docker push username/repository:tag            # Upload tagged image to registry
docker run username/repository:tag                   # Run image from a registry
```

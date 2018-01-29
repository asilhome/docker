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
check
```
$ docker -v  # version
$ docker version  # clien & server
$ docker ps  # check running containers
$ docker info  # system-wide info
$ docker-machine ip
```
image
```
$ docker image ls -a  # List all images on this machine
$ docker pull jenkins  # get image from public repo/registry
```
```
$ docker run <image>
$ docker run -p 4000:80 <image>  # Run "friendlyname" mapping port 4000 to 80
$ docker run -d -p 4000:80 <image>  # in detached/daemon mode
$ docker run username/repository:tag  # from a registry
$ docker run -p 8080:8080 --name=<container> <image>  # give container name
```
container
```
$ docker container ls  # List all running containers
$ docker container ls -a  # List all containers, even those not running
$ docker logs <container>  # see logs
$ docker exec -it <container> bash  # open bash in container
```
```
docker stop <container>
docker start <container>
docker container stop <container>
docker container stop <hash>
```
```
docker rm <container>
docker container rm <hash>  # remove container
```
house-keeping
```
$ docker system prune -a  # remove unused data/total cleanup
```
## from docker
```
docker build -t friendlyhello .  # Create image using this directory's Dockerfile
docker container kill <hash>         # Force shutdown of the specified container
docker image rm <image id>            # Remove specified image from this machine
docker image rm $(docker image ls -a -q)   # Remove all images from this machine
docker login             # Log in this CLI session using your Docker credentials
docker tag <image> username/repository:tag  # Tag <image> for upload to registry
docker push username/repository:tag            # Upload tagged image to registry
```

# other images
- https://github.com/mysql/mysql-docker
- oracle
- jboss fuse
- pentaho

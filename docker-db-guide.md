Reference: [Docker-mysql](https://hub.docker.com/_/mysql)

Create docker container
```
docker run --name bookshop-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql
```

Get into container bash
```
docker exec -it bookshop-db bash
```
Get into Mysql
```
mysql -p
```

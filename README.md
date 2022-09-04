# Build & run

Server consists of the java server and postgres database. Both are declared in `setup/docker-compose.yml` file.  
To build the server, execute following command inside **setup** folder:
```bash
docker compose build
```

And to run the stack, execute command in the same folder:
```bash
docker compose up
```
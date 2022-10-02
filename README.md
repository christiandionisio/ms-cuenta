# Módulo: ms-cuenta
Para ejecutar localmente, se necesita ejecutar los siguientes comandos

### Generar el JAR

```
mvn clean install 
```

### Crear la imagen

```
docker build -t ms-cuenta:latest .
```

### Crear la network
En el caso que ya se haya creado la network omitir este paso

```
docker network create challenge-nttdata
```

### Ejecutar la imagen

```
docker run -d -p 8081:8081 --name ms-cuenta --net challenge-nttdata ms-cuenta:latest
```
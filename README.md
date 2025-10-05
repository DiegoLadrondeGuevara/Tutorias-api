# 🧑‍🏫 Proyecto Tutoría - Guía de despliegue

## 🚀 Paso 1: Construir y levantar la API

```bash
mvn clean package
docker-compose up --build
```

para conectarse a la bd de la mv de bd

✅ 1. Crea la máquina virtual de base de datos y corre MariaDB

En tu máquina virtual de base de datos, haz lo siguiente:

a) 📁 Crea un docker-compose.yml

version: '3.8'

services:
mariadb:
image: mariadb:11
container_name: mariadb
restart: always
environment:
MARIADB_ROOT_PASSWORD: rootpassword
MARIADB_DATABASE: tutoria_db
ports:
- "3306:3306"
volumes:
- mariadb_data:/var/lib/mysql

volumes:
mariadb_data:


b) 🚀 Inicia el contenedor
docker-compose up -d

✅ 2. Asegura que el puerto 3306 esté accesible

En la máquina virtual de BD, corre:
sudo ufw allow 3306/tcp

✅ 3. Obtener IP pública o privada de la base de datos

Desde tu MV de BD:

✅ 4. Cambiar application.yml en tu API

En tu API, dentro del archivo application.yml, reemplaza localhost o db con la IP de la base de datos:
spring:
datasource:
url: jdbc:mariadb://192.168.10.25:3306/tutoria_db
username: root
password: rootpassword

✅ 5. Dockeriza y ejecuta tu API

En tu máquina donde está la API, haz esto:
mvn clean package
docker build -t tutoria-api .
docker run -d -p 8080:8080 tutoria-api

🧪 6. Verifica que funcione
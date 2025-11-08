# VentasDAO

Repositorio en donde estamos desarrollando.


### Installing 🔩
Ejecutar scripts de la en la base de datos

Utilizar el siguiente comando para iniciar todo.(con "-d" al final para que se ejecute en segundo plano.)
```
docker compose up
```
Para apagar los servicios:
```
docker compose stop
```
Para iniciar los servicios luego de haberlos apagado con el comando anterior:
```
docker compose start
```
Para bajar ("-v" para borrar los servicios de tu maquina junto a los volumentes (datos))
```
docker compose down -v
```

## Credenciales de la base de datos
usuario: postgres

contraseña: admin

puerto: 5432
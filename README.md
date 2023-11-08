# Exchange rate project

El presente proyecto tiene como finalidad la solución del reto técnico propuesto por la consulta Tata Consultancy Services como parte del proceso de selección. A continuación, se brindará información sobre la solución del proyecto.


# Run project

El proyecto tiene 2 maneras de levantar.
- Clonar el repositorio y abrirlo en un IDE y levantarlo localmente
- Clonar el repositorio, abrirlo en un IDE, ejecutar el maven install y levantar con docker

### Levantar con Docker
- Situarse en la raíz del proyecto /exchange-rate
- Ejecutar el siguiente comando para crear la imagen:
  > docker build -t exchange-rate:latest .

- Ejecutar el siguiente comando para levantar:
  > docker run -p 8080:8080 exchange-rate


# Endpoints

**Generación de token - POST**
> Este endpoint generá el token JWT que servirá como seguirdad para consultar los demás endpoints. El token se devolverá en la respuesta de la cabecera

    curl --location 'http://localhost:8080/login' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=ABB976E484365D2C7CACBCED9115C4A9' \
    --data-raw '{
        "email": "echamaya@gmail.com",
        "password": "123456"
    }'

**Convertir tipo de cambio - GET**
> Este endpoint tiene como objetivo convertir la moneda origen a una moneda destino, recibe como parámetros (query param):
> - amount: Monto que desea convertir
> - fromCurrency: Moneda de origen
> - toCurrency: Moneda de destino

    curl --location 'http://localhost:8080/exchange-rates/convert?amount=1000&fromCurrency=USD&toCurrency=PEN' \
    --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlY2hhbWF5YUBnbWFpbC5jb20iLCJleHAiOjE3MDIwNTI5NzgsIm5hbWUiOiJlY2hhbWF5YUBnbWFpbC5jb20ifQ.UoGgCZ4UIajGUyXCF7cwAid85SYoRuHqYOjuznlXSKA' \
    --header 'Cookie: JSESSIONID=ABB976E484365D2C7CACBCED9115C4A9'


**Crear tipo de cambio - POST**
> Este endpoint tiene como objetivo crear un nuevo tipo de cambio, recibe como parámetros un objeto en formato JSON:
> - fromCurrency: Moneda de origen
> - toCurrency: Moneda de destino
> - rate: tarifa del tipo de cambio

    curl --location 'http://localhost:8080/exchange-rates' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlY2hhbWF5YUBnbWFpbC5jb20iLCJleHAiOjE3MDIwNTI5NzgsIm5hbWUiOiJlY2hhbWF5YUBnbWFpbC5jb20ifQ.UoGgCZ4UIajGUyXCF7cwAid85SYoRuHqYOjuznlXSKA' \
    --header 'Cookie: JSESSIONID=ABB976E484365D2C7CACBCED9115C4A9' \
    --data '{
        "fromCurrency": "MXN",
        "toCurrency": "PEN",
        "rate": 0.21
    }'

# Postman Collection

Aquí podrá consultar la documentación de la API en Postman: [Postman Collection Exchange Rate](https://documenter.getpostman.com/view/18916519/2s9YXiY1Ut)

# Swagger

Aquí podrá consultar la documentación de la API: [Swagger Documentation Exchange Rate](http://localhost:8080/swagger-ui/index.html#/exchange-rate-controller)




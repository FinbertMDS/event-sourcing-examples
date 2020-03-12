# Run Event-Sourcing+CQRS example application

## Development
### Building and running using Eventuate Local
First, build the application

```
cd java-spring
./gradlew assemble -P eventuateDriver=local
```

Second, launch the services using [Docker Compose](https://docs.docker.com/compose/):

```
export DOCKER_HOST_IP=...
docker-compose -f docker-compose-eventuate-local.yml up -d
```

Next, run `js-frontend`

```
cd js-frontend
yarn
yarn start-dev
```

Finally, you can open the home page, which is served up by the API Gateway: http://localhost:3000

Note: 

1. If you change code in any services, only build that service and relation services. 

Eg: When logout in `common-auth-web`, you must rebuild `api-gateway-service`  

```
./gradlew :common-auth-web:assemble :api-gateway-service:assemble -P eventuateDriver=local
```

Then, build again docker image of that service and launch again the services:

```
docker-compose -f docker-compose-eventuate-local.yml build apigateway
docker-compose -f docker-compose-eventuate-local.yml up -d
```

2. If you run project behind proxy, you change devServer settings config at the file `js-frontend/config/webpackConfigParts.js`

```
devServer > proxy > '/api/**' > target
```

3. If you run project in Mac/Ubuntu then change `package.json > scripts > start-dev` commnd

```
set => export 
```

## Production
### Building and running using Eventuate Local
First, build `js-frontend`

```
cd js-frontend
yarn
yarn build
```

Second, build the application

```
cd java-spring
./gradlew assemble -P eventuateDriver=local
```

Next, launch the services using [Docker Compose](https://docs.docker.com/compose/):

```
export DOCKER_HOST_IP=...
docker-compose -f docker-compose-eventuate-local.yml up -d
```

Finally, you can open the home page, which is served up by the API Gateway: http://$DOCKER_HOST_IP:8080
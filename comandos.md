```
docker build --tag lucasnp1990/microservice-hash:v1-0.0.1 .

docker push lucasnp1990/microservice-hash:v1-0.0.1

docker build --tag lucasnp1990/microservice-hash:v2-0.0.1 .

docker push lucasnp1990/microservice-hash:v2-0.0.1

kubectl create namespace v1 && kubectl create namespace v2

kubectl label namespace v1 istio-injection=enabled && kubectl label namespace v2 istio-injection=enabled

helm dependency update ./helm/Charts/app/

helm upgrade --install microservice-v1 ./helm/Charts/app/ --wait --set image=lucasnp1990/microservice-hash --set version=v1-0.0.1 --namespace v1 --create-namespace --wait --debug

helm upgrade --install microservice-v2 ./helm/Charts/app/ --wait --set image=lucasnp1990/microservice-hash --set version=v2-0.0.1 --set istio.enabled=true --namespace v2 --create-namespace --wait --debug


# Se executar um dos comandos abaixo, passando como parâmetro o path que quer chamar, ele vai retornar a versão que está batendo no backend

./test.sh cart

./test.sh checkout

```
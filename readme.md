# Java Hello World in a Kubernetes Container

# Building

## Login to Docker Hub

```powershell
# Note, your username is not your email address. Login from the browser to see what your username is.
docker login
```

## Build Docker Image

```powershell
$timestamp = (Get-Date).tostring("yyyyMMddhhmmss")
docker build -t javahello:$timestamp .
docker tag javahello:$timestamp javahello:latest
```

## Set up a local docker repository for Kubernetes to read from

```powershell
docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

## Push the docker image to the local registry

```powershell
docker tag javahello:latest localhost:5000/javahello:latest
docker push localhost:5000/javahello:latest
```

## Deploy to Kubernetes

```powershell
kubectl apply -d deployment.yaml
```

## Check that the Pod is running

```powershell
kubectl get pods
```

## Watch the logs from the container

```powershell
kubectl logs pod/javahello-967b669b-nbzvk --namespace=default --container=javahello -f
```

## Remove the deployment

```powershell
kubectl delete deployment javahello
```
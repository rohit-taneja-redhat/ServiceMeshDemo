# ServiceMeshDemo

## Pre-requisites
- Service Mesh Installed on a namespace already

## Installation
---------------
- Create a new Project
- Add this project to Service Mesh member Roll
- create this service by deploying this yaml file: servicea-deploy.yaml
command: oc create -f servicea-deploy.yaml
- Repeat this step for another service using the yaml file serviceb-deploy.yaml
command: oc create -f serviceb-deploy.yaml
- create a gateway which describes the ingress gateway for traffic entering the mesh
command: oc create -f gateway.yaml
- Create a virtual service to redirect traffic to servicea, which acts like an entry point to the mesh
command: oc create -f virtual-service.yaml

## Test the microservice
- Go to the pod for service A
- click on pod, and then click terminal
- inside the terminal, run the following command.
command: GATEWAY_URL=$(oc get route istio-ingressgateway -n istio-system -o template --template '{{ "http://" }}{{ .spec.host }}')
command 2: curl ${GATEWAY_URL}/trace


# Description 

This project contains the evolution of my blog series about Micronaut

+ [Micronaut series - part I (Consul, Service Discovery & Registry)][1]
+ [Micronaut series - part II ( Traceability & Server side events)][2]
+ [Micronaut series - part III (Deployment using K8)][3]
+ [Micronaut series - part IV (Serverless functions)][4]


[1]: https://mfarache.github.io/mfarache/Building-microservices-Micronoaut/
[2]: https://mfarache.github.io/mfarache/Traceability-microservices-Micronoaut/
[3]: https://mfarache.github.io/mfarache/Deploying-Micronaut-Kubernetes/
[4]: https://mfarache.github.io/mfarache/Micronaut-Functions/

I recommend to read the first post to grab an idea of what we are buillding. 

NOTE: If you start reading the series you will find out that the project structure has changed.

In case you are interested on seeing the evolution or want to play with something specific.

The following tags match with each of the blog posts:

| Tables        | Tag          | 
| ------------- |:-------------:| 
| [Micronaut series - part I (Consul, Service Discovery & Registry)][1]    | blog-1 | 
| [Micronaut series - part II ( Traceability & Server side events)][2]    | blog-2 | 
| [Micronaut series - part III (Deployment using K8)][3]    | blog-3 | 
| [Micronaut series - part IV (Serverless functions)][4]     | blog-4 | 

# Clone this project

Assume $workspace is the root to all projects

## Contents

There are 2 microservices and one serverless function.

+ The waiter depends on the billing
+ The billing  depends on the serverless function.
+ The Serverless code can be deployed in AWS (or run locally)

Both microservices implement the following features :

+ Service Registry & Discovery (Consul)
+ K/V Store (Consul)
+ Retries / Fallsback
+ Distributed tracing (Zipkin)


There are supporting files that are necessary for + [Micronaut series - part III (Deployment using K8)][4]
+ All the projects contain a Dockerfile.
+ There is so we can deploy them 


The final architecture after 4 iterations looks like:

![Proejct Dependencies][logo]

[logo]: https://mfarache.github.io/mfarache/images/MICRONAUT-LAMBDA-FINAL.png "Proejct Dependencies"

## A bit of history. Why so many projects?

Initially only 2 microservices were available. They were  
strongly coupled in the sense that Waiter depended fully on 
the Billing (including both server and client bits).

That was a flaw in the design that has side impact like exposing the billing endpoint through the waiter application, which is undesired. Therefore every microservice has now a server, client and model. Same happens for the serverless function explained in [Micronaut series - part IV][4]

# Start consul (optional if u only want to build)

There are integration tests that require having a consul server.
You can skip this step if you prefer to build all the project skipping test execution with maven

```bash
docker run -p 8500:8500 consul
```

# Start zipkin (optional if u only want to build)
You can skip this step if you prefer to build all the project skipping test execution with maven
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

# Build

## 1. billing model and beer model

```bash
cd $workspace/beer-billing-model/ ; mvn clean install
cd $workspace/beer-cost-function-model/ ; mvn clean install
```

## 2. Build client and server app for Lambda functions

```bash
cd $workspace/beer-cost-function/ ; mvn clean install
cd $workspace/beer-cost-function-client/ ; mvn clean install
cd $workspace/beer-cost-function-app/ ; mvn clean install
```

## 3. Build the billing project 
```bash

cd $workspace/beer-billing/ ; mvn clean install
cd $workspace/beer-billing-client/ ; mvn clean install
```

## 4. Build the waiter project 
```bash
cd $workspace/beer-waiter/ ; mvn clean install
```


# Start consul
docker run -p 8500:8500 consul
# Build the waiter project 
cd ./beer-waiter/ ; mvn clean install
# Build the billing project 
cd ./beer-billing/ ; mvn clean install

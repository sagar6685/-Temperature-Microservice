MongoDB user for NoSQL BD. 
	- Pleaes install 
	- run on localhost:27017
	- database: Temperaturedata
	- Entiry: Temperature
	
API-GATEWAY			--> http://localhost:9100
- Route to USER-SERVICE and TEMPERATURE-SERVICE and do load balancing too

SERVICE-DISCOVERY	--> http://localhost:8761
- service discovery server. USER-SERVICE and TEMPERATURE-SERVICE connect to service registry

CONFIG-SERVICE 		--> http://localhost:9300
- common configuration placed on repository and load using configuration server

TEMPERATURE-SERVICE	n/a (1)	(1)	UP (1) - AHM-L-SagarP.STLERI.COM:TEMPERATURE-SERVICE:9001
- service capture temperature of user

USER-SERVICE	n/a (1)	(1)	UP (1) - AHM-L-SagarP.STLERI.COM:USER-SERVICE:9002
- user service register user 

DISTRIBUTED REQUEST/LOGS TRACKING
- Distributed logs implemented by zipkin / sleuth
- zipkin URL -> http://127.0.0.1:9411/ 
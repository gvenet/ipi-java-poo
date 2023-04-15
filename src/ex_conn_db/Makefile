all: re run

re: down start

run:
	@javac util/*.java && javac Main.java && java Main	
start:
	@docker-compose up -d --build
stop:
	@docker-compose stop
down:
	@docker-compose down --remove-orphans
term:
	@docker exec -it mariadb bash


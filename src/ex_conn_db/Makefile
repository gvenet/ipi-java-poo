all: start run

re: down clear start run

run:
	@javac util/*.java && javac Main.java && java Main	

start:
	@mkdir -p db_data
	@docker-compose up -d
	@sleep 3

stop:
	@docker-compose stop

down:
	@docker-compose down --remove-orphans

term:
	@docker exec -it mariadb bash

clear:
	docker system prune -f
	docker image prune -af
	docker volume prune -f
	rm -rf db_data

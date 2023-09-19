# Como executar o backend do projeto

## 1- coisas necessárias
- Docker ou postgres instalado na máquina
- java 17 ou posterior
- IDE ou compilador para o código
- dbeaver (recomendado, para consultas no banco caso precisemos de alterações futuras)

## 2 - executando o projeto

Você não precisa usar docker se não quiser e se tiver o postgres instalado pode só pular
para os próximos passos e criar um banco seguindo as definições no docker-compose, sendo elas nome do banco, nome do usuário, senha.

Após você clonar ele, você pode abrir um terminal na pasta raiz e executar
o seguinte comando para ter o banco de dados na sua máquina:
> docker-compose up -d

Após ter o banco de dados na sua máquina, você pode abrir o projeto em seu IDE de preferência
e mandar executar ou abrir o terminal e executar umm dos seguintes comandos:
> gradle bootRun

> ./gradlew bootRun

Agora falando em testes, é a mesma coisa, mas com um dos seguintes comandos:
> gradle test

> ./gradlew test

Depois disso, você pode importar via postman a coleção na pasta resources ou acessar o swagger na seguinte url para testar os endpoints e retornos. Voce também pode usar a coleção
do postman que está na presente na wiki, basta pegar o cógio detacado na página "coleção do postman e salvar num arquivo json.

> http://localhost:8080/v1/swagger-ui/index.html#/

## WIKI
Na wiki está a documentação do projeto, explicando as decisões tomadas para o projeto, fluxogramas do projeto e diagramas do baco de dados
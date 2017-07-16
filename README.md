# Cadastro de cervejas artesanais

O objetivo deste projeto é avaliar o desenvolvimento de uma aplicação java utilizando Spring e APIs.

### Baseado no [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/).

#Instrução para Build

 1. Realizar o Git Clone do repositório https://github.com/zonete/beerhouseapi.git
 2. Criar tabela beer  utilizando o script abaixo:
<pre>
   create table beer
	    (
	    	id int not null auto_increment
	    		primary key,
	    	alcohol_content varchar(255) null,
	    	category varchar(255) null,
	    	ingredients varchar(255) null,
	    	name varchar(255) null,
	    	price float null
	    );
</pre>
*Obs.: Script da tabela se encontra na pasta docs/script.sql*
 3. Importar o projeto para dentro da sua IDE como um projeto MAVEN existente.
> *Nota: Caso estiver utilizando o Eclipse  (File -> Import) na tela aberta selecionar a opção "Existing Maven Projects". Na próxima tela selecionar o diretório onde foi realizado o clone do projeto e avançar*

 4. Alterar as informações referente ao banco de dados em "src/main/resources/application.properties"  
<pre>
spring.datasource.url=jdbc:mysql://endereçobanco:porta/database
spring.datasource.username=usuarioacessobd
spring.datasource.password=senhabd
</pre>

 5. Executar a classe "Application.java" localizada no package "com.beerhouse"

 6. A aplicação será iniciada no endereço http://localhost:9000/beerhouse/beers/

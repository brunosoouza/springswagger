
# Spring boot com swagger

Tecnologias utilizadas:

O Spring Boot 3 é um framework robusto e flexível que permite o desenvolvimento ágil de aplicações Java.

Swagger é uma ferramenta de código aberto para documentação de APIs (interfaces de programação de aplicativos). Ele permite descrever, documentar e visualizar as operações de uma API de forma padronizada, tornando mais fácil para os desenvolvedores entenderem como usar a API.

Com o Swagger, é possível criar uma documentação interativa para sua API que pode ser facilmente visualizada em um navegador. Isso torna mais fácil para os desenvolvedores testarem e interagirem com a API, bem como entenderem as operações e os parâmetros disponíveis.

Com essas ferramentas, desenvolvi um projeto que tem como objetivo ser uma POC(proof of concept) de como integrar o swagger a uma app SpringBoot




## Stack utilizada

**Back-end:** Spring boot 3, Swagger


## Como usar

Após iniciar a aplicação, você pode acessar a API REST disponibilizada em http://localhost:8083 ou por outro endereço de IP no ambiente ao qual você subiu a aplicação (esta segunda opção pode variar muito de ambiente, consulte seu administrador de rede caso necessario)

Não existe um banco de dados ou qualquer outra forma de persistencia real neste projeto, foram criadas simulações "mocks" para retornar uma resposta do ambiente, o foco deste projeto é demonstrar como uma API construida sobre o spring boot pode ser documentada com o swagger

#### Endpoints necessarios para inicio

* http://localhost:8081/swagger  - Acesse o swagger por este endereço (ele ira fornecer os outros endpoints com, exceto o endpoint raiz (http://localhost:8081/) que foi desabilitado de propostio por não ter operação rest alguma)


* http://localhost:8081/api-docs  - Dados JSON da api que o swagger ira consumir
## Licença

[MIT](https://choosealicense.com/licenses/mit/)

Este projeto está sob a licença MIT. Consulte o arquivo LICENSE.md para obter mais informações.


## 🔗 Mídia Social

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/brunomgsouza/)






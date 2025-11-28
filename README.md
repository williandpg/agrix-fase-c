<h1><strong>Agrix – Fase C</strong></h1>

<h2><strong>Descrição</strong></h2>
<p align="justify">
  A Fase C do Agrix marca a etapa de amadurecimento do projeto, com foco em segurança e controle de acesso.  
  Depois de construir e expandir as funcionalidades nas Fases A e B, agora o objetivo é proteger as rotas da API com autenticação e autorização, garantindo que apenas pessoas devidamente autenticadas e com permissões corretas possam acessar determinados recursos.
</p>
<p align="justify">
  Nesta fase, o projeto passa a utilizar <strong>Spring Security</strong> e <strong>JWT</strong>, adicionando fluxo de login, cadastro de pessoas e restrições de acesso às rotas sensíveis de fazendas, plantações e fertilizantes.
</p>

<h2><strong>Funcionalidades</strong></h2>
<ul>
  <li align="justify"><strong>Migração do código da Fase B</strong>: Importação e adaptação da base desenvolvida na Fase B para a Fase C.</li>
  <li align="justify"><strong>POST /persons</strong>: Criação de novas pessoas no sistema para uso posterior na autenticação.</li>
  <li align="justify"><strong>Autenticação com JWT</strong>: Implementação de login que retorna um token JWT para acesso autenticado às rotas protegidas.</li>
  <li align="justify"><strong>Autorização baseada em roles</strong>: Definição de regras de acesso por perfil (role) das pessoas usuárias.</li>
  <li align="justify"><strong>Proteção da rota GET /farms</strong>: Acesso restrito a pessoas autenticadas com role apropriada.</li>
  <li align="justify"><strong>Proteção da rota GET /crops</strong>: Acesso restrito a pessoas autenticadas com role apropriada.</li>
  <li align="justify"><strong>Proteção da rota GET /fertilizers</strong>: Acesso restrito a pessoas autenticadas com role apropriada.</li>
</ul>

<h2><strong>Demonstração do Projeto</strong></h2>
<p align="center">
  <img src="./images/agrix-tabelas-fase-b.png" alt="Imagem ilustrativa da Fase C do projeto" width="60%">
  <br>
  <a href="https://github.com/williandpg/agrix-fase-c" target="_blank"><strong>Acesse a demonstração</strong></a>
</p>

<h2><strong>Tecnologias Utilizadas</strong></h2>
<ul>
  <li align="justify">
    <a href="https://spring.io/projects/spring-boot" target="_blank"><strong>Spring Boot</strong></a>: Base da aplicação, configuração e exposição da API REST.
  </li>
  <li align="justify">
    <a href="https://spring.io/projects/spring-security" target="_blank"><strong>Spring Security</strong></a>: Framework utilizado para autenticação, autorização e proteção das rotas.
  </li>
  <li align="justify">
    <a href="https://jwt.io/" target="_blank"><strong>JWT (JSON Web Token)</strong></a>: Padrão utilizado para emissão e validação de tokens de autenticação.
  </li>
  <li align="justify">
    <a href="https://spring.io/projects/spring-data-jpa" target="_blank"><strong>Spring Data JPA</strong></a>: Persistência de dados, entidades, repositórios e consultas.
  </li>
</ul>

<h2><strong>Estrutura do Projeto</strong></h2>
<p align="justify">A estrutura do projeto é organizada da seguinte forma:</p>

<pre><code>
/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/betrybe/agrix/
│   │   │       ├── advice/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── security/
│   │   │       └── AgrixApplication.java
│   └── resources/
│       └── application.properties
│
├── test/
│   ├── java/
│   │   └── com/betrybe/agrix/
│   │       ├── service/
│   │       └── controller/
│   └── resources/
│       └── application-test.properties
│
├── images/
│   └── agrix-tabelas-fase-c.png
├── docker-compose.yml
├── Dockerfile
└── README.md
</code></pre>

<h2><strong>Contato</strong></h2>
<p>
  <strong>Willian Gonçalves</strong> | 
  <a href="https://www.linkedin.com/in/williandpg/" target="_blank"><strong>LinkedIn</strong></a> | 
  <a href="https://github.com/williandpg" target="_blank"><strong>Github</strong></a> | 
  <a href="https://williandpg.github.io/" target="_blank"><strong>Portfólio</strong></a> | 
  <a href="mailto:goncalves.wdp@outlook.com" target="_blank"><strong>Email</strong></a>
</p>

<h2><strong>Créditos</strong></h2>
<p align="justify">
  Este projeto foi desenvolvido como parte do Projeto Final do Módulo de Java oferecido pela Trybe.
</p>

<details>
  <summary><strong>English Version</strong></summary>

  <h1><strong>Agrix – Phase C</strong></h1>

  <h2><strong>Description</strong></h2>
  <p align="justify">
    Phase C is the security-focused stage of the Agrix project.  
    After building and expanding the core features in Phases A and B, the goal now is to protect the API using authentication 
    and authorization rules with <strong>Spring Security</strong> and <strong>JWT</strong>.
  </p>

  <h2><strong>Features</strong></h2>
  <ul>
    <li align="justify"><strong>Code migration</strong> from Phase B into the Phase C project.</li>
    <li align="justify"><strong>POST /persons</strong>: Endpoint to create new people in the system.</li>
    <li align="justify"><strong>Authentication with JWT</strong>: Login route that returns a JWT token for authenticated access.</li>
    <li align="justify"><strong>Role based authorization</strong>: Different routes are protected according to user roles.</li>
    <li align="justify"><strong>Protected GET /farms</strong>: Access restricted to authenticated users with the correct role.</li>
    <li align="justify"><strong>Protected GET /crops</strong>: Access restricted to authenticated users with the correct role.</li>
    <li align="justify"><strong>Protected GET /fertilizers</strong>: Access restricted to authenticated users with the correct role.</li>
  </ul>

  <h2><strong>Project Demonstration</strong></h2>
  <p align="center">
    <img src="images/agrix-tabelas-fase-b.png" alt="Project image of Phase C" width="60%">
    <br>
    <a href="https://github.com/williandpg/agrix-fase-c" target="_blank"><strong>Access the demonstration</strong></a>
  </p>

  <h2><strong>Technologies Used</strong></h2>
  <ul>
    <li align="justify"><a href="https://spring.io/projects/spring-boot" target="_blank"><strong>Spring Boot</strong></a>: Framework for building Java applications.</li>
    <li align="justify"><a href="https://spring.io/projects/spring-security" target="_blank"><strong>Spring Security</strong></a>: Framework for securing Java applications.</li>
    <li align="justify"><a href="https://jwt.io/" target="_blank"><strong>JWT</strong></a>: JSON Web Tokens for secure authentication.</li>
    <li align="justify"><a href="https://spring.io/projects/spring-data-jpa" target="_blank"><strong>Spring Data JPA</strong></a>: Framework for data access and persistence.</li>
  </ul>

  <h2><strong>Project Structure</strong></h2>
  <p align="justify">The project structure is organized as follows:</p>

  <pre><code>
    /
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/betrybe/agrix/
    │   │   │       ├── advice/
    │   │   │       ├── controller/
    │   │   │       ├── service/
    │   │   │       ├── entity/
    │   │   │       ├── repository/
    │   │   │       ├── security/
    │   │   │       └── AgrixApplication.java
    │   └── resources/
    │       └── application.properties
    │
    ├── test/
    │   ├── java/
    │   │   └── com/betrybe/agrix/
    │   │       ├── service/
    │   │       └── controller/
    │   └── resources/
    │       └── application-test.properties
    │
    ├── images/
    │   └── agrix-tabelas-fase-c.png
    ├── docker-compose.yml
    ├── Dockerfile
    └── README.md
  </code></pre>

  <h2><strong>Contact</strong></h2>
  <p>
    <strong>Willian Gonçalves</strong> |
    <a href="https://www.linkedin.com/in/williandpg/" target="_blank"><strong>LinkedIn</strong></a> |
    <a href="https://github.com/williandpg" target="_blank"><strong>Github</strong></a> |
    <a href="https://williandpg.github.io/" target="_blank"><strong>Portfolio</strong></a> |
    <a href="mailto:goncalves.wdp@outlook.com" target="_blank"><strong>Email</strong></a>
  </p>

  <h2><strong>Credits</strong></h2>
  <p align="justify">
    This project was developed as part of the Final Project of the Java Module at Trybe.
  </p>

</details>
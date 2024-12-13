Documentação do Projeto: Microserviço de Gestão de Usuários (com Maven)
Este documento fornece as instruções detalhadas sobre como rodar e usar o microserviço de gestão de usuários desenvolvido com Spring Boot, Java, Supabase, Swagger e Maven. O microserviço permite realizar operações CRUD (Criar, Ler, Atualizar e Excluir) de usuários com autenticação segura via JWT.

Requisitos
Antes de começar, você precisará dos seguintes pré-requisitos:

Java 11 ou superior instalado.
Maven para gerenciamento de dependências.
Conta no Supabase para configurar o banco de dados PostgreSQL.
IDE (como IntelliJ IDEA ou Eclipse) ou um editor de texto para editar o código.
Passos para Rodar o Projeto
1. Clonando o Repositório
Clone o repositório do projeto para sua máquina local:

bash
Copiar código
git clone https://github.com/usuario/microservico-gestao-usuarios.git
cd microservico-gestao-usuarios
2. Configurando a Conexão com o Supabase
O microserviço utiliza o Supabase como banco de dados PostgreSQL. Siga os seguintes passos para configurar a conexão:

Crie uma conta no Supabase (se ainda não tiver) e crie um novo projeto.

Crie uma tabela para armazenar os usuários. Exemplo de criação de tabela SQL:

sql
Copiar código
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);
Obtenha as credenciais de conexão:

URL do banco de dados (Host e porta)
Usuário e Senha
Abra o arquivo src/main/resources/application.properties e configure as variáveis de ambiente para a conexão com o Supabase:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
spring.datasource.username=<usuario>
spring.datasource.password=<senha>
Substitua <host>, <port>, <database>, <usuario> e <senha> pelas informações fornecidas pelo Supabase.

3. Configuração do Swagger
A documentação interativa da API é gerada automaticamente através do Swagger. Você pode acessar a interface do Swagger para testar as rotas da API no endpoint:

Swagger UI: http://localhost:8080/swagger-ui.html
4. Executando o Microserviço com Maven
Para rodar o microserviço localmente, siga os passos abaixo:

Compile o projeto:

Com o Maven, execute o seguinte comando para compilar o projeto e instalar as dependências:

bash
Copiar código
./mvnw clean install
Execute o projeto:

Para iniciar o microserviço com o Maven, execute:

bash
Copiar código
./mvnw spring-boot:run
O microserviço será iniciado na porta 8080 por padrão.

5. Testando as Rotas da API
Com o microserviço rodando, você pode testar as rotas RESTful expostas pela API. As rotas disponíveis são:

GET /api/usuarios: Retorna a lista de todos os usuários.
POST /api/usuarios: Cria um novo usuário. É necessário enviar um JSON com os dados do usuário (nome, email, senha).
GET /api/usuarios/{id}: Retorna um usuário específico pelo ID.
PUT /api/usuarios/{id}: Atualiza os dados de um usuário específico. Envia os dados no corpo da requisição.
DELETE /api/usuarios/{id}: Exclui um usuário específico pelo ID.
Exemplo de Requisição
POST /api/usuarios:

Corpo da requisição (JSON):
json
Copiar código
{
  "nome": "João Silva",
  "email": "joao@exemplo.com",
  "senha": "senha123"
}
Resposta:

json
Copiar código
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@exemplo.com"
}
6. Acessando a Documentação do Swagger
A documentação da API pode ser acessada em:

http://localhost:8080/swagger-ui.html

Através do Swagger, você pode visualizar e testar todas as rotas expostas pela API de forma interativa.

7. Autenticação com JWT
O microserviço implementa autenticação utilizando Spring Security e JWT (JSON Web Token) para proteger as rotas sensíveis.

Login e Geração de Token
Para obter um token JWT, você pode fazer um login utilizando a rota POST /api/login, enviando o email e senha do usuário. O servidor retornará um token JWT que deve ser utilizado para autenticação em outras rotas protegidas.

Exemplo de requisição de login:

json
Copiar código
{
  "email": "joao@exemplo.com",
  "senha": "senha123"
}
Resposta:

json
Copiar código
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Usando o Token nas Requisições
Para acessar rotas protegidas, você deve incluir o token JWT no cabeçalho da requisição:

http
Copiar código
Authorization: Bearer <token>
8. Visualizando os Testes Unitários
Os testes unitários são escritos utilizando o JUnit e Mockito. Para rodar os testes com Maven:

Rodar testes:

Execute o comando a seguir para rodar todos os testes unitários:

bash
Copiar código
./mvnw test
Verificar a cobertura de testes:

Após a execução dos testes, o relatório de cobertura estará disponível, mostrando a porcentagem de cobertura e os detalhes dos testes.

Considerações Finais
Este microserviço de gestão de usuários é uma aplicação simples, mas robusta, com autenticação JWT e integração com o Supabase para gerenciamento de dados. Ele está preparado para ser escalável, seguro e fácil de manter, seguindo boas práticas de desenvolvimento e design.

Com a documentação do Swagger, é possível testar facilmente as rotas e verificar a integridade da API. A autenticação JWT garante que as rotas protegidas estejam acessíveis apenas a usuários autorizados.

Se você tiver qualquer dúvida ou problema, sinta-se à vontade para abrir uma issue no repositório ou entrar em contato!

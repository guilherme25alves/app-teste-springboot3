
# Anotações referentes a estudos e observações importantes

#### Projeto criado junto ao canal do *Matheus Leandro Ferreira*.

[Vídeo do Youtube usado como referência](https://www.youtube.com/watch?v=SqU9v_V32RA)


#### Execução do projeto na linha de comando

`mvn spring-boot:run`

### Vamos utilizar o Postgres como banco de dados para o curso. Para usar via docker, comando:

    `docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=meubanco -p 5432:5432 -d postgres`

### Postgres:

- Logar no Postgres via WSL terminal:

`sudo -u postgres psql`

- Criar banco: 

`CREATE DATABASE nome-banco;`

- Listar Bancos: 

`\l`

- Acessar o banco diretamente:

`sudo -u postgres psql` ... restante do comando, as vezes, somente o comando de baixo dá erro
`psql -U postgres -d nome_do_banco`


- Criar usuário para o banco:

`CREATE USER nome_usuario WITH PASSWORD 'senha_usuario'`

- Concedendo permissões para usuário conectar ao banco de dados:

`\c nome_do_banco`
`GRANT CONNECT ON DATABASE nome_do_banco TO nome_do_usuario;`

- Conceder permissões para criar objetos (como tabelas) no banco de dados:

`GRANT CREATE ON DATABASE nome_do_banco TO nome_do_usuario;`

- Conceder permissões de leitura e escrita (seleção e atualização) nas tabelas do banco:

`GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO nome_do_usuario;`

- Para evitar erros de permissão, podemos conceder todas as permissões para o usuário: 

`GRANT ALL PRIVILEGES ON SCHEMA public TO nome_usuario;`

- Testar acesso do novo usuário:

`psql -U nome_do_usuario -d nome_do_banco -W`

- Sair do PG no WSL:

`\q`

### Por limitações da extensão Thunder Client no WSL, estamos utilizando a extensão REST Client para testar nossos endpoints, para conhecer mais a respeito:

[Artigo Dev.to: VSCode - REST Client](https://dev.to/leandroats/vscode-rest-client-2cei)


### OBS: 

Usar projeto como base para criar API com autenticação JWT e cadastro de usuário.
Estrutura para PostgreSQL que pode ser facilmente substituído alterando a lib no POM 
e trocando as configurações no arquivo application.properties.
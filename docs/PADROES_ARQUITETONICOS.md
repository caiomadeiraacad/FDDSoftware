# Padrões Arquitetônicos
Web é obrigatoriamente client-server por padrão.
Mas vamos se aprofundar em na arquitetura em camadas.

## Arquitetura em camadas
As camadas mais baixas são mais "primitivas" fornecendo serviços mais básicos, até a camada mais
superior de interação com usuário. Isso depende do autor. O foco é dividir o sistema em várias camadas
cada camada tem um papel específico. Uma cada só enxerga uma camada imediatamente abaixo. Ela não enxerga a
superior.

## Onde usar camadas?
Diversos usuários e sistemas distribuídos.
Grande volumes de dados

Um exemplo clássico são vendas.

Sistema em camadas = Monolito.
Um monolito é autocontido. Ele resolve um problema 
específico para uma empresa. O modelo em camadas aparece 
no modelo OSI de redes. 

A camda superior depende da inferior e assim por diante.
Cada camada vai prover nivel de dados e serviços com um nivel de abstração diferente.

Cada camada deve ter o principio da responsábilidade única. (Single Responsability Principle - S do solid).
O modelo mais clássico é a arquitetura em 3 camadas.

| APRESENTAÇÃO | <--> | NEGÓCIO | <--> | ACESSO A DADOS |
É uma generalização. Se eu tivesse que implementar MVC, implementaria na camada de apresentação e não no sistema.

É hierárquico. É sempre de cima pra baixo. São dois fluxos. O fluxo de controle sempre é da
superior pra inferior. Essa é a ideia geral.

### Como modelamos uma arquitetura em camadas?
1 - Primeira preocupação são dados. A modelagem do banco de dados.
2 - Depois disso, me preocupo com a camada de acesso a dados. Ela é
construída a partir do projeto do banco de dados.
3 - Classes que tratam das regras de negócio são acrescentadas na camada de negócio.
4- por fim cria-se a camada de apresentação.

O modelo de 3 camadas tem a implementação de CRUD (Create, Read, Update, Delete).
Criar uma informação, Consultar uma informação, Atualizar uma informação e Deletar uma informação.
Apesar de empresas possuirem variações nas pequenas lógicas de negócios.

### BACKEND SPRING BOOT - ARQUITETURA DE SOFTWARE WEB
## Introdução

O servidor web usando HTTP so se lembra da última requisição. É uma limitação
de sistema web http. Ele é stateless, ele nao lembra do passado todo. Apenas
da última requisição.

Session (sessão): Toda vez que um cliente abre uma requisição pra um servidor
ele cria uma sessão. Lá ele vai saber seu IP, seu servidor. A sessão é uma área
(provavelmente temporária) do cliente. Ela fica em quanto você usa o servidor.
Se você fechar o navegador, o servidor percebe que a conexão foi encerrada.

O ruim do HTTP é stateless. Isso é uma característica do HTTP.

Uma alternativa é usar o cookie. O cookie é um pequeno arquivo que o navegador 
gravar no teu PC ou celular. Do lado do browser (cliente) ele pode gravar a informação.
Cookie facilita a passagem de informação. Cookie depende do aceite do usuário.

E a última opção é gravar um arquivo do lado do servidor. O que chamamos de
back-end. 

Ainda olhando o exemplo da última aula.

Usando GET: Quando chegar no servidor, a URL carrega as informações que vieram 
da página original.
Usando POST: é um outro verbo de se comunicar com o servidor. Não vem um
paramêtro aberto. Os parâmetros da requisição não vem aberto.

## HTTP

HTTP é um mecanismo de comunicação. Ele foi montado para Hypertext (paginas HTML).
Ele é um protocolo textual. Usa ida e volta/baseado em respostas bilaterais (client/server).
Ele é stateless.

URL: http://....com
Se é https:// voce deve ter um certificado. E esse certificado deve estar no servidor.
URL(Uniform Resource Locator): foi pensada para identificar arquivos emum servidor web.
Pois o HTTP foi criado pra lidar com hipertextos. 8080 é a porta padrão de HTTP.

__O que tem no HTTP__: 
Não é so o que vemos na URL. A URL é o que ta aberto.
Uma requisição tem um header (cabeçalho) e um body (corpo).
Tudo que voce nao quiser que passe aberto, voce coloca no corpo da requisição.

__Uma resposta no HTTP__:
O status é o código de feedback da resposta.
E as outras características da requisição.


GET: O cliente solicita um recurso para o servidor.  
POST: O cliente fornece a entrada para um comando do lado do servidor e devolve o resultado.
PUT: O cliente envia o recurso ao servidor.
DELETE: O cliente exclui um recurso do servidor  
TRACE: O Cliente rastreia a comunicação com o servidor.

No lado do servidor, voce pode bloquear algumas formas de comunicação.

O risco do GET. Como tudo passa aberto, eu posso ativar algo diretamente
sem usar um formulário. O POST é um pouco melhor pois esconde os parâmetros.
O GET tem uma limitação de tamanho. 

Na URL do GET sempre vai aparecer o caractere de '?' e separação de
caractere por '&'. 

POST é uma forma de comunicação cliente e servidor, mas a diferença é que
ele não vai passar aberto. Vai no body da requisição. Ele é um pouco mais
seguro.  

GET e POST são os mais básicos.

## SPRING-BOOT (Back-end)

Do lado do servidor, chamamos de back-end. Programamos um 'cara' que espera
a solicitação do cliente. Uma das tecnologias pra implementar um servidor é
o Spring-Boot. Um framework já vem com coisas prontas, e nos os programadores
só precisamos programar poucas coisas.

O Spring-Boot usa JAVA e é usado pra criar aplicações standalone (independentes).
Tem servidores embutidos Tomcat, Jetty ou Undertow.
Fornece métricas de uso, health checks e configurações externas.

[Spring.io](spring.io)

Requisitos: JAVA 17, Maven, VSCode.

Podemos usar o __Postman__ para simular o frontend, simulando chamadas de
um clientweb normal. 

- Backend não tem interface. 
- Em vez disso, implementa uma série de endpoints.
- Cada endpoint é acionado em resposta a um tipo diferente de requisição (no caso requisições HTTP).
- As classes que implementam os endpoints normalmente são chamadas de controllers.
- Os controllers são a forma de comunicação das aplicações backend com o mundo externo.
- O Spring-Boot as respostas são geradas no formato JSON.  

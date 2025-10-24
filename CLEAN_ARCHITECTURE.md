Inferface com o usuario:
- mudam devido a regras de negocios;
   mudam por razoes de funcionalidade;
  
Regra de negocios

A ideia é que o software sempre muda. Quando pensamos nele, devemos
tomar decisoes que minimizem o impacto da mudança nele.

Isolar o que muda por razões diferentes:
"Um bom arquiteto maximiza o numero de decisoes nao tomadas."
Nao é necessario escolher o gerenciador de banco de dados no inicio do projeto
pq o objetivo geral eh persistir dados nao importa como.

Isso vale pra questoes de interface, protocolos, APIs, etc.

Identificar oportunidades do que pode ser plugado e desplugado.

No codigo-fonte:
- Estrutura desacoplada; monolítica (camadas, modulos, etc);

Nivel de implementacao:
- uso de dll, jar, etc
- evite que mudanças em algumas parte impliquem em recompilar outras;

Robert prope politicas em varios niveis. A nivel de negocio, a nivel de organizacao de codigos, etc.
As politicas sao quebradas em politicas menores:
- Uma regra de negocio;
- Um controller;
- Um relatorio;
Quanto mais longe esta dos plug-ins o nivel da politica é mais alto.
As politicas de alto nivel nao devem depender das de baixo nivel.
Usar inversao de dependencias (elementos da camada superior (ex: superclasses) nao dependem das camadas inferiores (ex: subsclasses).

DDD - Modelagem do domínio antes de tudo.
Organizacao de cima p baixo em relacao as dependencias.

Com base no diagrama fornecido e nos conceitos da Arquitetura Limpa (Clean Architecture), aqui está uma proposta de um novo diagrama de pacotes, com ajustes nas classes e responsabilidades para aderir mais estritamente a essa abordagem.

A principal premissa da Arquitetura Limpa é a Regra da Dependência: todo o código-fonte deve apontar para dentro, em direção às políticas de mais alto nível (o domínio).

Abaixo está a descrição da nova estrutura de pacotes e classes. A principal alteração é remover a classe ServicoDeEstoque e mover sua lógica de orquestração para dentro dos Use Cases (camada application), que passarão a depender diretamente das interfaces de repositório (camada domain).

Novo Diagrama de Pacotes (Descrição Textual)
1. Camada domain (Entidades)
Esta é a camada mais interna. Ela contém a lógica de negócio principal e não depende de nenhuma outra camada.

Pacote domain.models:

ProdutoModel: A entidade principal do produto.

ItemDeEstoqueModel: A entidade que representa o estoque de um produto. (Mantém a associação 1-para-1 com ProdutoModel).

Pacote domain.repositories (anteriormente domain.persistence):

<<interface>> IProdutoRepositorio: Interface (Port) que define o contrato para persistência de ProdutoModel.

<<interface>> IEstoqueRepositorio: Interface (Port) que define o contrato para persistência de ItemDeEstoqueModel.

Classes Removidas:

ServicoDeEstoque: Esta classe foi removida. Sua responsabilidade de coordenar repositórios para obter dados de estoque é considerada lógica de aplicação (caso de uso), não lógica de domínio pura.

2. Camada application (Use Cases)
Esta camada orquestra o fluxo de dados e chama o domain para executar a lógica de negócio. Ela depende apenas do domain.

Pacote application.usecases:

ProdutosDisponiveisUC:

Depende de IProdutoRepositorio e IEstoqueRepositorio (injetados via construtor).

Lógica interna: Usa os repositórios para buscar produtos e seus estoques, filtra os disponíveis e os mapeia para ProdutoDTO.

QuantidadeDisponivelProdutoUC:

Depende de IEstoqueRepositorio (injetado via construtor).

Lógica interna: Usa o repositório para buscar o ItemDeEstoqueModel pelo idProduto e retorna a quantidade.

Pacote application.dtos:

ProdutoDTO: Objeto de Transferência de Dados usado para enviar dados de produtos para fora da camada de aplicação (para a presentation).

3. Camada presentation (Interface Adapters)
Esta camada contém os controladores, gateways, etc. Ela depende da camada application.

Pacote presentation:

ACMEController:

Depende de ProdutosDisponiveisUC e QuantidadeDisponivelProdutoUC (injetados).

Expõe os métodos mensagem(), produtosDisponiveis() e quantidadeProdutoPorId(idProduto: long).

Os métodos do controlador chamam os Use Cases correspondentes e retornam os resultados (como String, List<ProdutoDTO> ou int).

4. Camada infrastructure (Frameworks & Drivers)
Esta é a camada mais externa, contendo detalhes de implementação (banco de dados, frameworks web, etc.). Ela depende das interfaces definidas no domain (para implementá-las).

Pacote infrastructure.persistence:

ProdutoRepoMemo:

Implementa IProdutoRepositorio (do domain).

Depende de ProdutoModel (para poder criá-lo/armazená-lo).

EstoqueRepoMemo:

Implementa IEstoqueRepositorio (do domain).

Depende de ItemDeEstoqueModel (para poder criá-lo/armazená-lo).

Resumo dos Ajustes e Justificativas
Remoção de ServicoDeEstoque: No diagrama original, a camada application (Use Cases) dependia de um domain.service. Na Arquitetura Limpa, os Use Cases (camada application) são os orquestradores naturais. A lógica de "buscar produtos e seus estoques" é uma orquestração de repositórios, uma responsabilidade que se encaixa perfeitamente no Use Case ProdutosDisponiveisUC. Manter um ServicoDeEstoque apenas para coordenar repositórios pode ser desnecessário se não houver lógica de domínio complexa envolvida.

Dependências Diretas dos Use Cases: Ao remover o serviço, as classes ...UC agora dependem diretamente das interfaces de repositório (IProdutoRepositorio, IEstoqueRepositorio) definidas no domain. Isso está perfeitamente alinhado com a Arquitetura Limpa, onde a camada de aplicação depende das abstrações definidas pela camada de domínio.

Renomeação de Pacote: domain.persistence foi renomeado para domain.repositories para maior clareza de que este pacote contém interfaces (contratos) e não implementações.

Essa nova estrutura reforça a Regra da Dependência:

presentation -> application

application -> domain

infrastructure -> domain (implementando as interfaces)

Em contraposição, Robert martin diz: politicas de alto nivel nao devem depender das de baixo nivel.
Regra de negocio nao deve depender das de tecnologia.

Ou seja a camada de estrutura jamais deve depender do dominio.

---

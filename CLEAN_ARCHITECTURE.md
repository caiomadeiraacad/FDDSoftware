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

Em contraposição, Robert martin diz: politicas de alto nivel nao devem depender das de baixo nivel.
Regra de negocio nao deve depender das de tecnologia.

Ou seja a camada de estrutura jamais deve depender do dominio.

---

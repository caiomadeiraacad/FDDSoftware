Spring-boot é um conjunto de soluções pré prontas que caracterizam um framework. 
Utiliza padrões de projetos que não foram vistos ainda.  

## Injeção de dependência
Problemas: Testes em que eu tenha que testar pares de classes dependentes. Ex: CarrinhoCompras + Logística.

### Abordagens:
Deixar as dependências explícitas: 
```
class CarrinhoCompras {
  private Logistica logistica;
  public CarrinhoCompras(Logistica l) {
    this.logistica = l;
  }
}
```
Esse é o primeiro momento em que começamos a pensar em inversão de controle e injeção de dependência.
O desenvolvedor é quem controla o código. Entretanto, em um framework, o controle da execução é, em 
grande parte, do framework. Ele executa diversas ações por baixo dos panos.

---
### Relembrando

A controller deve só exibir os endpoints. Controle de rotas. Se a Controller começar a encher de coisas,
ela violará alguns princípios básicos do SOLID como o de responsabilidade.
Deve ser um codigo bem enxuto, que deve ter como missão pegar parametros, ativar um método e retornar um resultado.  

### Injeção de dependências

A injeção de dependências no stringboot é indicado pela anotação/decorator @Component.
Notação @Autowired: Sei que está relacionado a vários construtores (?). Não sei bem o que é. 
A ideia é quebrar a aplicação em várias classes. Ela não deve ficar apenas em Controllers.

Toda classe candidata a injeção de dependência deve ser anotada com "@Component" ou uma de suas derivadas.
Deve se "registrar" um component junto ao método main.

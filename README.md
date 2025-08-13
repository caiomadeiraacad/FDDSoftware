### Padrões de projetos
Refs: GOF(Gang of four): Design Patterns: Elements of Reusable Object-Oriented Software.  
A ideia desses padrões de projetos é focado em conceitos mais do que em desenvolvimento.

Padrões de projeto são partes do software que podem ser reaproveitadas a nível de conhecimento.  
A ideia de aplicar isso é que eu evite do código ficar longo, rebuscado e embaralhado. Minimizamos o problema da codificação.

A ideia de usar padrões de projetos está relacionado com um alto nível de proeficiência em uma determinada linguagem.
Isso acelera o desenvolvimento do projeto, criam um vocabulário comum, melhora a flexibilidade e desempenho.
Não se deve forçar o uso de padrões de projetos.

#### Padrões de criação (GOF):
É uma categoria de padrão. Estão no foco no momento em que você está criando um objeto, pois o ```new object()``` talvez
não seja o suficiente para resolver um problema.
 __Factory Method__: Em caso de impossibilidade de sobrecarga de construtores (problema comum), é normal usar
 o factory method
 - O construtor deve ser privado.
 - Voce deve expor um ou mais método que vai gerar os objetos.

PS: Não coloquei a implementação.  
```
Date d = Date.hoje();
```
__Abstract Method__: Especializado em criar uma especialização pra classe.
Necessita de poliformismo pois criamos as especializações através do método construtor da AbstractFactory.
```
public class FinanciamentoFactory {
    public static Financiamento criaFinanciamento(ObjetoFinanciavel obj) {
        if (obj instanceof Veiculo) { return new FinVeiculo(obj); }
    }
}
```
__Builder__: Eventualmente quero criar objetos e customiza-los por demanda. Caímos no problema de criar
muitos construtores para cobrir todos os cenários possíveis de customização de acordo com os N atributos 
da classe. Por isso implementamos o builder:
- O construtor deve ser privado.
- Criamos uma inner class (classe interna) dentro da nossa classe pai. Essa classe interna é o builder.
- Essa classe interna tem métodos que permitem você customizar o objeto. Os métodos desse builder retorna uma
referência para ele mesmo (o builder).

```
public class Pizza
  public enum Molho(...)
  private mMolho molho;
  private boolea massaIntegral;

  public static class Builder() { private ... }
  public Builder molho(...) {...}
  public Builder massaIntegral() { this.massaIntegral = true; return this; }
  public PizzaB build() { return new PizzaB(this); }

```
```
PizzaB pizzaB = new PizzaB.Builder().molho(PizzaB.Molho.TOMATE).cobertura(PizzaB.Cobertura.DACASA).comBorda().massaBorda();
```
É o mesmo padrão de streams (usado com lambdas). A stream usa o padrão criacional Builder internamente.
O padrão builder é mais utilizado na construção de API's pois deve ser bem pensado.

__Singleton__: Cria apenas uma instância compartilhada de uma classe. A classe é carregada uma única vez.
- Mantem um construtor privado.
- Criar um atributo privado estatico pra manter a instancia.
- Cria um metodo estatico pra instancia global.

```
public class Spooler {
  private static Spooler instance = NULL;
  private Spooler() { // inicializacao do objeto }
  public static Spooler getInstance() {
    if (instance == NULL) {
        instance = new Spooler();
      return instance;
    }
  // outros metodos
}
```
```
spooler = Spooler.getInstance();
```
Melhoria do singleton 1. 
Em um sistema que temos varios objetos se comunicando, eventualmente dois metodos podem ter dois objetos chamando
o singleton ao mesmo tempo. Por isso usamos a keyword __synchronized__.
Isso é para programação concorrente.
```
public class Spooler {
  private static Spooler instance = NULL;
  private Spooler() { // inicializacao do objeto }
  public static __synchronized__ Spooler getInstance() {
    if (instance == NULL) {
        instance = new Spooler();
      return instance;
    }
  // outros metodos
}
```
Melhoria do singleton 2.
No java existe o método Clone(). Ele cria uma cópia do objeto.
Você pode usar implementar o método clone() sobrescrevendo-o pra não permitir uma NOVA instância.

O problema do singleton é que dificulta o teste unitário (pois teste unitário é focado em objetos e não classes ja que o singleton
é mais orientado a classe do que objeto em si) e esconde dependências de classe.

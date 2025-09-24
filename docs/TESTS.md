# Testes de software

Implementação -> Software Implementado  -> Teste -> Software testado ou Defeitos encontrados

Teste é uma das técnicas de avaliação da correção de software.
Dijkstra diz: "Os testes podem mostrar apenas a presença de erros, não a sua ausência." 

Curiosidade: Ariane 5 explodiu por erro em codigo. Erro na conversão de um valor em ponto flutuante para
um inteiro de 16 bits recebeu como entrada um valor que estava fora da faixa permitida.

O que faltou? Teste de software (Regressão).  

### Niveis de testes
- Teste de unidade: Módulos do sistema. Tem que ser feito pelo desenvolvedor.
- Teste de integração: Se partes funcionam sozinhas, elas funcionam juntas? O desenvolvedor se envolve também.
- Teste de sistema: Sistema completo. Todo o sistema funciona conforme o esperado? QA geralmente testa.

### Teste de unidade é o teste mais básico de software.
É executado em nível de módulo do programa.
Cada módulo (função, sub-rotina, classe) é testado como uma unidade independente.
Metas:
- Verificar a execução de cada módulo.
- Percorrer os caminhos lógicos.
- Verificar conjuntos de dados (válidos e inválidos).

### TDD (Test Driven Development)
Técnica de métodos ágeis que privilegia a definição dos testes antes da codificação do software.
Você cria os testes antes do software, apenas com a regra de negócio.

O teste unitário orientado a objetos é baseado na construção de __classes driver__.
Para cada classe alvo que se deseja testar deve-se construir uma classe __driver__ de teste
que experimenta a classe alvo procurando identificar defeitos.

A execução do teste unitário implica na execução dos métodos de teste que compôem as __classes driver__.

#### Desvantagens
- Necessidade de construcao do cenario em cada metodo.
- Necessidade de construir um programa para execução dos casos de teste.
- Dificuldade em se trabalhar com grandes conjuntos de dados de teste.
- Dificuldade pra coletar os resultados.
- Dificuldade de automatizar as execução de testes.

### Framework XUnit
Facilita a criação e execução de testes unitários.
Gerencia os testes. Execução, coleta de resultados e mais é com o framework.

Análogos: JUnit (JAVA), cppUnit (C++), csUnit (C#).

```
public class ContaCorrentTest {

  @Test
  public void deposita5000retira1000() {
    ...
    ...
    assertEquals(4000.0, cc.getSaldo()); // Asserções
  }
}
```
AssertEqual não é um condincional (um if-else). É uma ASSERÇÃO. 
O programador utiliza-o para validar algo. O resultado do assert 
não é mostrado na tela.

### Outras anotações.
@Test: indica que o método é de teste.
@BeforeEach: indica que o método deve ser executado antes do teste. 
Em caso de dependencias comuns entre os testes.
@AfterEach: mesma proposta do setup, mas executa depois de cada teste.
...

### Asserções
assertEquals: sobre uma comparação de igualdade
assertNull: sobre uma referência nula.
assertSame: se duas referencias são iguais ou diferentes (objeto)
fail(msg): Força uma parada.

### Processo de fazer um teste
1. Crie uma interface (esqueleto) da classe alvo.
2. Definir o conjunto de casos de teste.
3. Implementar a classe driver.
4. Completar a codificação da classe alvo.
5. Executar os testes.
6. Corrigir os bugs, se houver.
7. Complementar os testes.

O JUnit tem uma função de teste de cobertura que analisa se toda a sua aplicação 
está tendo suas funcionalidade "cobertas" pelos testes implementados.

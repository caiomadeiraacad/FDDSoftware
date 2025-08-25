### SOLID
Robert C. Martin criou os conceitos de SOLID através de um artigo.
São 5 principios que satisfazem os gargalos metodologicos deixados pelos padrões de projetos. 
SOLID é um complemento e é uma forma de verificar se o objeto de orientação a objeto está adequado.

- SRP - Single Responsability Principle: Quando você projetar um módulo/classe deve ser responsável "tarefa". Ela constribui para o
sistema com apenas uma responsabilidade. "Essa classe prove serviço pra um ator?". Normalmente quando a classe não condiz ao principio
uebramos ela em várias partes.
- OCP - Open-Closed Principle: "As entidades de software (classes, módulos, funções, etc.) devem ser abertas para extensão, mas fechadas para modificação."
Temos um módulo original e vai extendendo. 
- LSP - The Liskov Substitution Principle: "Afirma que objetos de uma superclasse devem ser substituíveis por objetos de suas subclasses sem alterar a correção do programa."
Em outras palavras, se uma classe é usada em um determinado contexto, qualquer subclasse dessa classe deve poder ser usada no mesmo contexto sem causar erros ou comportamentos inesperados.
Está diretamente ligada ao polimorfismo.
- ISP - Interface Segregation Principle: Cada módulo deve depender apenas das operações que necessita. É do ponto de vista do cliente. "O Cliente tem acesso a só o que precisa?"
- DIP - Dependency Inversion Principle: Separa o que for mais estável fica nas classes normais. Nas partes instáveis, cria uma outra estrutura
pra fazer esse acesso. "Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações". Tem relação com a injeção de dependência.
A parte instável geralmente depende de uma interface. No exemplo de aula, cada vez que eu tivesse um tipo de  SelecaoDeRota.defineRota(), eu implemento em várias
especializações baseadas na interface.

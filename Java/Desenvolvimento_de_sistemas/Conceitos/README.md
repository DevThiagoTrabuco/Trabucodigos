# Conceitos
- Conceitos
  - [Herança](#herança)
  - [Composição](#composição)
  - [Injeção de dependências](#injeção-de-dependências)
## Herança
A `Herança` permite que classes compartilhem atributos, métodos e outros membros dessa classe, mantendo uma relação ***"is a"***.
Dessa forma, as classes são divididas em duas: 

- A `Superclasse`, ou classe base, que concede as características para outras classes;
- E a `Subclasse`, ou classe derivada, que herda as características da superclasse.

A herança facilita a programação, reaproveitando códigos e comportamentos, além de especializar operações ou atributos, evitando assim a repetição de trechos de código que realizam a mesma função.  

- Vantagens:
  - Facilita a manutenção do sistema;
  - Menor quantidade de linhas;
  - Menos alterações no código.

- Desvantagens:
  - Todos os métodos da superclasse é visível para as subclasses, sem restrições;
  - Quebra o princípio do _Encapsulamento_;
  - Acoplamento rígido.
## Composição
`Composição`(ou _Acoplamento_) é um mecanismo de reutilização de classes para compor outra classes. Possui relação ***"has a"***.  
Dessa forma, um objeto é _composto_ por outros objetos, e portanto, também pode usufruir dos atributos e métodos destes objetos.

- Vantagens:
  - Menor acoplamento;
  - Flexibilidade e reutilização;
  - Evita herança múltipla.

- Desvantagens:
  -  Maior quantidade de linhas;
  -  Mais complexidade;
  -  Dificuldade de visualizar hierarquia.
## Injeção de dependências
A `Injeção de dependências` permite que o objeto de uma classe receba suas dependências externamente, ao invés de as instanciar no próprio código. Cria uma relação ***"depends of"***.  
Os meios de definir as dependências são através de um _construtor_, um _setter_, ou _interface_.

- Vantagens:
  - Modularização do código;
  - Manutenibilidade;
  - Permite substituições de dependências mais facilmente.

- Desvantagens:
  -  Maior complexidade;
  -  Exige gerenciamento de dependências estruturada.
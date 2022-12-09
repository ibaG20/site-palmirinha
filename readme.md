# Desafio MVC

- Criar um botão com a opção de popular o banco de dados, ou criar um código para dar o insert das informações.

------------

###  CRUD de:

#### Ingredientes:
##### PRONTO
  - basicamente inserir os ingredientes necessários
  - detalhes:
     - listagem com pesquisa por nome
     - página de cadastro e atualização

#### Unidade de medidas:
##### PRONTO
  - inserir as unidades de medidas necessárias
  - detalhes:
     - listagem com pesquisa por nome
     - página de cadastro e atualização
     
#### Receitas:
  - tempo de preparo -> em minutos
  - ingredientes -> String (text area)
  - modo de preparo -> String (text area)
  - talvez a opção de inserir uma imagem
  - detalhes:
     - listagem com pesquisa por nome
     - página de cadastro e atualização
     - busca de receita por ingredientes (fazer a caixa de busca no canto lá em cima) )
     
#### Item
  - vai ter chave composta, e os IDS vao ser de receita e de ingrediente
  - atributos:
     - .ids
     - .qtd
     - .unidade de medida
  - obs: não vai ser uma relação ManyToMany
  - lembrar: fazer o redirect pra poder escolher mais coisas
  
  - cascade no ingrediente e na unidade
------------

###  A aplicação vai ter dois tipos de acesso:
####   Admin
  - tem total acesso a aplicação e ao crud
  - acesso:
     - usuario: admin@gft.com
     - senha: Gft@1234
     
####  Usuário
  - cadastro feito no primeiro acesso
  - tem acesso apenas as view de lista de receitas cadastradas e a visualização da receita escolhida
  - acesso:
    - usuario: usuario@gft.com
    - senha: Gft@1234

------------
------------

###  Passo a passo:

 - X arrumar listagem de receitas
 - Z arrumar pra n repetir ingrediente e unidade de medida
 - X popular banco
 - X incluir bootswatch
 - X colocar imagem de fundo
 - X arrumar os logins que tem
 - X talvez fazer um botão
  
 

   - 


 
 - X criar a documentação
 - X o o popular banco
 
 - X crud de unidade de medida
 - X crud de ingredientesa

 - X criar relacionamento entre receita e ingrediente
 - X terminar o crud de receita (falta incluir "item")
 
 

   - 


 - X criar as paginas html de un. de medida
 - X criar as paginas html de ingredientes
 - Z terminar as paginas html de receitas
 - X criar a pagina de layout
 
 -
  
  
 - X criar uma classe de relacionamento entre receita e ingrediente, nessa classe vai ter qtd e unidade de medida (o id vai ser o atributo)
     - não vai ser uma relação many to many
     - vai ter como chave o id da receita e id do ingrediente (chave composta)


 -
  
  
 - X Implementar a parte de login
     - Xarrumar a página de login
     - X se um usuario entrar na parte que só um admin pode mexer, mostrar uma tela de "apenas administradores podem cadastrar receitas/ingredientes/unidades de medida"
     - X incluir botão de sair
     - X fazer aquela confirmaçãozinha de "deseja mesmo sair?"
      
      
### Detalhes para lembrar

 - colocar quatidade max de caracteres no modo de preparo

 - crud de faq (excede)
 - 
 - verificar o creat drop no application
 - tomar cuidado com o hascode equals na parte de criar a relação
 - arrumar a caixa de login, com o espaço arrumadinh
 
 - X text area: forms-> form control / ou / forms-> input groupo
 - X arrumar a caixa de login, colocar detalhe que ta no forms->input group
 - X para  caixa de ingredientes: content->tables
 - X pro cadastro de ingrediente pode ser usado o forms->layout
 - X caixinhas de alertas: components->alert)
 
 - o desenho do site vai ser um abacate, e quando clica no nome vai pra imagem de boas vindas com uma foto de abacate no fundo escrito algo bonitinho
# site-palmirinha

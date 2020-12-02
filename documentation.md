# Como Fazer configuração para uso próprio

Atualmente, o Covid Quiz ainda está configurado para uso local, então
para sua utilização ainda é necessário realizar uma configuração no
código fonte e criação do banco de dados de modo local, conforme
demonstra o passo a passo a seguir:

**Crie uma conexão com o banco de dados** ou utilize uma conexão já
criada, será importante lembrar-se dos seguintes detalhes da conexão:
porta, nome do Usuário e senha, estes detalhes podem ser alterados
conforme você decidir e necessitar (seguindo os usuários e senhas
previamentes criados no banco Oracle, porém tais informações também
deverão ser atualizadas no projeto JAVA conforme será mostrado mais a
frente

![](myMediaFolder\media\image11.png){width="6.5in"
height="3.4583333333333335in"}

Após preencher, já poderá testar e então **conectar-se na rede**. Após
conectado você deverá **abrir o arquivo SQL** localizado na pasta DB do
projeto e então selecionar todos os comandos e executar pressionando
**ctrl + ENTER**

![](myMediaFolder\media\image6.png){width="5.953125546806649in"
height="3.1979166666666665in"}![](myMediaFolder\media\image19.png){width="6.5in"
height="3.4722222222222223in"}

![](myMediaFolder\media\image4.png){width="6.5in"
height="3.486111111111111in"}

\*A execução desses comandos servirá para criar as tabelas em sua
conexão local, já criará perguntas iniciais e também um usuário
administrador que poderá ser usado, o usuário possui o **login: sysadmin
e senha: root123**

Após feito isso, é hora de abrirmos nosso projeto JAVA e configurá-lo
também. Abriremos então a **IDE IntelliJ** e selecionaremos a opção
**open**, e então selecionaremos a pasta CovidQuiz que está no mesmo
nível da pasta
DB![](myMediaFolder\media\image16.png){width="5.807292213473316in"
height="3.8238484251968505in"}

![](myMediaFolder\media\image5.png){width="6.5in"
height="5.041666666666667in"}

Com o projeto aberto abriremos a classe **ConnectionFactory** (destacada
em vermelho) que se encontra no Pacote **util** e vamos **alterar os
trechos destacados em amarelo** para condizer com a conexão previamente
criada no banco de dados

![](myMediaFolder\media\image13.png){width="6.921875546806649in"
height="2.850183727034121in"}

**1:** Porta conexão banco de dados **2:** usuário conexão banco de
dados **3:** senha usuário conexão

Após estes ajustes podemos então executar nossa aplicação clicando com o
botão direito em MenuInicialView e então run

![](myMediaFolder\media\image10.png){width="6.5in" height="3.625in"}

# Seção 1 - Descrição do projeto

## 1.1 Projeto

Covid Quiz

## 1.2 Descrição

O projeto Covid Quiz é um jogo de perguntas temáticas sobre a pandemia
de Covid sendo inspirado pelo jogo Show do milhão para fazer o estilo
das perguntas e o sistema de ajudas, trazendo informações sejam como
curiosidades, informações sobre a doença e também (como principal foco)
a quebra de Fake News sobre a doença de maneira discreta, trazendo
questões sobre tais temas para o usuário e mostrando qual seria uma
notícia ou informação real.

## 1.3 Autores

Felipe Klahn Muniz Hedlund Martins e Samuel de Matos Pereira

**Sumário**

[[Como Fazer configuração para uso
próprio]{.ul}](#como-fazer-configuração-para-uso-próprio)

[[Seção 1 - Descrição do projeto]{.ul}](#seção-1---descrição-do-projeto)

> [[1.1 Projeto]{.ul}](#projeto)
>
> [[1.2 Descrição]{.ul}](#descrição)
>
> [[1.3 Autores]{.ul}](#autores)

[[Seção 2 - Propósito]{.ul}](#section)

[[Seção 3 - Arquitetura do
Projeto]{.ul}](#seção-3---arquitetura-do-projeto)

[[Seção 4 - Design da Interface do
Usuário]{.ul}](#seção-4---design-da-interface-do-usuário)

# 

# 

# 

# 

# 

# 

# 

# 

# 

# 

# Seção 2 - Propósito

O principal propósito do Covid Quiz é trazer de forma simples e
divertida, informações sobre a doença e a pandemia como um todo.

# Seção 3 - Arquitetura do Projeto

O projeto foi construído seguindo o DAO Design Pattern que visa separar
as regras de negócio das regras de acesso ao banco, e o Padrão MVC
dividindo a arquitetura do projeto em 3 camadas Model, View e
Controller. Para realizar a conexão do banco foi usado o JDBC e para a
interface gráfica foi utilizado Swing

![](myMediaFolder\media\image17.png){width="2.40625in"
height="1.5052088801399826in"}

**Controller** - Recebe e controla as requisições do usuário feitas
através da view, onde seus métodos utilizarão um model que será editado
através do acesso ao banco pela camada DAO e retornará para a view o
resultado esperado novamente.

**View -** Interface gráfica para o usuário, onde tudo visualmente
ocorre, possui tratamentos básicos para organizar da melhor forma os
dados necessários para realizar as ações, suas ações sejam em botões ou
qualquer tipo de evento resultam na chamada de uma controller e
alterarão visualmente na camada View de acordo com o resultado.

**Model -** Classes bases do projeto, normalmente sendo modeladas para
utilização em conjunto com a modelagem do banco de dados

**DAO -** Pacote responsável por acessar e fazer as queries para o banco
e retornar para a controller.

**img -** Pacote de recursos de imagens para utilização na camada view.

**util -** Pacote de utilitários, onde há uma classe para a conexão
inicial com o banco de dados e uma exception personalizada

**Toda a arquitetura do projeto aberta:**

![](myMediaFolder\media\image18.png){width="2.9583333333333335in"
height="7.322916666666667in"}

# Seção 4 - Design da Interface do Usuário

Para o Design da interface, optamos por telas simples com cores básicas,
seguindo uma paleta monocromática, toda a interface se encontra no
pacote view, atualmente em nosso Design temos telas com 3 requisitos de
acesso: **Acesso público, acesso restrito ao usuário normal e acesso
restrito ao administrador**

**Acesso público:** telas iniciais do sistema, onde não é necessário
usuário para acessar, permitindo que um novo usuário se cadastre e
acesse ao sistema, tais telas são **MenuInicialView** e
**CadastroUsuarioView.**

**MenuInicialView - Primeira tela do sistema**

![](myMediaFolder\media\image8.png){width="3.9805325896762906in"
height="6.744792213473316in"}

**CadastroUsuarioView - Acessado ao clicar no botão Cadastre - se, na
tela MenuInicialView**

![](myMediaFolder\media\image15.png){width="4.864583333333333in"
height="8.208333333333334in"}

**Acesso restrito ao usuário normal:** telas do sistema onde já são
necessário um usuário comum logado, tais telas tem todas as
funcionalidades do jogo em si para o usuário, são elas
**MenuUsuarioView, JogoView, RankingView, CadastroPerguntaView**

**MenuUsuarioView - Acessado após o login de usuário na tela
MenuInicialView**

![](myMediaFolder\media\image1.png){width="5.34375in"
height="5.53125in"}

**JogoView - acessada após clicar no botão Novo Jogo no
MenuUsuárioView**

![](myMediaFolder\media\image12.png){width="6.494792213473316in"
height="4.694152449693788in"}

**RankingView- acessada após clicar no botão Ranking no
MenuUsuárioView**

![](myMediaFolder\media\image2.png){width="5.09375in" height="5.5in"}

**CadastroPerguntaView - acessada após clicar no botão Cadastrar
Pergunta no MenuUsuárioView**

![](myMediaFolder\media\image9.png){width="6.5in"
height="4.722222222222222in"}

**Acesso restrito ao administrador:** telas do sistema onde já são
necessários um administrador logado, não é possível cadastrar um
administrador sem ser através de outro administrador, por isso é criado
préviamente um administrador inicial no banco de dados, tais telas são:
**MenuAdminView, AutorizarPerguntasView, CadastroAdminView**

**MenuAdminView - Acessado após logar como administrador na tela
MenuInicialView**

![](myMediaFolder\media\image7.png){width="5.3125in" height="5.53125in"}

**CadastroAdminView - Acessada ao clicar no botão Cadastrar admin na
tela MenuAdminView**

![](myMediaFolder\media\image3.png){width="5.09375in"
height="6.208333333333333in"}

**AutorizarPerguntasView - Acessado ao clicar no botão autorizar
perguntas na tela MenuAdminView**

![](myMediaFolder\media\image14.png){width="6.5in"
height="4.652777777777778in"}

# Trabalho Prático de Banco de Dados

<h1><i>Sistema de Gerenciamento para Condomínios</i></h1>
</br>

<h2><strong>Requisitos</strong></h2>

* __REQ01: Uma pessoa é definida por seu primeiro nome, sobrenome, telefone, data de nascimento, idade e o CPF que identifica cada pessoa unicamente.__
* __REQ02: Nem toda entidade Pessoa possui uma entidade correspondente em Morador ou Funcionário.__
* __REQ03: Um(a) morador(a) é definido por seu primeiro nome, sobrenome, telefone, data de nascimento, idade, número do bloco, número do apartamento, data de entrada, data de saída, e-mail e o CPF que identifica cada morador(a) unicamente.__
* __REQ04: Um apartamento é definido por seu número.__
* __REQ05: Cada morador(a) pode morar apenas em um apartamento.__
* __REQ06: Cada apartamento possui nenhum ou vários moradores.__
* __REQ07: Uma conta é definida por id_cont, IPTU, energia, água e a taxa do condomínio.__
* __REQ08: Cada apartamento possui uma conta.__
* __REQ09: Cada conta está vinculada à apenas um apartamento.__
* __REQ10: Um bloco é definido por seu número.__
* __REQ11: Cada apartamento está vinculado à apenas um bloco.__
* __REQ12: Cada bloco possui vários apartamentos.__
* __REQ13: Através do atributo Status, deve ser possível verificar se um determinado apartamento está ou não disponível.__
* __REQ14: Um condomínio é definido por seu nome, id_cond, CEP, bairro, rua e o número da rua.__
* __REQ15: Cada bloco possui um condomínio.__
* __REQ16: Cada condomínio possui um ou vários blocos.__
* __REQ17: O endereço é definido por CEP, bairro, rua e o número da rua.__
* __REQ18: Um(a) funcionário(a) é definido por seu primeiro nome, sobrenome, telefone, data de nascimento, idade, cargo, salário, data de entrada, data de saída, CEP, bairro, rua, número da rua e o CPF que identifica cada funcionário(a) unicamente.__
* __REQ19: Nem toda entidade Funcionário possui uma entidade correspondente em Porteiro, Zelador ou Vigilante.__
* __REQ20: Cada zelador limpa nenhum ou vários blocos.__
* __REQ21: Cada bloco é limpo por nenhum ou vários zeladores.__
* __REQ22: Cada vigilante vigia um ou vários condomínios.__
* __REQ23: Cada condomínio possui nenhum ou vários vigilantes.__
* __REQ24: O banco de dados deve ser capaz de guardar informações sobre os moradores existentes em cada apartamento e os funcionários que trabalham no condomínio.__

</br></br>

<h2><strong>Modelo Entidade Relacionamento</strong></h2>

![Conceitual](https://user-images.githubusercontent.com/38192454/82700351-69811d80-9c44-11ea-9e2b-d654ca801ad6.png)

</br></br>

<h2><strong>Modelo Relacional</strong></h2>

![Logico](https://user-images.githubusercontent.com/38192454/82700371-71d95880-9c44-11ea-9fb7-48d3f15234ac.png)

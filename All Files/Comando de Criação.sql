CREATE SCHEMA universidade;

CREATE DOMAIN universidade.tipo_cpf AS VARCHAR(11);

CREATE TABLE universidade.pessoa(--OK
	cpf universidade.tipo_cpf,
	primeiro_nome	VARCHAR(45) NOT NULL,
	sobrenome VARCHAR(45) NOT NULL,
	data_nascimento DATE  NOT NULL,
	data_de_entrada DATE NOT NULL,
	data_de_saida DATE,
	telefone VARCHAR[],
	CONSTRAINT pk_cpf_pessoa PRIMARY KEY (cpf)
);

CREATE TABLE universidade.apartamento (--OK
	idApartamento INT,
	CONSTRAINT pk_idApartamento_apartamento PRIMARY KEY (idApartamento)
);

CREATE TABLE universidade.condominio (--OK
	idCondominio INT,
	nome varchar(50) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	bairro VARCHAR(60) NOT NULL,
	rua VARCHAR(255) NOT NULL,
	numero_da_rua INT NOT NULL,
	CONSTRAINT pk_idCondominio_condominio PRIMARY KEY (idCondominio)
);

CREATE TABLE universidade.morador (--OK
	cpf universidade.tipo_cpf,
	numero_do_bloco INT NOT NULL,
	numero_do_apartamento INT NOT NULL,
	email VARCHAR[],
	CONSTRAINT pk_cpf_morador PRIMARY KEY (cpf),
	CONSTRAINT fk_cpf_morador FOREIGN KEY (cpf) REFERENCES
	universidade.pessoa(cpf) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.funcionario (--OK
	cpf universidade.tipo_cpf,
    cargo VARCHAR(15) NOT NULL,
	salario REAL,
	cep VARCHAR(8) NOT NULL,
	bairro VARCHAR(60),
	rua VARCHAR(255) NOT NULL,
	numero_da_rua INT NOT NULL,
	CONSTRAINT pk_cpf_funcionario PRIMARY KEY (cpf),
  	CONSTRAINT ck_sal_negativo CHECK(salario>0),
	CONSTRAINT fk_cpf_funcionario FOREIGN KEY (cpf) REFERENCES
	universidade.pessoa(cpf) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.conta (--OK
	idConta INT,
	iptu REAL DEFAULT 0,
	agua REAL,
	energia REAL,
	taxa_do_condominio REAL DEFAULT 0,
	idApartamento INT,
	CONSTRAINT pk_idConta_conta PRIMARY KEY (idConta),
  	CONSTRAINT ck_ag_negativo CHECK(agua>0),
  	CONSTRAINT ck_en_negativo CHECK(energia>0),
	CONSTRAINT fk_idConta_conta FOREIGN KEY (idApartamento) REFERENCES
	universidade.apartamento(idApartamento) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.bloco (--OK
	idBloco INT,
	idCondominio INT,
	CONSTRAINT pk_idBloco_bloco PRIMARY KEY (idBloco),
	CONSTRAINT fk_idCondominio_bloco FOREIGN KEY (idCondominio) REFERENCES
	universidade.condominio(idCondominio) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.tem (--OK
	idTem INT,
    status BOOLEAN,
    idApartamento INT,
    idBloco INT,
	CONSTRAINT pk_idTem_tem PRIMARY KEY (idTem),
	CONSTRAINT fk_idApartamento_tem FOREIGN KEY (idApartamento) REFERENCES
	universidade.apartamento(idApartamento),
	CONSTRAINT fk_idBloco_tem FOREIGN KEY (idBloco) REFERENCES
	universidade.bloco(idBloco) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.zelador (--OK
	cpf universidade.tipo_cpf,
	CONSTRAINT pk_cpf_zelador PRIMARY KEY (cpf),
	CONSTRAINT fk_cpf_zelador FOREIGN KEY (cpf) REFERENCES
	universidade.funcionario(cpf) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.limpa (--OK
	cpf universidade.tipo_cpf,
	idBloco INT,
	CONSTRAINT pk_cpf_idBloco_limpa PRIMARY KEY (cpf, idBloco),
	CONSTRAINT fk_cpf_limpa FOREIGN KEY (cpf) REFERENCES 
	universidade.zelador(cpf)
);

CREATE TABLE universidade.porteiro (--OK
	cpf universidade.tipo_cpf,
	CONSTRAINT pk_cpf_porteiro PRIMARY KEY (cpf),
	CONSTRAINT fk_cpf_porteiro FOREIGN KEY (cpf) REFERENCES
	universidade.funcionario(cpf) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.vigilante (--OK
	cpf universidade.tipo_cpf,
	CONSTRAINT pk_cpf_vigilante PRIMARY KEY (cpf),
	CONSTRAINT fk_cpf_vigilante FOREIGN KEY (cpf) REFERENCES
	universidade.funcionario(cpf) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE universidade.vigia (--OK
	cpf universidade.tipo_cpf,
	idCondominio INT,
	CONSTRAINT pk_cpf_idCondominio_vigia PRIMARY KEY (cpf, idCondominio),
	CONSTRAINT fk_cpf_vigia FOREIGN KEY (cpf) REFERENCES
	universidade.vigilante(cpf)
);


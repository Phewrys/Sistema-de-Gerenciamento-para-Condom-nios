

-- 01)[FUNC. AGREGAÇÃO][GROUP BY] Listar a quantidade de funcionarios por cargo.
SELECT count(cpf), cargo 
FROM universidade.funcionario
GROUP BY cargo

-- 02)[FUNC. AGREGAÇÃO][INNER JOIN] Informe a soma, média, mínimo e máximo salário de funcionario.
SELECT sum(f.salario), avg(f.salario), min(f.salario), max(f.salario)
FROM universidade.pessoa AS p
INNER JOIN universidade.funcionario AS f
ON p.cpf = f.cpf

-- 03)[NATURAL JOIN] Listar nome, cargo e bairro dos funcionarios que são porteiros.
SELECT p.primeiro_nome, f.cargo, f.bairro
FROM universidade.funcionario AS f
NATURAL JOIN universidade.pessoa AS p
WHERE cargo = 'PORTEIRO'

-- 04)[INNER JOIN][LIKE] Listar nome e sobrenome de todos os moradores que tem o sobrenome iniciado com a letra S.
SELECT p.primeiro_nome, p.sobrenome
FROM universidade.pessoa AS p
INNER JOIN universidade.morador AS m
ON p.cpf = m.cpf
WHERE p.sobrenome LIKE 'S%'

-- 05)[JOIN.. USING] Relacione as tabelas pessoa e morador com o comando using no atributo cpf.
SELECT * 
FROM universidade.pessoa
JOIN universidade.morador
using (cpf)

-- 06)[RIGHT OUTER JOIN] Liste o nome e sobrenome de todas as pessoas que são funcinarios.
SELECT p.primeiro_nome, p.sobrenome
FROM universidade.pessoa AS p
RIGHT OUTER JOIN universidade.funcionario AS f
ON p.cpf = f.cpf

-- 07)[ORDER BY] Listar nome e sobrenome das pessoas que naceram depois de 01/01/1980. Ordenado de forma crescente.
SELECT p.primeiro_nome, p.sobrenome 
FROM universidade.pessoa AS p
WHERE p.data_nascimento > '01-01-1980'
ORDER BY p.primeiro_nome ASC

-- 08)[GROUP BY][HAVING] Liste os salários dos funcionarios que possuem salário maior que R$1.000.
SELECT f.salario
FROM universidade.funcionario AS f
GROUP BY f.salario
HAVING f.salario > 1000

-- 09)[BETWEEN] Listar nome e sobrenome das pessoas que naceram entre 01/01/1970 e 01/01/1980.
SELECT p.primeiro_nome, p.sobrenome 
FROM universidade.pessoa AS p
WHERE data_nascimento BETWEEN '01-01-1970' AND '01-01-1980'

-- 10)[STRINGS] Liste o CPF e o nome de todos os funcionários separados por " - ".
select f.cpf || '-' || p.primeiro_nome
from universidade.pessoa AS p
JOIN universidade.funcionario AS f
ON (p.cpf = f.cpf)

-- 11)[CONSULTAS ANINHADAS][INNER JOIN] Informe a quantidade de funcionarios que recebem salário menor que R$1.000.
SELECT count(p.cpf)
FROM universidade.pessoa AS p
INNER JOIN universidade.funcionario AS f
ON p.cpf = f.cpf
WHERE p.cpf IN 
(SELECT cpf 
 FROM universidade.funcionario AS f
 WHERE f.salario < 1000)

-- 12)[CONSULTAS ANINHADAS][INNER JOIN] Liste o nome de todos os moradores que moram no bloco 1.
SELECT p.primeiro_nome
FROM universidade.pessoa AS p
INNER JOIN universidade.morador AS m
ON p.cpf = m.cpf
WHERE p.cpf IN 
(SELECT cpf 
 FROM universidade.morador AS m
 WHERE m.numero_do_bloco = 1)

-- 13)[CONSULTAS ANINHADAS][INNER JOIN][NATURAL JOIN][STRINGS] Liste o nome de todos os funcionarios em que o primeiro nome contém exatamente 7 caracteres.
SELECT p.primeiro_nome
FROM universidade.pessoa AS p
INNER JOIN universidade.funcionario AS f
ON p.cpf = f.cpf
WHERE p.cpf IN 
(SELECT cpf 
 FROM universidade.pessoa AS p
 NATURAL JOIN universidade.funcionario AS f
 WHERE CHAR_LENGTH(p.primeiro_nome) = 7)

-- 14)[CONSULTAS ANINHADAS][RIGHT OUTER JOIN][NATURAL JOIN] Liste o nome e sobrenome de todos os moradores do bloco 4, apartamento 10.
SELECT p.primeiro_nome, p.sobrenome
FROM universidade.pessoa AS p
RIGHT OUTER JOIN universidade.morador AS m
ON p.cpf = m.cpf
WHERE p.cpf IN 
(SELECT cpf 
 FROM universidade.pessoa AS p
 NATURAL JOIN universidade.morador AS m
 WHERE m.numero_do_bloco = 4
 AND m.numero_do_apartamento = 10)

-- 15)[CONSULTAS ANINHADAS][LIKE] Liste o nome de todos os funcionarios que são zeladores.
SELECT p.primeiro_nome 
FROM universidade.pessoa AS p
WHERE p.cpf 
IN (SELECT cpf 
    FROM universidade.funcionario AS f
    WHERE f.cargo LIKE 'Z%')

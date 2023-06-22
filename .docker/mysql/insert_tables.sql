-- INSERTS PARA POPULAR O BANCO DE DADOS
USE sistema_pet;

-- Insert em secretária
INSERT INTO secretaria(CPF,nome,telefone) VALUES ('091.113.540-54','Angelina Jolie','51 2956-5217');
INSERT INTO secretaria(CPF,nome,telefone) VALUES ('303.803.320-00','Jeffiner Aniston','513777-5727');

-- Insert em Veterinario
INSERT INTO veterinario(nome,CRMV,telefone) VALUES ('Tom Holland','2110/1','5322491766');
INSERT INTO veterinario(nome,CRMV,telefone) VALUES ('Robert John Downey','2110/3','5532541193');
INSERT INTO veterinario(nome,CRMV,telefone) VALUES ('Joaquim Phoenix','2110/5','5420887421');

-- Insert em endereço
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('9486-009','Rua Araras',1865,'Chácara das pedras');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('9461-088','Rua Guarás do Sul',3455,'Moinhos de vento');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('3550-129','Rua Anita Garibaldi',2204,'Chácara das pedras');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('4784-025','Rua Lambardi',7501,'Praia de belas');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('3131-765','Rua Barão Wallaci',1995,'Praia de belas');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('9115-013','Rua Coronel Zatoni',2008,'Auxiliadora');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('0865-199','Rua Henrique Brás',5709,'Petrópolis');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('1300-289','Rua Brigadeiro Faria Lima',5421,'Menino Deus');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('5569-119','Rua Borges de Medeiros',1123,'Mont’Serrat');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('7689-550','Rua Aparício Borges',1990,'Praia de belas');
INSERT INTO endereco (CEP,rua,numero,bairro) VALUES ('90570140','Rua Marquês do Herval',210,'Moinhos de vento');

-- Insert em Clinica
INSERT INTO clinica(CNPJ,razao_social,telefone,endereco_ID) VALUES ('66.141.142/0001-87','Pet Care','5432815007', 11);

-- Insert em Procedimentos
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('castração de cachorro pequeno porte, até 5 quilos',100.0);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('castração de cachorro médio porte, até 10 quilos',150.0);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('castração de cachorro grande porte, acima de 20 quilos',200.0);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('castração de gato pequeno e médio porte, até 6 quilos',100.0);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('castração de gato grande porte, acima de 10 quilos',150.0);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('vacina contra raiva nacional', 20.00);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('vacina contra raiva importada', 50.00);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('consulta', 100.00);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('Raio-X', 150.00);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('exame urina', 25.00);
INSERT INTO procedimento (nome_procedimento,preco_atendimento) VALUES ('exame fezes', 40.00);

-- Tipo em Tipo de Pagamento
INSERT INTO tipo_de_pagamento (forma_pagamento) VALUES ('Cartão de crédito');
INSERT INTO tipo_de_pagamento (forma_pagamento) VALUES ('Cartão de débito');
INSERT INTO tipo_de_pagamento (forma_pagamento) VALUES ('Boleto');
INSERT INTO tipo_de_pagamento (forma_pagamento) VALUES ('Dinheiro');
INSERT INTO tipo_de_pagamento (forma_pagamento) VALUES ('Pix');

-- Insert em especie
INSERT INTO especie(nome) VALUES ('Gato');
INSERT INTO especie(nome) VALUES ('Cachorro');

-- Insert em raça
INSERT INTO raca(nome,especie_iD) VALUES ('chiuaua',2);
INSERT INTO raca(nome,especie_iD) VALUES ('boeder collie',2);
INSERT INTO raca(nome,especie_iD) VALUES ('Huskie siberiano',2);
INSERT INTO raca(nome,especie_iD) VALUES ('Lulu da pomerania',2);
INSERT INTO raca(nome,especie_iD) VALUES ('Golden',2);
INSERT INTO raca(nome,especie_iD) VALUES ('Ragdoll',1);
INSERT INTO raca(nome,especie_iD) VALUES ('Persa',1);
INSERT INTO raca(nome,especie_iD) VALUES ('Bombaim',1);
INSERT INTO raca(nome,especie_iD) VALUES ('Birmanês',1);
INSERT INTO raca(nome,especie_iD) VALUES ('Dobra Escocesa',1);

-- Insert em responsável
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('470.962.720-70','Jackie Chan','5137775727',10);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('574.109.580-14','Brad Pitt','5137727915',9);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('553.888.000-16','Johnny Depp','5137722002',8);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('930.834.940-50','Keanu Reeves','519679-2018',7);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('461.576.230-55','Sandra Bullock','5128551443',6);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('273.654.500-10','Jenna Ortega','5120974523',5);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('699.503.340-04','Taylor Schilling','5124528887',4);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('001.851.740-43','Ursula Corbero','5124422728',3);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('755.556.440-86','Maria Pedrazza','5536734294',2);
INSERT INTO responsavel(CPF,nome,telefone,endereco_ID) VALUES ('989.427.080-80','Uzo Aduba','5427760102',1);

-- Insert em animal
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Chico','Médio', 10,1,1,1);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Tina','Médio', 2,2,2,2);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Ozzy','Médio',3,3,1,3);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Lady','Médio',4,4,2,4);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Akira','Médio',6,5,1,5);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Frida','Grande',7,6,2,6);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Safira','Médio',8,7,1,7);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Puma','Pequeno', 9 ,8,2,8);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Dinho','Médio',19,9,1,9);
INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES ('Max','Pequeno',11,10,2,10);

-- Insert em Clinica
INSERT INTO clinica(CNPJ,razao_social,telefone,endereco_ID) VALUES ('66.141.142/0001-87','Pet Care','5432815007',11);

-- Insert em Agendamento
/**
	Agendamento 01
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-23', -- Data Agendamento
    '14:00',  -- Hora Agendamento
    1, -- responsavel_id
    1, -- animal_id
    1, -- clinica_id (1 ou 2)
    1, -- veterinario (1 a 3)
    1, -- tipo_de_pagamento_ID (1 a 5)
    2 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 02
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-24', -- Data Agendamento
    '14:30',  -- Hora Agendamento
    2, -- responsavel_id
    2, -- animal_id
    2, -- clinica_id (1 ou 2)
    2, -- veterinario (1 a 3)
    5, -- tipo_de_pagamento_ID (1 a 5)
    10 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 04
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-23', -- Data Agendamento
    '14:00',  -- Hora Agendamento
    3, -- responsavel_id
    3, -- animal_id
    2, -- clinica_id (1 ou 2)
    1, -- veterinario (1 a 3)
    3, -- tipo_de_pagamento_ID (1 a 5)
    10 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 05
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-09', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    4, -- responsavel_id
    4, -- animal_id
    2, -- clinica_id (1 ou 2)
    1, -- veterinario (1 a 3)
    4, -- tipo_de_pagamento_ID (1 a 5)
    6 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 06
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-07', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    5, -- responsavel_id
    5, -- animal_id
    2, -- clinica_id (1 ou 2)
    3, -- veterinario (1 a 3)
    4, -- tipo_de_pagamento_ID (1 a 5)
    7 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 07
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-01', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    7, -- responsavel_id
    7, -- animal_id
    2, -- clinica_id (1 ou 2)
    3, -- veterinario (1 a 3)
    3, -- tipo_de_pagamento_ID (1 a 5)
    10 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 08
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-28', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    8, -- responsavel_id
    8, -- animal_id
    1, -- clinica_id (1 ou 2)
    2, -- veterinario (1 a 3)
    1, -- tipo_de_pagamento_ID (1 a 5)
    9 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 09
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-30', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    9, -- responsavel_id
    9, -- animal_id
    1, -- clinica_id (1 ou 2)
    2, -- veterinario (1 a 3)
    1, -- tipo_de_pagamento_ID (1 a 5)
    9 -- procedimento_ID (1 a 11)
);

/**
	Agendamento 09
*/
INSERT INTO agendamento(
	data_agendamento,
    hora,
    responsavel_ID,
    animal_id,
    clinica_ID,
    veterinario_ID,
    tipo_de_pagamento_ID,
    procedimento_ID
) VALUES (
	'2023-06-30', -- Data Agendamento
    '10:00',  -- Hora Agendamento
    10, -- responsavel_id
    10, -- animal_id
    1, -- clinica_id (1 ou 2)
    2, -- veterinario (1 a 3)
    1, -- tipo_de_pagamento_ID (1 a 5)
    9 -- procedimento_ID (1 a 11)
);
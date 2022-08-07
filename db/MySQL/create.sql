/* drop database if exists CompraVendaVeiculo; */

/* create database CompraVendaVeiculo; */

use CompraVendaVeiculo;

/* create table Usuario(id bigint not null auto_increment, 
					 email varchar(64) not null unique, 
					 senha varchar(64) not null, 
					 nome varchar(256) not null, 
					 nascimento date,
					 sexo varchar(18), 
					 cpf varchar(32) unique,
					 cnpj varchar(32) unique,
					 categoria varchar(18) not null, 
					 telefone varchar(32),
					 descricao varchar(32),
					 primary key (id));

					 
create table Veiculo(id bigint not null auto_increment,
					 cnpj varchar(32) not null,
					 placa varchar(32) not null,
					 chassi varchar(32) not null,
					 modelo varchar(32) not null,
					 descricao varchar(32) not null,
					 ano integer not null,
					 kilometragem float not null,
					 valor float not null,
					 primary key (id), 
					 foreign key (cnpj) references Usuario(cnpj) ON DELETE CASCADE); */
					
/* create table Compra(id bigint not null auto_increment,
					data date not null,
					valor float not null,
					usuario_id bigint not null,
					veiculo_id bigint not null,
					primary key (id),
					foreign key (usuario_id) references Usuario(id) ON DELETE CASCADE,
					foreign key (veiculo_id) references Veiculo(id) ON DELETE CASCADE);
*/

/*
insert into Usuario(email, senha, nome, categoria) values ('admin@gmail.com', 'admin', 'Admin', 'ADMIN');

insert into Usuario(email, senha, nome, nascimento, sexo, cnpj, categoria, telefone) values ('user2@gmail.com', 'user2', 'Rebecca', '1966-02-16', 'Feminino', '55.789.390/0008-99', 'ADMIN', '(16) 9914955-43');

insert into Usuario(email, senha, nome, nascimento, sexo, cpf, categoria, telefone) values ('user1@gmail.com', 'user1', 'Alain Gauthier', '1995-10-29', 'Masculino', '111111111-11', 'CLIENTE', '(16) 9914955-42');


insert into Usuario(email, senha, nome, nascimento, sexo, cpf, categoria, telefone) values ('user3@gmail.com', 'user3', 'Patricia', '2000-02-02', 'Feminino', '111111111-22', 'CLIENTE', '(16) 9999999-99');

insert into Usuario(email, senha, nome, nascimento, sexo, cpf, categoria, telefone) values ('user4@gmail.com', 'user4', 'Elvis', '1995-10-30', 'Masculino', '111111111-33', 'CLIENTE', '(16) 9999999-88');					

insert into Usuario(email, senha, nome, cnpj, categoria, descricao) values ('loja2@gmail.com', '1234', 'AutoStar', '60.724.444/0001-00', 'LOJA', 'Chevrolet');

insert into Usuario(email, senha, nome, cnpj, categoria, descricao) values ('loja1@gmail.com', '1234', 'Six Vitesses', '55.789.390/0008-00', 'LOJA', 'Peugeot');

*/

/*
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN4I49', 'chassi', 'modelo', 'Peugeot Azul Marinho', 2012, 1234.55, 7350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I49', 'chassi', 'modelo', 'Chevrolet Branco', 2020, 243.55, 27350.00);
*/

/*
insert into Compra(data, valor, usuario_id, veiculo_id) values ('2022-07-25', 5920.10, 3, 1);
*/


insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I49', 'chassi', 'Chevrolet', 'Bolt', 2017, 443.55, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I48', 'chassi', 'Chevrolet', 'Cruze', 2008, 943.55, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I47', 'chassi', 'Chevrolet', 'Menlo', 2020, 59.00, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I46', 'chassi', 'Chevrolet', 'Onix', 2012, 7543.75, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I44', 'chassi', 'Jeep', 'Compass', 2020, 1.50, 79350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I43', 'chassi', 'Jeep', 'Grand Cherokee', 2020, 3.55, 87350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I42', 'chassi', 'Jeep', 'Wrangler', 2020, 4.50, 97350.00);

insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I41', 'chassi', 'Mercedes', 'E-Class Sedan', 2012, 1234.55, 200350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I42', 'chassi', 'Mercedes', 'Ultra-Intelligent', 2012, 1234.55, 243580.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I43', 'chassi', 'Mercedes', 'A-Class Sedans', 2012, 1234.55, 163580.00);







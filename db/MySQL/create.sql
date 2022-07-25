create database CompraVendaVeiculo;
use CompraVendaVeiculo;
create table Usuario(id bigint not null generated always as identity, 
					 email varchar(64) not null unique, 
					 senha varchar(64) not null, 
					 nome varchar(256) not null, 
					 nascimento date,
					 sexo char(16), 
					 cpf varchar(32) unique,
					 cnpj varchar(32) unique,
					 categoria varchar(16) not null, 
					 telefone varchar(32),
					 descricao varchar(32),
					 constraint Usuario_PK primary key (id));
					 
create table Veiculo(id bigint not null generated always as identity,
					 cnpj varchar(32) not null,
					 placa varchar(32) not null,
					 chassi varchar(32) not null,
					 modelo varchar(32) not null,
					 descricao varchar(32) not null,
					 ano integer not null,
					 kilometragem float not null,
					 valor float not null,
					 constraint Veiculo_PK primary key (id), 
					 constraint Loja_FK foreign key (cnpj) references Usuario(cnpj) ON DELETE CASCADE);
					
create table Compra(id bigint not null generated always as identity,
					data date not null,
					valor float not null,
					usuario_id bigint not null,
					veiculo_id bigint not null,
					constraint Compra_PK primary key (id),
					constraint Usuario_FK foreign key (usuario_id) references Usuario(id) ON DELETE CASCADE,
					constraint Veiculo_FK foreign key (veiculo_id) references Veiculo(id) ON DELETE CASCADE));
					
insert into Usuario(email, senha, nome, categoria) values('admin@gmail.com', 'admin', 'Admin', 'ADMIN');

insert into Usuario(email, senha, nome, nascimento, sexo, cpf, categoria, telefone) 
	values('user1@gmail.com', 'user1', 'Alain Gauthier', '1995-10-29', 'Masculino', '111111111-11', 'CLIENTE', '(16) 9914955-42');

insert into Veiculo(cnpj, placa, chassi, modelo, descrcao, ano, kilometragem, valor) 
	values('13.444.222/0001-77', 'LSN4I49', 'chassi', 'modelo', 'descricao', 2012, 0.55, 7350.00);

insert into Compra(data, valor, usuario_id, veiculo_id) values('2022-17-25', 5920.10, 1, 1);
					
					
create table beer
(
	id int not null auto_increment
		primary key,
	alcohol_content varchar(255) null,
	category varchar(255) null,
	ingredients varchar(255) null,
	name varchar(255) null,
	price float null
);

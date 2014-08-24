create table jc_menu(
	id int not null primary key auto_increment,
	name varchar(50),
	url varchar(500),
	parent_id int,
	created_date datetime,
	last_updated_date datetime
)
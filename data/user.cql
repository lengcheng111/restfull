DROP KEYSPACE IF EXISTS ${project}_${env}_user;
CREATE KEYSPACE ${project}_${env}_user
//WITH REPLICATION = {
//'class' : 'NetworkTopologyStrategy',
//'rank-1' : 3
//};
CREATE KEYSPACE ${project}_${env}_user
  WITH REPLICATION = { 
   'class' : 'SimpleStrategy', 
   'replication_factor' : 1 
  };

USE ${project}_${env}_user;
CREATE TABLE users (	
	id timeuuid,
	name text,
	first_name text,
	last_name text,
	email text,
	company text,
	creation_date_time timestamp,
	update_date_time timestamp,
	address text,
	city text,
	phone text,
	description text,
	deleted boolean,
	tracking frozen<tracking>,
	PRIMARY KEY (id)
);
CREATE INDEX users_deleted ON users(deleted);
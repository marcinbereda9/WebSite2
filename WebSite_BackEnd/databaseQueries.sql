CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

insert into category(name, description, image_url,  is_active) 
	values('Wheels','Car Wheels','CAT_1.png',true);
insert into category(name, description, image_url,  is_active) 
	values('Radio','Car Audios','CAT_2.png',true);
insert into category(name, description, image_url,  is_active) 
	values('Cleans','Cleans for car','CAT_3.png',true);
insert into category(name, description, image_url,  is_active) 
	values('Others','Others','CAT_4.png',true);
	
	


CREATE table user_detail( 
	id SERIAL,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled boolean,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	constraint pk_user_id PRIMARY KEY(id)
);﻿

CREATE table product( 
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(250),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views  INT DEFAULT 0,
	
	constraint pk_product_id PRIMARY KEY (id),
	constraint fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	constraint fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_details(id),
);



insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
	values('PRDABC123DEFX','BBS 17"','BBS','This is BBS.',8999,50,true,1,2);
insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
	values('PRDABC234SJSX','Alipne AL1300','OnePlus','This is oneplus, very good.',3199,100,true,2,3);
insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
	values('PRDABC993KSNX','Pioneer pr-2300','Pioneer','This is Pioneer.',2799,500,true,3,3);
insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
	values('PRDSWD191DEFX','Plak Orange','Plak','This is very good Plak',23999,30,true,4,3); 

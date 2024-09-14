Create table Cars(
    cr_id int Primary key auto_increment,
    cr_name varchar(20) not null,
    cr_model varchar(20) unique not null,
    cr_price float(12,3)not null,  
    cr_manufacturing_year int(5)not null,
    cr_brand varchar(20)not null,
    cr_units int not null);

-- 

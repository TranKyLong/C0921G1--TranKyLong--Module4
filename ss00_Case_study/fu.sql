INSERT INTO `case_study_furama`.`rent_type` ( `rent_name`) VALUES ( 'Năm');
INSERT INTO `case_study_furama`.`rent_type` (`rent_name`) VALUES ('Tháng');
INSERT INTO `case_study_furama`.`rent_type` (`rent_name`) VALUES ('Ngày');
INSERT INTO `case_study_furama`.`rent_type` (`rent_name`) VALUES ('Giờ');

INSERT INTO education_degree (edu_name) values 
('Trung cấp') ,
('Cao đẳng') ,
('Đại học ') ,
('sau đại học') ;

INSERT INTO position (pos_name) values 
('Lễ tân') ,
('phục vụ') ,
('chuyên viên') ,
('giám sát'),
('quản lý'),
('giám đốc');

INSERT INTO division (division_name) values 
('Sale – Marketing') ,
('Hành Chính') ,
('Phục vụ') ,
('Quản lý');

INSERT INTO customer_type (customer_type_name) values 
('Diamond') ,
('Platinium') ,
('Gold') ,
('Silver') ,
('Member');

insert into service_type (service_type_name) VALUES
('Villa'),( 'House'), ('Room' );

insert into attach_service (attach_name,attach_cost,attach_unit) VALUES
('massage',100,50),
( 'karaoke',50,50),
( 'thức ăn',40,50),
( 'Thức uống',40,50),
( 'thuê xe',30,50);



SELECT * from attach_service ats
left JOIN contract_detail cd on  ats.attach_id =cd.attach_service_id_attach_id
left join contract c on cd.contract_id_contract_id = c.contract_id
LEFT join furama_service fs on  c.service_id_service_id = fs.service_id
where fs.service_id = 1 ;

SELECT * from furama_service ORDER BY service_type_id_service_type_id ;

select * FROM employee e
LEFT join division d on e.division_id_division_id = d.division_id
 where e.division_id_division_id = 1 ;
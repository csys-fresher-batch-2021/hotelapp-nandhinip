/**
 * user table
 */
create table registered_user(
	mobile_No bigint not null PRIMARY KEY,
    user_name varchar(50) not null,
	pass_word varchar(50) not null,
    gender varchar(60)
);

insert into registered_user(mobile_No,user_name,pass_word,gender)
values ( 9999888889,'pert','qwer1234','Female')

/**
 * room booking table
 */
CREATE TABLE bookRoom(
	id serial primary key,
	mobile_No bigint NOT NULL,
	booked_date TIMESTAMP NOT NULL,
	check_in TIMESTAMP NOT NULL,
    suite_Type character varying(100) NOT NULL,
	ac_choice character varying(100) NOT NULL,
    pool_choice character varying(100) NOT NULL,
    transport_choice character varying(100) NOT NULL,
    bill_amount_estimation double precision NOT NULL,
	modified_date TIMESTAMP,
	status boolean NOT NULL,
	CHECK (bill_amount_estimation > 0)
);

insert into bookRoom(mobile_No,booked_date,check_in,
suite_Type,ac_choice,pool_choice,transport_choice,bill_amount_estimation,
status) values ( 9999888889,'2021-08-08 07:00','2021-07-06 7:00',
'Mountain View','AC','pool Access','With Transport',31234.9,true)


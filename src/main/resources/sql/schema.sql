create table if not exists account (
    id bigint primary key,
    cardNo varchar(20) not null unique key,
    name varchar(20) not null,
    money int not null
);

insert into account (id, cardNo, name, money) values (1, '6029621011000', '周晓兵', 1000);
insert into account (id, cardNo, name, money) values (2, '6029621011001', '周永梅', 1000);

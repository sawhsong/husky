/**
 * User
 */
-- husky
drop user husky cascade;

create user husky identified by husky;
grant connect, resource to husky;
grant create synonym, create view, create database link, create public synonym, drop public synonym to husky;

/*
 * Oracle cloud autonomous database
 */
create user husky identified by husky; -- Oracle cloud autonumous db
grant connect, resource to husky;
grant create synonym, create view, create database link, create public synonym, drop public synonym to husky;
grant unlimited tablespace to husky;


/**
 * Table space(Index, Data)
 */
-- system
alter database datafile 'C:\oraclexe\app\oracle\oradata\xe\system.DBF' autoextend on next 1M maxsize unlimited;

-- husky
<<<<<<< HEAD
create tablespace husky_idx datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_IDX.DBF' size 1m extent management local segment space management auto;
create tablespace husky_data datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_DATA.DBF' size 1m extent management local segment space management auto;
=======
create tablespace hkaccount_idx datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_IDX.DBF' size 1m extent management local segment space management auto;
create tablespace hkaccount_data datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_DATA.DBF' size 1m extent management local segment space management auto;
>>>>>>> refs/remotes/origin/master

alter database datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_IDX.DBF' autoextend on;
alter database datafile 'C:\oraclexe\app\oracle\oradata\Husky\Husky_DATA.DBF' autoextend on;

/**
 * To turn off oracle password expiration
 */
select *
  from dba_users
;

alter profile DEFAULT limit password_life_time unlimited;

/**
 * plan_table
 */
drop table plan_table cascade constraints;
purge recyclebin;

create table plan_table (
    statement_id       varchar2(30),
    plan_id            number,
    timestamp          date,
    remarks            varchar2(4000),
    operation          varchar2(30),
    options            varchar2(255),
    object_node        varchar2(128),
    object_owner       varchar2(30),
    object_name        varchar2(30),
    object_alias       varchar2(65),
    object_instance    numeric,
    object_type        varchar2(30),
    optimizer          varchar2(255),
    search_columns     number,
    id                 numeric,
    parent_id          numeric,
    depth              numeric,
    position           numeric,
    cost               numeric,
    cardinality        numeric,
    bytes              numeric,
    other_tag          varchar2(255),
    partition_start    varchar2(255),
    partition_stop     varchar2(255),
    partition_id       numeric,
    other              long,
    distribution       varchar2(30),
    cpu_cost           numeric,
    io_cost            numeric,
    temp_space         numeric,
    access_predicates  varchar2(4000),
    filter_predicates  varchar2(4000),
    projection         varchar2(4000),
    time               numeric,
    qblock_name        varchar2(30),
    other_xml          clob
);


/**
* Table Name  : 
* Description : Query for TableDefinition Document
**/
select a.table_name,
       a.column_name,
       d.comments,
       a.data_type,
       decode(a.data_type, 'NUMBER', decode(a.data_precision||','||a.data_scale, ',', '', a.data_precision||','||a.data_scale), a.data_length) data_length,
       a.nullable,
       decode(c.constraint_type,'P','PK','R','FK','U','UK') constraint_type,
       '' aaa
  from user_tab_columns a,
       (select a.table_name,
               b.column_name,
               a.constraint_type
          from user_constraints a,
               user_cons_columns b
         where a.constraint_type in ('P', 'R', 'U')
           and a.table_name = b.table_name
           and a.constraint_name = b.constraint_name
       ) c,
       user_col_comments d
 where a.table_name = c.table_name (+)
   and a.column_name = c.column_name (+)
   and a.table_name = d.table_name (+)
   and a.column_name = d.column_name (+)
   and a.num_distinct = '0' -- means 'not-used column'
 order by a.table_name,
       a.nullable,
       a.column_name
;


/**
 * Just for reference
 */
--alter table zebra_board_file add(constraint fk_zebra_board_file foreign key(article_uid) references zebra_board(article_uid));
--create index idx_zebra_board_file on zebra_board_file(file_uid) tablespace alpaca_idx storage(initial 3m next 3m maxextents 2000 pctincrease 0);
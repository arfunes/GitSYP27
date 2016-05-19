/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     19/05/2016 01:00:48 p.m.                     */
/*==============================================================*/


drop index categoria_pk;

drop table categoria;

drop index enfrenta_fk;

drop index dificultades_pk;

drop table dificultades;

drop index reside_en_fk;

drop index persona_pk;

drop table persona;

drop index tiene_fk;

drop index produccion_pk;

drop table produccion;

drop index incluye_fk;

drop index producto_pk;

drop table producto;

drop index usuario_pk;

drop table usuario;

drop index zona_pk;

drop table zona;

drop index gestiona_fk2;

drop index gestiona_fk;

drop index gestiona_pk;

drop table gestiona;

drop index realiza_fk2;

drop index realiza_fk;

drop index realiza_pk;

drop table realiza;

/*==============================================================*/
/* Table: categoria                                             */
/*==============================================================*/
create table categoria (
   idcategoria          serial               not null,
   categoria            varchar(40)          not null,
   descripcion          varchar(254)         null,
   constraint pk_categoria primary key (idcategoria)
);

/*==============================================================*/
/* Index: categoria_pk                                          */
/*==============================================================*/
create unique index categoria_pk on categoria (
idcategoria
);

/*==============================================================*/
/* Table: dificultades                                          */
/*==============================================================*/
create table dificultades (
   iddificultad         serial               not null,
   idpersona            int4                 null,
   enproduccion         varchar(254)         null,
   enventa              varchar(254)         null,
   constraint pk_dificultades primary key (iddificultad)
);

/*==============================================================*/
/* Index: dificultades_pk                                       */
/*==============================================================*/
create unique index dificultades_pk on dificultades (
iddificultad
);

/*==============================================================*/
/* Index: enfrenta_fk                                           */
/*==============================================================*/
create  index enfrenta_fk on dificultades (
idpersona
);

/*==============================================================*/
/* Table: persona                                               */
/*==============================================================*/
create table persona (
   idpersona            serial               not null,
   idzona               int4                 null,
   nombre               varchar(254)         not null,
   edad                 int4                 not null,
   sexo                 bool                 null,
   ingresosanuales      float8               null,
   lugardeventa         int4                 null,
   constraint pk_persona primary key (idpersona)
);

/*==============================================================*/
/* Index: persona_pk                                            */
/*==============================================================*/
create unique index persona_pk on persona (
idpersona
);

/*==============================================================*/
/* Index: reside_en_fk                                          */
/*==============================================================*/
create  index reside_en_fk on persona (
idzona
);

/*==============================================================*/
/* Table: produccion                                            */
/*==============================================================*/
create table produccion (
   idproduccion         serial               not null,
   idproducto           int4                 null,
   preciodeventapormayor float8               not null,
   preciodeventapormenor float8               null,
   unidaddemedida       varchar(30)          not null,
   tamanodeproduccion   int4                 not null,
   constraint pk_produccion primary key (idproduccion)
);

/*==============================================================*/
/* Index: produccion_pk                                         */
/*==============================================================*/
create unique index produccion_pk on produccion (
idproduccion
);

/*==============================================================*/
/* Index: tiene_fk                                              */
/*==============================================================*/
create  index tiene_fk on produccion (
idproducto
);

/*==============================================================*/
/* Table: producto                                              */
/*==============================================================*/
create table producto (
   idproducto           serial               not null,
   idcategoria          int4                 null,
   nombreproducto       varchar(30)          not null,
   detalledeproducto    varchar(254)         null,
   constraint pk_producto primary key (idproducto)
);

/*==============================================================*/
/* Index: producto_pk                                           */
/*==============================================================*/
create unique index producto_pk on producto (
idproducto
);

/*==============================================================*/
/* Index: incluye_fk                                            */
/*==============================================================*/
create  index incluye_fk on producto (
idcategoria
);

/*==============================================================*/
/* Table: usuario                                               */
/*==============================================================*/
create table usuario (
   idusuario            serial               not null,
   nombreusuario        varchar(254)         not null,
   pasword              varchar(254)         not null,
   privilegio           bool                 null,
   constraint pk_usuario primary key (idusuario)
);

/*==============================================================*/
/* Index: usuario_pk                                            */
/*==============================================================*/
create unique index usuario_pk on usuario (
idusuario
);

/*==============================================================*/
/* Table: zona                                                  */
/*==============================================================*/
create table zona (
   idzona               int4                 not null,
   nombrezona           varchar(50)          not null,
   constraint pk_zona primary key (idzona)
);

/*==============================================================*/
/* Index: zona_pk                                               */
/*==============================================================*/
create unique index zona_pk on zona (
idzona
);

/*==============================================================*/
/* Table: gestiona                                              */
/*==============================================================*/
create table gestiona (
   idusuario            int4                 not null,
   idpersona            int4                 not null,
   constraint pk_gestiona primary key (idusuario, idpersona)
);

/*==============================================================*/
/* Index: gestiona_pk                                           */
/*==============================================================*/
create unique index gestiona_pk on gestiona (
idusuario,
idpersona
);

/*==============================================================*/
/* Index: gestiona_fk                                           */
/*==============================================================*/
create  index gestiona_fk on gestiona (
idusuario
);

/*==============================================================*/
/* Index: gestiona_fk2                                          */
/*==============================================================*/
create  index gestiona_fk2 on gestiona (
idpersona
);

/*==============================================================*/
/* Table: realiza                                               */
/*==============================================================*/
create table realiza (
   idpersona            int4                 not null,
   idproduccion         int4                 not null,
   constraint pk_realiza primary key (idpersona, idproduccion)
);

/*==============================================================*/
/* Index: realiza_pk                                            */
/*==============================================================*/
create unique index realiza_pk on realiza (
idpersona,
idproduccion
);

/*==============================================================*/
/* Index: realiza_fk                                            */
/*==============================================================*/
create  index realiza_fk on realiza (
idpersona
);

/*==============================================================*/
/* Index: realiza_fk2                                           */
/*==============================================================*/
create  index realiza_fk2 on realiza (
idproduccion
);

alter table dificultades
   add constraint fk_dificult_enfrenta_persona foreign key (idpersona)
      references persona (idpersona)
      on delete restrict on update cascade;

alter table persona
   add constraint fk_persona_reside_en_zona foreign key (idzona)
      references zona (idzona)
      on delete restrict on update cascade;

alter table produccion
   add constraint fk_producci_tiene_producto foreign key (idproducto)
      references producto (idproducto)
      on delete restrict on update cascade;

alter table producto
   add constraint fk_producto_incluye_categori foreign key (idcategoria)
      references categoria (idcategoria)
      on delete restrict on update cascade;

alter table gestiona
   add constraint fk_gestiona_gestiona_persona foreign key (idpersona)
      references persona (idpersona)
      on delete restrict on update cascade;

alter table gestiona
   add constraint fk_gestiona_gestiona_usuario foreign key (idusuario)
      references usuario (idusuario)
      on delete restrict on update cascade;

alter table realiza
   add constraint fk_realiza_realiza_persona foreign key (idpersona)
      references persona (idpersona)
      on delete restrict on update cascade;

alter table realiza
   add constraint fk_realiza_realiza_producci foreign key (idproduccion)
      references produccion (idproduccion)
      on delete restrict on update cascade;


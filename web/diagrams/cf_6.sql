/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     22/05/2016 04:26:17 a.m.                     */
/*==============================================================*/


drop index INCLUYE_FK;

drop index CATEGORIA_PK;

drop table Categoria;

drop index ENFRENTA_FK;

drop index DIFICULTADES_PK;

drop table Dificultades;

drop index RESIDE_EN_FK;

drop index PERSONA_PK;

drop table Persona;

drop index TIENE_FK;

drop index REALIZA_FK;

drop index PRODUCCION_PK;

drop table Produccion;

drop index PRODUCTO_PK;

drop table Producto;

drop index USUARIO_PK;

drop table Usuario;

drop index ZONA_PK;

drop table Zona;

drop index GESTIONA_FK2;

drop index GESTIONA_FK;

drop index GESTIONA_PK;

drop table gestiona;

/*==============================================================*/
/* Table: Categoria                                             */
/*==============================================================*/
create table Categoria (
   idCategoria          SERIAL               not null,
   idProducto           INT4                 null,
   categoria            VARCHAR(40)          not null,
   descripcion          VARCHAR(254)         null,
   constraint PK_CATEGORIA primary key (idCategoria)
);

/*==============================================================*/
/* Index: CATEGORIA_PK                                          */
/*==============================================================*/
create unique index CATEGORIA_PK on Categoria (
idCategoria
);

/*==============================================================*/
/* Index: INCLUYE_FK                                            */
/*==============================================================*/
create  index INCLUYE_FK on Categoria (
idProducto
);

/*==============================================================*/
/* Table: Dificultades                                          */
/*==============================================================*/
create table Dificultades (
   idDificultad         SERIAL               not null,
   idPersona            INT4                 not null,
   enProduccion         VARCHAR(254)         null,
   enVenta              VARCHAR(254)         null,
   constraint PK_DIFICULTADES primary key (idDificultad)
);

/*==============================================================*/
/* Index: DIFICULTADES_PK                                       */
/*==============================================================*/
create unique index DIFICULTADES_PK on Dificultades (
idDificultad
);

/*==============================================================*/
/* Index: ENFRENTA_FK                                           */
/*==============================================================*/
create  index ENFRENTA_FK on Dificultades (
idPersona
);

/*==============================================================*/
/* Table: Persona                                               */
/*==============================================================*/
create table Persona (
   idPersona            SERIAL               not null,
   idZona               INT4                 not null,
   nombre               VARCHAR(254)         not null,
   edad                 INT4                 not null,
   sexo                 BOOL                 null,
   ingresosAnuales      FLOAT8               null,
   lugarDeVenta         INT4                 null,
   constraint PK_PERSONA primary key (idPersona)
);

/*==============================================================*/
/* Index: PERSONA_PK                                            */
/*==============================================================*/
create unique index PERSONA_PK on Persona (
idPersona
);

/*==============================================================*/
/* Index: RESIDE_EN_FK                                          */
/*==============================================================*/
create  index RESIDE_EN_FK on Persona (
idZona
);

/*==============================================================*/
/* Table: Produccion                                            */
/*==============================================================*/
create table Produccion (
   idProduccion         SERIAL               not null,
   idPersona            INT4                 not null,
   idProducto           INT4                 not null,
   precioDeVentaPorMayor FLOAT8               not null,
   precioDeVentaPorMenor FLOAT8               null,
   unidadDeMedida       VARCHAR(30)          not null,
   tamanoDeProduccion   INT4                 not null,
   constraint PK_PRODUCCION primary key (idProduccion)
);

/*==============================================================*/
/* Index: PRODUCCION_PK                                         */
/*==============================================================*/
create unique index PRODUCCION_PK on Produccion (
idProduccion
);

/*==============================================================*/
/* Index: REALIZA_FK                                            */
/*==============================================================*/
create  index REALIZA_FK on Produccion (
idPersona
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create  index TIENE_FK on Produccion (
idProducto
);

/*==============================================================*/
/* Table: Producto                                              */
/*==============================================================*/
create table Producto (
   idProducto           SERIAL               not null,
   nombreProducto       VARCHAR(30)          not null,
   detalleDeProducto    VARCHAR(254)         null,
   constraint PK_PRODUCTO primary key (idProducto)
);

/*==============================================================*/
/* Index: PRODUCTO_PK                                           */
/*==============================================================*/
create unique index PRODUCTO_PK on Producto (
idProducto
);

/*==============================================================*/
/* Table: Usuario                                               */
/*==============================================================*/
create table Usuario (
   idUsuario            SERIAL               not null,
   nombreUsuario        VARCHAR(254)         not null,
   pasword              VARCHAR(254)         not null,
   privilegio           BOOL                 null,
   constraint PK_USUARIO primary key (idUsuario)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on Usuario (
idUsuario
);

/*==============================================================*/
/* Table: Zona                                                  */
/*==============================================================*/
create table Zona (
   idZona               INT4                 not null,
   nombreZona           VARCHAR(50)          not null,
   constraint PK_ZONA primary key (idZona)
);

/*==============================================================*/
/* Index: ZONA_PK                                               */
/*==============================================================*/
create unique index ZONA_PK on Zona (
idZona
);

/*==============================================================*/
/* Table: gestiona                                              */
/*==============================================================*/
create table gestiona (
   idUsuario            INT4                 not null,
   idPersona            INT4                 not null,
   constraint PK_GESTIONA primary key (idUsuario, idPersona)
);

/*==============================================================*/
/* Index: GESTIONA_PK                                           */
/*==============================================================*/
create unique index GESTIONA_PK on gestiona (
idUsuario,
idPersona
);

/*==============================================================*/
/* Index: GESTIONA_FK                                           */
/*==============================================================*/
create  index GESTIONA_FK on gestiona (
idUsuario
);

/*==============================================================*/
/* Index: GESTIONA_FK2                                          */
/*==============================================================*/
create  index GESTIONA_FK2 on gestiona (
idPersona
);

alter table Categoria
   add constraint FK_CATEGORI_INCLUYE_PRODUCTO foreign key (idProducto)
      references Producto (idProducto)
      on delete restrict on update cascade;

alter table Dificultades
   add constraint FK_DIFICULT_ENFRENTA_PERSONA foreign key (idPersona)
      references Persona (idPersona)
      on delete restrict on update cascade;

alter table Persona
   add constraint FK_PERSONA_RESIDE_EN_ZONA foreign key (idZona)
      references Zona (idZona)
      on delete restrict on update cascade;

alter table Produccion
   add constraint FK_PRODUCCI_REALIZA_PERSONA foreign key (idPersona)
      references Persona (idPersona)
      on delete restrict on update cascade;

alter table Produccion
   add constraint FK_PRODUCCI_TIENE_PRODUCTO foreign key (idProducto)
      references Producto (idProducto)
      on delete restrict on update cascade;

alter table gestiona
   add constraint FK_GESTIONA_GESTIONA_PERSONA foreign key (idPersona)
      references Persona (idPersona)
      on delete restrict on update cascade;

alter table gestiona
   add constraint FK_GESTIONA_GESTIONA_USUARIO foreign key (idUsuario)
      references Usuario (idUsuario)
      on delete restrict on update cascade;


CREATE SEQUENCE citas_serviciosipss_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE horarios_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE horarios_serviciosipss_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE prestaciones_serviciosipss_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE servicios_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE afiliados
(
    num_doc          NUMBER(38, 0) NOT NULL,
    tipo_afiliado    VARCHAR2(31),
    tipo_doc         VARCHAR2(255),
    nombre           VARCHAR2(255),
    fecha_nacimiento TIMESTAMP,
    direccion        VARCHAR2(255),
    telefono         NUMBER(38, 0),
    eps_nit          NUMBER(38, 0),
    CONSTRAINT pk_afiliados PRIMARY KEY (num_doc)
);

CREATE TABLE beneficiarios
(
    num_doc               NUMBER(38, 0) NOT NULL,
    parentesco            VARCHAR2(255),
    contribuyente_num_doc NUMBER(38, 0),
    CONSTRAINT pk_beneficiarios PRIMARY KEY (num_doc)
);

CREATE TABLE citas_serviciosipss
(
    id               NUMBER(38, 0) NOT NULL,
    orden_num_orden  NUMBER(38, 0),
    afiliado_num_doc NUMBER(38, 0),
    CONSTRAINT pk_citas_serviciosipss PRIMARY KEY (id)
);

CREATE TABLE epss
(
    nit    NUMBER(38, 0) NOT NULL,
    nombre VARCHAR2(255),
    CONSTRAINT pk_epss PRIMARY KEY (nit)
);

CREATE TABLE horarios
(
    id          NUMBER(38, 0) NOT NULL,
    dia         date,
    hora_inicio DATE,
    hora_fin    DATE,
    CONSTRAINT pk_horarios PRIMARY KEY (id)
);

CREATE TABLE horarios_serviciosipss
(
    id          NUMBER(38, 0) NOT NULL,
    horario_id  NUMBER(38, 0),
    servicio_id NUMBER(38, 0),
    ips_nit     NUMBER(38, 0),
    CONSTRAINT pk_horarios_serviciosipss PRIMARY KEY (id)
);

CREATE TABLE ipss
(
    nit       NUMBER(38, 0) NOT NULL,
    nombre    VARCHAR2(255),
    direccion VARCHAR2(255),
    telefono  VARCHAR2(255),
    eps_nit   NUMBER(38, 0),
    CONSTRAINT pk_ipss PRIMARY KEY (nit)
);

CREATE TABLE medicos
(
    num_registro NUMBER(38, 0) NOT NULL,
    tipo_doc     NUMBER(5),
    num_doc      NUMBER(38, 0),
    nombre       VARCHAR2(255),
    especialidad VARCHAR2(255),
    ips_nit      NUMBER(38, 0),
    CONSTRAINT pk_medicos PRIMARY KEY (num_registro)
);

CREATE TABLE ordenes
(
    num_orden           NUMBER(38, 0) NOT NULL,
    fecha               TIMESTAMP,
    estado              NUMBER(5),
    afiliado_num_doc    NUMBER(38, 0),
    medico_num_registro NUMBER(38, 0),
    servicio_id         NUMBER(38, 0),
    CONSTRAINT pk_ordenes PRIMARY KEY (num_orden)
);

CREATE TABLE prestaciones_serviciosipss
(
    id                  NUMBER(38, 0) NOT NULL,
    afiliado_num_doc    NUMBER(38, 0),
    medico_num_registro NUMBER(38, 0),
    CONSTRAINT pk_prestaciones_serviciosipss PRIMARY KEY (id)
);

CREATE TABLE servicios
(
    id          NUMBER(38, 0) NOT NULL,
    nombre      VARCHAR2(255),
    descripcion VARCHAR2(255),
    tipo        VARCHAR2(255),
    eps_nit     NUMBER(38, 0),
    CONSTRAINT pk_servicios PRIMARY KEY (id)
);

CREATE TABLE servicios_ipss
(
    ipss_nit     NUMBER(38, 0) NOT NULL,
    servicios_id NUMBER(38, 0) NOT NULL
);

ALTER TABLE afiliados
    ADD CONSTRAINT FK_AFILIADOS_ON_EPS_NIT FOREIGN KEY (eps_nit) REFERENCES epss (nit);

ALTER TABLE beneficiarios
    ADD CONSTRAINT FK_BENEFICIARIOS_ON_CONTRIBUYENTE_NUMDOC FOREIGN KEY (contribuyente_num_doc) REFERENCES afiliados (num_doc);

ALTER TABLE beneficiarios
    ADD CONSTRAINT FK_BENEFICIARIOS_ON_NUMDOC FOREIGN KEY (num_doc) REFERENCES afiliados (num_doc);

ALTER TABLE citas_serviciosipss
    ADD CONSTRAINT FK_CITAS_SERVICIOSIPSS_ON_AFILIADO_NUMDOC FOREIGN KEY (afiliado_num_doc) REFERENCES afiliados (num_doc);

ALTER TABLE citas_serviciosipss
    ADD CONSTRAINT FK_CITAS_SERVICIOSIPSS_ON_ID FOREIGN KEY (id) REFERENCES horarios_serviciosipss (id);

ALTER TABLE citas_serviciosipss
    ADD CONSTRAINT FK_CITAS_SERVICIOSIPSS_ON_ORDEN_NUMORDEN FOREIGN KEY (orden_num_orden) REFERENCES ordenes (num_orden);

ALTER TABLE horarios_serviciosipss
    ADD CONSTRAINT FK_HORARIOS_SERVICIOSIPSS_ON_HORARIO FOREIGN KEY (horario_id) REFERENCES horarios (id);

ALTER TABLE horarios_serviciosipss
    ADD CONSTRAINT FK_HORARIOS_SERVICIOSIPSS_ON_IPS_NIT FOREIGN KEY (ips_nit) REFERENCES ipss (nit);

ALTER TABLE horarios_serviciosipss
    ADD CONSTRAINT FK_HORARIOS_SERVICIOSIPSS_ON_SERVICIO FOREIGN KEY (servicio_id) REFERENCES servicios (id);

ALTER TABLE ipss
    ADD CONSTRAINT FK_IPSS_ON_EPS_NIT FOREIGN KEY (eps_nit) REFERENCES epss (nit);

ALTER TABLE medicos
    ADD CONSTRAINT FK_MEDICOS_ON_IPS_NIT FOREIGN KEY (ips_nit) REFERENCES ipss (nit);

ALTER TABLE ordenes
    ADD CONSTRAINT FK_ORDENES_ON_AFILIADO_NUMDOC FOREIGN KEY (afiliado_num_doc) REFERENCES afiliados (num_doc);

ALTER TABLE ordenes
    ADD CONSTRAINT FK_ORDENES_ON_MEDICO_NUMREGISTRO FOREIGN KEY (medico_num_registro) REFERENCES medicos (num_registro);

ALTER TABLE ordenes
    ADD CONSTRAINT FK_ORDENES_ON_SERVICIO FOREIGN KEY (servicio_id) REFERENCES servicios (id);

ALTER TABLE prestaciones_serviciosipss
    ADD CONSTRAINT FK_PRESTACIONES_SERVICIOSIPSS_ON_AFILIADO_NUMDOC FOREIGN KEY (afiliado_num_doc) REFERENCES afiliados (num_doc);

ALTER TABLE prestaciones_serviciosipss
    ADD CONSTRAINT FK_PRESTACIONES_SERVICIOSIPSS_ON_ID FOREIGN KEY (id) REFERENCES horarios_serviciosipss (id);

ALTER TABLE prestaciones_serviciosipss
    ADD CONSTRAINT FK_PRESTACIONES_SERVICIOSIPSS_ON_MEDICO_NUMREGISTRO FOREIGN KEY (medico_num_registro) REFERENCES medicos (num_registro);

ALTER TABLE servicios
    ADD CONSTRAINT FK_SERVICIOS_ON_EPS_NIT FOREIGN KEY (eps_nit) REFERENCES epss (nit);

ALTER TABLE servicios_ipss
    ADD CONSTRAINT fk_serips_on_i_p_s FOREIGN KEY (ipss_nit) REFERENCES ipss (nit);

ALTER TABLE servicios_ipss
    ADD CONSTRAINT fk_serips_on_servicio FOREIGN KEY (servicios_id) REFERENCES servicios (id);
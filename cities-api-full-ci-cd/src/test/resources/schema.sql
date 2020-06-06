CREATE domain IF NOT EXISTS jsonb AS TEXT;
CREATE domain IF NOT EXISTS POINT AS TEXT;

DROP TABLE IF EXISTS pais;
DROP TABLE IF EXISTS estado;
DROP TABLE IF EXISTS cidade;

CREATE TABLE pais (
  id       bigserial NOT NULL,
  nome     varchar(60),
  nome_pt  varchar(60),
  sigla     varchar(2),
  bacen    integer,
  /* Keys */
  CONSTRAINT pais_pkey
    PRIMARY KEY (id)
);

CREATE TABLE estado (
  id     bigserial NOT NULL,
  nome   varchar(60),
  uf  varchar(2),
  ibge   integer,
  pais   integer,
  ddd    json,
  /* Keys */
  CONSTRAINT estado_pkey
    PRIMARY KEY (id)
);

CREATE TABLE cidade (
    id bigint NOT NULL,
    nome varchar(120),
    uf integer,
    ibge integer,
    lat_lon varchar(120)
);
DROP TABLE vet_specialties IF EXISTS;
DROP TABLE vets IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE visits IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;
DROP TABLE breeds IF EXISTS;
DROP TABLE clinic IF EXISTS;


CREATE TABLE vets (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  house_calls INTEGER,
  telephone   VARCHAR(9)
);
CREATE INDEX vets_last_name ON vets (last_name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE vet_specialties (
  vet_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_vets FOREIGN KEY (vet_id) REFERENCES vets (id);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE breeds (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX breeds_name ON types (name);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20),
  pay_preference VARCHAR(20)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE character (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX character_name ON types (name);

CREATE TABLE pets (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  weight	 FLOAT NOT NULL,
  comments   VARCHAR(200),
  character_id  INTEGER NOT NULL,
  allergies  VARCHAR (200),
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL,
  breed_id    INTEGER NOT NULL
);
ALTER TABLE pets ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_breeds FOREIGN KEY (breed_id) REFERENCES breeds (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES types (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_character FOREIGN KEY (character_id) REFERENCES character (id);
CREATE INDEX pets_name ON pets (name);

CREATE TABLE visits (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  vet_id	  INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255),
  diagnosis    VARCHAR(200),
  treatment    VARCHAR(200)
);
ALTER TABLE visits ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES pets (id);
ALTER TABLE visits ADD CONSTRAINT fk_visits_vets FOREIGN KEY (vet_id) REFERENCES vets (id);
CREATE INDEX visits_pet_id ON visits (pet_id);

CREATE TABLE clinic (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
  address  VARCHAR(200),
  vat VARCHAR (10)
);
CREATE INDEX clinic_name ON clinic (name);
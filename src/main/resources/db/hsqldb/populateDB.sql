INSERT INTO vets VALUES (1, 'James', 'Carter', 0);
INSERT INTO vets VALUES (2, 'Helen', 'Leary', 0);
INSERT INTO vets VALUES (3, 'Linda', 'Douglas', 0);
INSERT INTO vets VALUES (4, 'Rafael', 'Ortega', 1);
INSERT INTO vets VALUES (5, 'Henry', 'Stevens', 1);
INSERT INTO vets VALUES (6, 'Sharon', 'Jenkins', 1);

INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'Cash');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'Cash');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'Credit card');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'Credit card');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'Check');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'Check');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'Cash');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'Cash');
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'Credit card');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'Credit card');

INSERT INTO breeds VALUES (1, 'Not Defined');
INSERT INTO breeds VALUES (2, 'American Curl');
INSERT INTO breeds VALUES (3, 'Burmese');
INSERT INTO breeds VALUES (4, 'Siamese');
INSERT INTO breeds VALUES (5, 'Pekingese');
INSERT INTO breeds VALUES (6, 'Harrier');
INSERT INTO breeds VALUES (7, 'Basenji');

INSERT INTO character VALUES (1, 'Calm');
INSERT INTO character VALUES (2, 'Nervous');
INSERT INTO character VALUES (3, 'Aggressive');

INSERT INTO pets VALUES (1, 'Leo', '2010-09-07', 10, 'Very nice pet', 1, 'insect bite', 1, 1, 2);
INSERT INTO pets VALUES (2, 'Basil', '2012-08-06', 10, 'Very nice pet', 2, 'sunflower seeds', 6, 2, 1);
INSERT INTO pets VALUES (3, 'Rosy', '2011-04-17', 10, 'Very nice pet', 3, '', 2, 3, 6);
INSERT INTO pets VALUES (4, 'Jewel', '2010-03-07', 10, 'Very nice pet', 1, '', 2, 3, 5);
INSERT INTO pets VALUES (5, 'Iggy', '2010-11-30', 10, 'Very nice pet', 2, '', 3, 4, 1);
INSERT INTO pets VALUES (6, 'George', '2010-01-20', 10, 'Very nice pet', 3, 'eggs', 4, 5, 1);
INSERT INTO pets VALUES (7, 'Samantha', '2012-09-04', 10, 'Very nice pet', 1, '', 1, 6, 3);
INSERT INTO pets VALUES (8, 'Max', '2012-09-04', 10, 'Very nice pet', 2, '', 1, 6, 4);
INSERT INTO pets VALUES (9, 'Lucky', '2011-08-06', 10, 'Very nice pet', 3, '', 5, 7, 5);
INSERT INTO pets VALUES (10, 'Mulligan', '2007-02-24', 10, 'Very nice pet', 1, 'lamb, eggs', 2, 8, 7);
INSERT INTO pets VALUES (11, 'Freddy', '2010-03-09', 10, 'Very nice pet', 2, '', 5, 9, 1);
INSERT INTO pets VALUES (12, 'Lucky', '2010-06-24', 10, 'Very nice pet', 3, '', 2, 10, 6);
INSERT INTO pets VALUES (13, 'Sly', '2012-06-08', 10, 'Very nice pet', 1, '', 1, 10, 3);

INSERT INTO visits VALUES (1, 7, 1, '2013-01-01', 'rabies shot','','');
INSERT INTO visits VALUES (2, 8, 1, '2013-01-02', 'rabies shot','','');
INSERT INTO visits VALUES (3, 8, 2, '2013-01-03', 'neutered','','');
INSERT INTO visits VALUES (4, 7, 2, '2013-01-04', 'spayed','','');
INSERT INTO visits VALUES (5, 1, 2, '2013-01-05', 'red, itchy eyes','allergy','Antihistamines');
INSERT INTO visits VALUES (6, 2, 1, '2013-01-06', 'Abdomen, enlarged or swollen','Gastrointestinal obstruction','A lot of food and fluid');

INSERT INTO clinic VALUES (1, 'PioPi0', 'Avda. del pato, 2','B12313123');
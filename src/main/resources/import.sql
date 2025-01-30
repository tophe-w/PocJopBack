
--Grand ouest


SET client_encoding TO UTF8;

INSERT INTO region (name) VALUES ('Auvergne-Rhône-Alpes');

INSERT INTO region (name) VALUES ('Bourgogne-Franche-Comté');

INSERT INTO region (name) VALUES ('Bretagne');

INSERT INTO region (name) VALUES ('Centre-Val de Loire');

INSERT INTO region (name) VALUES ('Grand Est');

INSERT INTO region (name) VALUES ('Hauts-de-France');

INSERT INTO region (name) VALUES ('Île-de-France');

INSERT INTO region (name) VALUES ('Normandie');

INSERT INTO region (name) VALUES ('Nouvelle-Aquitaine');

INSERT INTO region (name) VALUES ('Occitanie');

INSERT INTO region (name) VALUES ('Pays de la Loire');

INSERT INTO region (name) VALUES ('Provence-Alpes-Côte d''Azur');

INSERT INTO category (name) VALUES ('Culture');

INSERT INTO category (name) VALUES ('Musique');

INSERT INTO category (name) VALUES ('Sport');

INSERT INTO category (name) VALUES ('Festival');

INSERT INTO Ligne (name) VALUES ('RER C');

INSERT INTO Ligne (name) VALUES ('Transilien L');

INSERT INTO Ligne (name) VALUES ('Transilien U');

INSERT INTO Ligne (name) VALUES ('Tramway T2');

INSERT INTO Ligne (name) VALUES ('TGV');

INSERT INTO Ligne (name) VALUES ('TER Auvergne-Rhône-Alpes');

INSERT INTO Ligne (name) VALUES ( 'TER Provence-Alpes-Côte d''Azur' );

INSERT INTO Ligne (name) VALUES ('TER Nouvelle-Aquitaine');

INSERT INTO Ligne (name) VALUES ('TER Occitanie');

INSERT INTO Ligne (name) VALUES ('Intercités');

INSERT INTO Ligne (name) VALUES ('TER Bourgogne-Franche-Comté');

INSERT INTO Ligne (name) VALUES ('TER Hauts-de-France');

INSERT INTO Ligne (name) VALUES ('Eurostar');

INSERT INTO Ligne (name) VALUES ('TER Grand Est');

INSERT INTO Ligne (name) VALUES ('TER Pays de la Loire');

INSERT INTO Ligne (name) VALUES ('TER Bretagne');

INSERT INTO Ligne (name) VALUES ('TER Normandie');

INSERT INTO Ligne (name) VALUES ('TER Centre-Val de Loire');



-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Le Zénith de Nantes', 'Nantes', 'Site de concerts à Nantes.', 10000);
INSERT INTO site (name, town, description, capacity) VALUES ('La Cité des Congrès', 'Nantes', 'Salle de conférence à Nantes.', 3000);
INSERT INTO site (name, town, description, capacity) VALUES ('Le Grand Théâtre', 'Angers', 'Site culturel à Angers.', 5000);
INSERT INTO site (name, town, description, capacity) VALUES ('La Beaujoire', 'Nantes', 'Stade de Nantes pour événements sportifs.', 35000);
INSERT INTO site (name, town, description, capacity) VALUES ('Les Machines de l''île', 'Nantes', 'Site touristique et événementiel à Nantes.', 20000);
INSERT INTO site (name, town, description, capacity) VALUES ('La Salle Paul Fort', 'Nantes', 'Salle pour concerts et événements culturels.', 1500);
INSERT INTO site (name, town, description, capacity) VALUES ('La Maison de la Poésie', 'Nantes', 'Salle pour spectacles de poésie.', 500);
INSERT INTO site (name, town, description, capacity) VALUES ('Le Parc des Expositions de La Roche-sur-Yon', 'La Roche-sur-Yon', 'Site d''exposition à La Roche-sur-Yon.', 30000);
INSERT INTO site (name, town, description, capacity) VALUES ('La Base sous-marine', 'Saint-Nazaire', 'Lieu culturel et événementiel à Saint-Nazaire.', 10000);
INSERT INTO site (name, town, description, capacity) VALUES ('Le Théâtre Graslin', 'Nantes', 'Salle de théâtre à Nantes.', 1500);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nantes', 'GARE_DE_NANTES', 'upload/gares/plans/GARE_DE_NANTES/gare_nantes.jpg', 'assets/gares/plan_de_gare_NANTES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Angers', 'GARE_DE_ANGERS', 'upload/gares/plans/GARE_DE_ANGERS/gare_de_angers.jpg', 'assets/gares/plan_de_gare_ANGERS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Saint-Nazaire', 'GARE_DE_SAINT_NAZAIRE', 'upload/gares/plans/GARE_DE_SAINT_NAZAIRE/gare_de_saint_nazaire.jpg', 'assets/gares/plan_de_gare_SAINT_NAZAIRE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de La Roche-sur-Yon', 'GARE_DE_LA_ROCHE_SUR_YON', 'upload/gares/plans/GARE_DE_LA_ROCHE_SUR_YON/gare_de_la_Roche.jpg', 'assets/gares/plan_de_gare_LA_ROCHE_SUR_YON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Cholet', 'GARE_DE_CHOLET', 'upload/gares/plans/GARE_DE_CHOLET/gare_de_cholet.jpg', 'assets/gares/plan_de_gare_CHOLET.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Les Sables-d''Olonne', 'GARE_DE_SABLES', 'upload/gares/plans/GARE_DE_SABLES/gare_des_sables.png', 'assets/gares/plan_de_gare_SABLES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de La Baule', 'GARE_DE_LA_BAULE', 'upload/gares/plans/GARE_DE_LA_BAULE/gare_de_la_baule-escoublac.jpg', 'assets/gares/plan_de_gare_LA_BAULE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Ancenis', 'GARE_DE_ANCENIS', 'upload/gares/plans/GARE_DE_ANCENIS/gare_de_ancenis.jpg', 'assets/gares/plan_de_gare_ANCENIS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Laval', 'GARE_DE_LAVAL', 'upload/gares/plans/GARE_DE_LAVAL/gare_de_laval.jpg', 'assets/gares/plan_de_gare_LAVAL.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de la BD de Nantes', '2025-06-15 00:00:00', '2025-06-17 00:00:00', 'Festival de la bande dessinée', 20000, (SELECT id FROM site WHERE name = 'Le Zénith de Nantes'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concerts Pop-Rock de Nantes', '2025-07-01 00:00:00', '2025-07-05 00:00:00', 'Concerts de pop et rock à Nantes', 15000, (SELECT id FROM site WHERE name = 'La Beaujoire'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Nantes Jazz', '2025-06-12 00:00:00', '2025-06-14 00:00:00', 'Festival de jazz', 30000, (SELECT id FROM site WHERE name = 'Les Machines de l''île'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Le Printemps de la Poésie', '2025-05-20 00:00:00', '2025-05-22 00:00:00', 'Festival de poésie', 5000, (SELECT id FROM site WHERE name = 'La Salle Paul Fort'), (SELECT id FROM category WHERE name = 'Culture'));

INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('La Nuit des Arts', '2025-09-30 00:00:00', '2025-10-03 00:00:00', 'Événements artistiques en extérieur', 10000, (SELECT id FROM site WHERE name = 'Le Grand Théâtre'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Interceltique', '2025-08-07 00:00:00', '2025-08-14 00:00:00', 'Festival interceltique', 25000, (SELECT id FROM site WHERE name = 'La Base sous-marine'), (SELECT id FROM category WHERE name = 'Culture'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Le Zénith de Nantes' ), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'La Beaujoire'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Les Machines de l''île'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'La Salle Paul Fort'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'La Cité des Congrès'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));

-- Insertion des sites
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions de Rennes', 'Rennes', 'Site d''expositions à Rennes.', 50000);
INSERT INTO site (name, town, description, capacity) VALUES ('Plage du Sillon', 'Saint-Malo', 'Site du festival de Saint-Malo.', 40000);
INSERT INTO site (name, town, description, capacity) VALUES ('Le Liberté', 'Rennes', 'Salle de concerts emblématique à Rennes.', 7000);
INSERT INTO site (name, town, description, capacity) VALUES ('Quai de la Douane', 'Brest', 'Quai pour événements maritimes et culturels.', 15000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc du Thabor', 'Rennes', 'Parc emblématique pour événements culturels et musicaux.', 20000);
INSERT INTO site (name, town, description, capacity) VALUES ('Presqu''île de Crozon', 'Crozon', 'Site naturel pour événements culturels.', 60000);
INSERT INTO site (name, town, description, capacity) VALUES ('Port de Paimpol', 'Paimpol', 'Site portuaire accueillant des festivals.', 100000);

-- Insertion des gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Rennes', 'GARE_DE_RENNES', 'upload/gares/plans/GARE_DE_RENNES/gare_de_rennes.jpg', 'assets/gares/plan_de_gare_RENNES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Brest', 'GARE_DE_BREST', 'upload/gares/plans/GARE_DE_BREST/gare_de_brest.jpg', 'assets/gares/plan_de_gare_BREST.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Saint-Malo', 'GARE_DE_SAINT_MALO', 'upload/gares/plans/GARE_DE_SAINT_MALO/gare_de_saint_malo.png', 'assets/gares/plan_de_gare_SAINT_MALO.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lorient', 'GARE_DE_LORIENT', 'upload/gares/plans/GARE_DE_LORIENT/gare_de_lorient.jpg', 'assets/gares/plan_de_gare_LORIENT.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Quimper', 'GARE_DE_QUIMPER', 'upload/gares/plans/GARE_DE_QUIMPER/gare_de_quimper.jpg', 'assets/gares/plan_de_gare_QUIMPER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));

-- Insertion des événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival du Bout du Monde', '2025-08-01 00:00:00', '2025-08-04 00:00:00', 'Festival culturel et musical.', 60000, (SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival du Chant de Marin', '2025-07-06 00:00:00', '2025-07-10 00:00:00', 'Festival maritime à Paimpol.', 100000, (SELECT id FROM site WHERE name = 'Port de Paimpol'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert au Liberté', '2025-06-15 00:00:00', '2025-06-15 22:00:00', 'Concert de musique.', 50000, (SELECT id FROM site WHERE name = 'Le Liberté'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations entre sites et gares
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc des Expositions de Rennes'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Plage du Sillon'), (SELECT id FROM gare WHERE name = 'Gare de Saint-Malo'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Le Liberté'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Quai de la Douane'), (SELECT id FROM gare WHERE name = 'Gare de Brest'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM gare WHERE name = 'Gare de Quimper'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Port de Paimpol'), (SELECT id FROM gare WHERE name = 'Gare de Lorient'));


-- Insertion des sites pour la région Occitanie
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions de Toulouse', 'Toulouse', 'Site d''expositions à Toulouse.', 70000);
INSERT INTO site (name, town, description, capacity) VALUES ('Plage de Palavas', 'Palavas-les-Flots', 'Site balnéaire pour événements à Palavas.', 30000);
INSERT INTO site (name, town, description, capacity) VALUES ('Zénith Sud', 'Montpellier', 'Salle de concerts à Montpellier.', 12000);
INSERT INTO site (name, town, description, capacity) VALUES ('Aéroport de Toulouse-Blagnac', 'Toulouse', 'Site de festivals aériens et événementiels.', 25000);
INSERT INTO site (name, town, description, capacity) VALUES ('Place du Capitole', 'Toulouse', 'Lieu culturel et historique pour événements.', 10000);
INSERT INTO site (name, town, description, capacity) VALUES ('Le Dome', 'Montpellier', 'Salle polyvalente pour concerts et événements.', 15000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions de Nîmes', 'Nîmes', 'Site de foires et expositions à Nîmes.', 50000);
INSERT INTO site (name, town, description, capacity) VALUES ('Arena de Nîmes', 'Nîmes', 'Arène historique pour concerts et spectacles.', 16000);
INSERT INTO site (name, town, description, capacity) VALUES ('Arenas de Perpignan', 'Perpignan', 'Site pour événements culturels et concerts.', 20000);

-- Insertion des gares pour la région Occitanie
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Toulouse', 'GARE_DE_TOULOUSE', 'upload/gares/plans/GARE_DE_TOULOUSE/gare_de_toulouse.jpg', 'assets/gares/plan_de_gare_TOULOUSE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Montpellier','GARE_DE_MONTPELLIER', 'upload/gares/plans/GARE_DE_MONTPELLIER/gare_de_montpellier.jpg', 'assets/gares/plan_de_gare_MONTPELLIER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nîmes', 'GARE_DE_NIMES', 'upload/gares/plans/GARE_DE_NIMES/gare_de_nimes.jpg', 'assets/gares/plan_de_gare_NIMES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Perpignan', 'GARE_DE_PERPIGNAN', 'upload/gares/plans/GARE_DE_PERPIGNAN/gare_de_perpignan.jpg', 'assets/gares/plan_de_gare_PERPIGNAN.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Carcassonne', 'GARE_DE_CARCASSONNE', 'upload/gares/plans/GARE_DE_CARCASSONNE/gare_de_carcassonne.jpg', 'assets/gares/plan_de_gare_CARCASSONNE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Narbonne', 'GARE_DE_NARBONNE', 'upload/gares/plans/GARE_DE_NARBONNE/gare_de_narbonne.jpg', 'assets/gares/plan_de_gare_NARBONNE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Albi', 'GARE_D_ALBI', 'upload/gares/plans/GARE_D_ALBI/gare_de_albi.jpg', 'assets/gares/plan_de_gare_ALBI.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Béziers', 'GARE_DE_BEZIERS', 'upload/gares/plans/GARE_DE_BEZIERS/gare_de_beziers.jpg', 'assets/gares/plan_de_gare_BEZIERS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Mende', 'GARE_DE_MENDE', 'upload/gares/plans/GARE_DE_MENDE/gare_de_mende.jpg', 'assets/gares/plan_de_gare_MENDE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));

-- Insertion des événements pour la région Occitanie
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Toulouse', '2025-07-10 00:00:00', '2025-07-12 00:00:00', 'Festival culturel et musical.', 70000, (SELECT id FROM site WHERE name = 'Parc des Expositions de Toulouse'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Palavas', '2025-08-05 00:00:00', '2025-08-07 00:00:00', 'Festival en bord de mer.', 30000, (SELECT id FROM site WHERE name = 'Plage de Palavas'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert au Zénith Sud', '2025-06-20 19:00:00', '2025-06-20 22:00:00', 'Concert rock au Zénith.', 12000, (SELECT id FROM site WHERE name = 'Zénith Sud'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Aérien Toulouse', '2025-08-15 00:00:00', '2025-08-16 00:00:00', 'Festival aérien à Toulouse.', 25000, (SELECT id FROM site WHERE name = 'Aéroport de Toulouse-Blagnac'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert Place du Capitole', '2025-07-01 17:00:00', '2025-07-01 23:00:00', 'Concert en plein air sur la place du Capitole.', 10000, (SELECT id FROM site WHERE name = 'Place du Capitole'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Salon de l''auto', '2025-09-01 00:00:00', '2025-09-03 00:00:00', 'Salon automobile à Nîmes.', 50000, (SELECT id FROM site WHERE name = 'Parc des Expositions de Nîmes'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert Arena de Nîmes', '2025-07-14 14:00:00', '2025-07-14 23:00:00', 'Concert de musique classique à l''Arena de Nîmes.', 16000, (SELECT id FROM site WHERE name = 'Arena de Nîmes'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Exposition au Dome', '2025-06-25 00:00:00', '2025-07-10 00:00:00', 'Exposition d''art moderne à Montpellier.', 15000, (SELECT id FROM site WHERE name = 'Le Dome'), (SELECT id FROM category WHERE name = 'Culture'));
-- Insertion des associations gare et site
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Toulouse'), (SELECT id FROM site WHERE name = 'Parc des Expositions de Toulouse'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Montpellier'), (SELECT id FROM site WHERE name = 'Zénith Sud'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Nîmes'), (SELECT id FROM site WHERE name = 'Parc des Expositions de Nîmes'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Perpignan'), (SELECT id FROM site WHERE name = 'Arenas de Perpignan'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Carcassonne'), (SELECT id FROM site WHERE name = 'Place du Capitole'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Narbonne'), (SELECT id FROM site WHERE name = 'Parc des Expositions de Nîmes'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare d''Albi'), (SELECT id FROM site WHERE name = 'Le Dome'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Béziers'), (SELECT id FROM site WHERE name = 'Arena de Nîmes'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Mende'), (SELECT id FROM site WHERE name = 'Parc des Expositions de Nîmes'));


INSERT INTO date_calendar(date, day_of_month, month_name_abbr, day_name, day_name_abbr, month_name, year) SELECT datum AS date, EXTRACT(DAY FROM datum) AS day_of_month, TO_CHAR(datum,'Mon') AS month_name_abbr, TO_CHAR(datum,'Day') AS day_name, TO_CHAR(datum,'Dy') AS day_name_abbr, TO_CHAR(datum,'Month') AS month_name, EXTRACT(year FROM datum) "Year" FROM generate_series(DATE '2025-01-01',DATE '2025-12-31',INTERVAL '1 hour') as datum;


INSERT INTO public.affluence(affluence_habituelle_down, affluence_habituelle_up, date_calendar_date_id, estimation_down, estimation_up, gare_id) SELECT floor(random() * 250 + 50)::int AS affluence_habituelle_down,floor(random() * 250 + 50)::int AS affluence_habituelle_up,calendar.date_id AS date_calendar_date_id,floor(random() * 250 + 50)::int AS estimation_down,floor(random() * 250 + 50)::int AS estimation_up,gareAt.id AS gare_id FROM (SELECT id FROM public.gare) AS gareAt CROSS JOIN (SELECT date_id FROM public.date_calendar ) AS calendar
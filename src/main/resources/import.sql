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
INSERT INTO Ligne (name) VALUES ('TER Provence-Alpes-Côte d''Azur');
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
INSERT INTO site (name, town, description, capacity) VALUES ('Base 217', 'Le Plessis-Pâté', 'Un lieu dédié aux événements culturels.', 400000);
INSERT INTO site (name, town, description, capacity) VALUES ('Domaine National de Saint-Cloud', 'Saint-Cloud', 'Un parc pour les festivals de musique.', 120000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions', 'Paris', 'Lieu des salons et foires.', 630000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Brétigny-sur-Orge', 'GARE_DE_BRETIGNY_SUR_ORGE', 'assets/gares/plan_de_gare_GARE_DE_BRETIGNY_SUR_ORGE.jpg', 'assets/gares/plan_de_gare_GARE_DE_BRETIGNY_SUR_ORGE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Île-de-France'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Saint-Cloud', 'GARE_DE_SAINT_CLOUD', 'assets/gares/plan_de_gare_GARE_DE_SAINT_CLOUD.jpg', 'assets/gares/plan_de_gare_GARE_DE_SAINT_CLOUD.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Île-de-France'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de la Porte de Versailles', 'GARE_DE_LA_PORTE_DE_VERSAILLES', 'assets/gares/plan_de_gare_GARE_DE_LA_PORTE_DE_VERSAILLES.jpg', 'assets/gares/plan_de_gare_GARE_DE_LA_PORTE_DE_VERSAILLES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Île-de-France'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête de l''Huma', '2025-05-01 15:06:40', '2025-05-09 00:00:00', 'Un événement culturel et politique.', 400000, (SELECT id FROM site WHERE name = 'Base 217'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Rock en Seine',  '2025-05-01 15:06:40', '2025-05-09 00:00:00', 'Festival de musique.', 120000, (SELECT id FROM site WHERE name = 'Domaine National de Saint-Cloud'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Salon de l''Agriculture',  '2025-05-01 15:06:40', '2025-05-09 00:00:00', 'Salon sur l''agriculture.', 630000, (SELECT id FROM site WHERE name = 'Parc des Expositions'), (SELECT id FROM category WHERE name = 'Culture'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Base 217'), (SELECT id FROM gare WHERE name = 'Gare de Brétigny-sur-Orge'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Domaine National de Saint-Cloud'), (SELECT id FROM gare WHERE name = 'Gare de Saint-Cloud'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc des Expositions'), (SELECT id FROM gare WHERE name = 'Gare de la Porte de Versailles'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Centre-ville de Lyon', 'Lyon', 'Site de la Fête des Lumières.', 1500000);
INSERT INTO site (name, town, description, capacity) VALUES ('Institut Lumière', 'Lyon', 'Centre culturel pour le cinéma.', 1500);
INSERT INTO site (name, town, description, capacity) VALUES ('Théâtre antique de Vienne', 'Vienne', 'Théâtre historique pour événements culturels.', 20000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lyon-Part-Dieu', 'GARE_DE_LYON_PART_DIEU', 'assets/gares/plan_de_gare_GARE_DE_LYON_PART_DIEU.jpg', 'assets/gares/plan_de_gare_GARE_DE_LYON_PART_DIEU.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Auvergne-Rhône-Alpes'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lyon-Vaise', 'GARE_DE_LYON_VAISE', 'assets/gares/plan_de_gare_GARE_DE_LYON_VAISE.jpg', 'assets/gares/plan_de_gare_GARE_DE_LYON_VAISE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Auvergne-Rhône-Alpes'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Vienne', 'GARE_DE_VIENNE', 'assets/gares/plan_de_gare_GARE_DE_VIENNE.jpg', 'assets/gares/plan_de_gare_GARE_DE_VIENNE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Auvergne-Rhône-Alpes'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête des Lumières à Lyon', '2024-10-12 00:00:00', '2024-11-10 00:00:00', 'Un événement lumineux et culturel.', 1500000, (SELECT id FROM site WHERE name = 'Centre-ville de Lyon'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Lumière',  '2024-10-12 00:00:00', '2024-11-10 00:00:00', 'Festival de cinéma à Lyon.', 200000, (SELECT id FROM site WHERE name = 'Institut Lumière'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Jazz à Vienne', '2025-06-26 00:00:00', '2025-07-11 00:00:00', 'Festival de jazz dans le théâtre antique.', 200000, (SELECT id FROM site WHERE name = 'Théâtre antique de Vienne'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Centre-ville de Lyon'), (SELECT id FROM gare WHERE name = 'Gare de Lyon-Part-Dieu'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Institut Lumière'), (SELECT id FROM gare WHERE name = 'Gare de Lyon-Vaise'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Théâtre antique de Vienne'), (SELECT id FROM gare WHERE name = 'Gare de Vienne'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Palais des Festivals', 'Cannes', 'Lieu du Festival de Cannes.', 25000);
INSERT INTO site (name, town, description, capacity) VALUES ('Jardin Biovès', 'Menton', 'Jardin célèbre pour la Fête du Citron.', 30000);
INSERT INTO site (name, town, description, capacity) VALUES ('Port de Saint-Tropez', 'Saint-Tropez', 'Site des Voiles de Saint-Tropez.', 5000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Cannes', 'GARE_DE_CANNES', 'assets/gares/plan_de_gare_GARE_DE_CANNES.jpg', 'assets/gares/plan_de_gare_GARE_DE_CANNES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Provence-Alpes-Côte d''Azur'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Menton', 'GARE_DE_MENTON', 'assets/gares/plan_de_gare_GARE_DE_MENTON.jpg', 'assets/gares/plan_de_gare_GARE_DE_MENTON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Provence-Alpes-Côte d''Azur'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Saint-Raphaël-Valescure', 'GARE_DE_SAINT_RAPHAEL_VALESCURE', 'assets/gares/plan_de_gare_GARE_DE_SAINT_RAPHAEL_VALESCURE.jpg', 'assets/gares/plan_de_gare_GARE_DE_SAINT_RAPHAEL_VALESCURE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Provence-Alpes-Côte d''Azur'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Cannes', '2025-05-13 00:00:00', '2025-05-24 00:00:00', 'Festival international du film à Cannes.', 200000, (SELECT id FROM site WHERE name = 'Palais des Festivals'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête du Citron', '2025-01-02 00:00:00', '2025-03-01 00:00:00', 'Festival du citron à Menton.', 200000, (SELECT id FROM site WHERE name = 'Jardin Biovès'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Les Voiles de Saint-Tropez',  '2025-09-20 00:00:00', '2025-09-28 00:00:00', 'Régates et événements nautiques.', 300000, (SELECT id FROM site WHERE name = 'Port de Saint-Tropez'), (SELECT id FROM category WHERE name = 'Sport'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Palais des Festivals'), (SELECT id FROM gare WHERE name = 'Gare de Cannes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Jardin Biovès'), (SELECT id FROM gare WHERE name = 'Gare de Menton'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Port de Saint-Tropez'), (SELECT id FROM gare WHERE name = 'Gare de Saint-Raphaël-Valescure'));

-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Angoulême', 'Angoulême', 'Ville hôte du Festival de la BD.', 200000);
INSERT INTO site (name, town, description, capacity) VALUES ('Cognac', 'Cognac', 'Ville hôte du Festival International de Musique.', 45000);
INSERT INTO site (name, town, description, capacity) VALUES ('Plaine de la Filhole', 'Marmande', 'Site du Festival Garorock.', 160000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Angoulême', 'GARE_D''ANGOULÊME', 'assets/gares/plan_de_gare_GARE_D''ANGOULÊME.jpg', 'assets/gares/plan_de_gare_GARE_D''ANGOULÊME.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Nouvelle-Aquitaine'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Cognac', 'GARE_DE_COGNAC', 'assets/gares/plan_de_gare_GARE_DE_COGNAC.jpg', 'assets/gares/plan_de_gare_GARE_DE_COGNAC.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Nouvelle-Aquitaine'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Marmande', 'GARE_DE_MARMANDE', 'assets/gares/plan_de_gare_GARE_DE_MARMANDE.jpg', 'assets/gares/plan_de_gare_GARE_DE_MARMANDE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Nouvelle-Aquitaine'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de la BD à Angoulême', '2025-01-30 00:00:00', '2025-02-02 00:00:00', 'Célébration de la bande dessinée.', 200000, (SELECT id FROM site WHERE name = 'Angoulême'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('La Fête du  Cognac', '2025-07-24 00:00:00', '2025-07-26 00:00:00', 'Festival de musique à Cognac.', 45000, (SELECT id FROM site WHERE name = 'Cognac'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Garorock à Marmande', '2025-07-03 00:00:00', '2025-07-06 00:00:00', 'Festival de musique à Marmande.', 160000, (SELECT id FROM site WHERE name = 'Plaine de la Filhole'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Angoulême'), (SELECT id FROM gare WHERE name = 'Gare d''Angoulême'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Cognac'), (SELECT id FROM gare WHERE name = 'Gare de Cognac'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Plaine de la Filhole'), (SELECT id FROM gare WHERE name = 'Gare de Marmande'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Cité Médiévale de Carcassonne', 'Carcassonne', 'Site du Festival de Carcassonne.', 250000);
INSERT INTO site (name, town, description, capacity) VALUES ('Palais des Congrès', 'Perpignan', 'Site du Festival International de Photojournalisme.', 200000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc de Valmy', 'Argelès-sur-Mer', 'Site du Festival Les Déferlantes.', 100000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Carcassonne', 'GARE_DE_CARCASSONNE', 'assets/gares/plan_de_gare_GARE_DE_CARCASSONNE.jpg', 'assets/gares/plan_de_gare_GARE_DE_CARCASSONNE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Perpignan', 'GARE_DE_PERPIGNAN', 'assets/gares/plan_de_gare_GARE_DE_PERPIGNAN.jpg', 'assets/gares/plan_de_gare_GARE_DE_PERPIGNAN.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Argelès-sur-Mer', 'GARE_D''ARGELÈS_SUR_MER', 'assets/gares/plan_de_gare_GARE_D''ARGELÈS_SUR_MER.jpg', 'assets/gares/plan_de_gare_GARE_D''ARGELÈS_SUR_MER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Carcassonne', '2025-07-23 00:00:00', '2024-08-03 00:00:00', 'Festival de spectacles et concerts.', 250000, (SELECT id FROM site WHERE name = 'Cité Médiévale de Carcassonne'), (SELECT id FROM category WHERE name = 'Festival'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival International de Photojournalisme à Perpignan', '2025-08-07 00:00:00', '2025-10-01 00:00:00', 'Festival de photojournalisme.', 200000, (SELECT id FROM site WHERE name = 'Palais des Congrès'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Les Déferlantes', '2025-06-26 00:00:00', '2025-06-29 00:00:00', 'Festival de musique à Argelès-sur-Mer.', 100000, (SELECT id FROM site WHERE name = 'Parc de Valmy'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Cité Médiévale de Carcassonne'), (SELECT id FROM gare WHERE name = 'Gare de Carcassonne'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Palais des Congrès'), (SELECT id FROM gare WHERE name = 'Gare de Perpignan'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc de Valmy'), (SELECT id FROM gare WHERE name = 'Gare d''Argelès-sur-Mer'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Marché de Noël', 'Strasbourg', 'Célèbre marché de Noël.', 2000000);
INSERT INTO site (name, town, description, capacity) VALUES ('Palais du Gouvernement', 'Nancy', 'Site de la Fête de la Saint-Nicolas.', 100000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions de Colmar', 'Colmar', 'Lieu du Festival International de Colmar.', 10000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Strasbourg', 'GARE_DE_STRASBOURG', 'assets/gares/plan_de_gare_GARE_DE_STRASBOURG.jpg', 'assets/gares/plan_de_gare_GARE_DE_STRASBOURG.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Grand Est'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nancy', 'GARE_DE_NANCY', 'assets/gares/plan_de_gare_GARE_DE_NANCY.jpg', 'assets/gares/plan_de_gare_GARE_DE_NANCY.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Grand Est'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Colmar', 'GARE_DE_COLMAR', 'assets/gares/plan_de_gare_GARE_DE_COLMAR.jpg', 'assets/gares/plan_de_gare_GARE_DE_COLMAR.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Grand Est'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Marché de Noël de Strasbourg', '2025-11-22 00:00:00', '2025-11-26 00:00:00', 'Marché de Noël traditionnel.', 2000000, (SELECT id FROM site WHERE name = 'Marché de Noël'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête de la Saint-Nicolas à Nancy', '2025-12-12 00:00:00', '2025-12-13 00:00:00', 'Célébration de la Saint-Nicolas.', 100000, (SELECT id FROM site WHERE name = 'Palais du Gouvernement'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival International de Colmar', '2025-07-04 00:00:00', '2025-07-13 00:00:00', 'Festival de musique classique.', 10000, (SELECT id FROM site WHERE name = 'Parc des Expositions de Colmar'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Marché de Noël'), (SELECT id FROM gare WHERE name = 'Gare de Strasbourg'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Palais du Gouvernement'), (SELECT id FROM gare WHERE name = 'Gare de Nancy'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc des Expositions de Colmar'), (SELECT id FROM gare WHERE name = 'Gare de Colmar'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Gare de Lille-Flandres', 'Lille', 'Site de la Braderie de Lille.', 3000000);
INSERT INTO site (name, town, description, capacity) VALUES ('Grand Place de Tournai', 'Tournai', 'Lieu du Festival de l''Accordéon.', 10000);
INSERT INTO site (name, town, description, capacity) VALUES ('Citadelle d''Arras', 'Arras', 'Lieu du Main Square Festival.', 125000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lille-Flandres', 'GARE_DE_LILLE_FLANDRES', 'assets/gares/plan_de_gare_GARE_DE_LILLE_FLANDRES.jpg', 'assets/gares/plan_de_gare_GARE_DE_LILLE_FLANDRES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Hauts-de-France'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Tournai', 'GARE_DE_TOURNAI', 'assets/gares/plan_de_gare_GARE_DE_TOURNAI.jpg', 'assets/gares/plan_de_gare_GARE_DE_TOURNAI.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Hauts-de-France'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Arras', 'GARE_D''ARRAS', 'assets/gares/plan_de_gare_GARE_D''ARRAS.jpg', 'assets/gares/plan_de_gare_GARE_D''ARRAS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Hauts-de-France'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Braderie de Lille', '2025-09-08 00:00:00', '2025-09-12 00:00:00', 'Grande foire commerciale.', 3000000, (SELECT id FROM site WHERE name = 'Gare de Lille-Flandres'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de l''Accordéon à Tournai', '2025-09-13 00:00:00', '2025-09-15 00:00:00', 'Festival d''accordéon.', 10000, (SELECT id FROM site WHERE name = 'Grand Place de Tournai'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Main Square Festival à Arras', '2025-07-04 00:00:00', '2025-07-06 00:00:00', 'Festival de musique.', 125000, (SELECT id FROM site WHERE name = 'Citadelle d''Arras'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Gare de Lille-Flandres'), (SELECT id FROM gare WHERE name = 'Gare de Lille-Flandres'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Grand Place de Tournai'), (SELECT id FROM gare WHERE name = 'Gare de Tournai'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Citadelle d''Arras'), (SELECT id FROM gare WHERE name = 'Gare d''Arras'));

-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Fête de la Vigne', 'Dijon', 'Événement sur la viticulture.', 50000);
INSERT INTO site (name, town, description, capacity) VALUES ('Théâtre de Beaune', 'Beaune', 'Site du Festival International du Film Policier.', 10000);
INSERT INTO site (name, town, description, capacity) VALUES ('Centre-ville de Besançon', 'Besançon', 'Lieu du Festival de Musique Baroque.', 25000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Dijon', 'GARE_DE_DIJON', 'assets/gares/plan_de_gare_GARE_DE_DIJON.jpg', 'assets/gares/plan_de_gare_GARE_DE_DIJON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bourgogne-Franche-Comté'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Beaune', 'GARE_DE_BEAUNE', 'assets/gares/plan_de_gare_GARE_DE_BEAUNE.jpg', 'assets/gares/plan_de_gare_GARE_DE_BEAUNE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bourgogne-Franche-Comté'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Besançon', 'GARE_DE_BESANÇON', 'assets/gares/plan_de_gare_GARE_DE_BESANÇON.jpg', 'assets/gares/plan_de_gare_GARE_DE_BESANÇON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bourgogne-Franche-Comté'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête de la Vigne à Dijon',  '2025-07-04 00:00:00', '2025-07-08 00:00:00', 'Célébration des vignes.', 50000, (SELECT id FROM site WHERE name = 'Fête de la Vigne'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival International du Film Policier à Beaune', '2025-05-02 00:00:00', '2025-05-05 00:00:00', 'Festival du film policier.', 10000, (SELECT id FROM site WHERE name = 'Théâtre de Beaune'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Musique Baroque à Besançon', '2025-09-13 00:00:00', '2025-09-13 00:00:00', 'Festival de musique baroque.', 25000, (SELECT id FROM site WHERE name = 'Centre-ville de Besançon'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Fête de la Vigne'), (SELECT id FROM gare WHERE name = 'Gare de Dijon'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Théâtre de Beaune'), (SELECT id FROM gare WHERE name = 'Gare de Beaune'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Centre-ville de Besançon'), (SELECT id FROM gare WHERE name = 'Gare de Besançon'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Port de Rouen', 'Rouen', 'Site de l''Armada de Rouen.', 10000000);
INSERT INTO site (name, town, description, capacity) VALUES ('Château de Beauregard', 'Hérouville-Saint-Clair', 'Site du Festival Beauregard.', 110000);
INSERT INTO site (name, town, description, capacity) VALUES ('Plage de Dieppe', 'Dieppe', 'Lieu de la Fête de la Mer.', 250000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Rouen', 'GARE_DE_ROUEN', 'assets/gares/plan_de_gare_GARE_DE_ROUEN.jpg', 'assets/gares/plan_de_gare_GARE_DE_ROUEN.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Normandie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Caen', 'GARE_DE_CAEN', 'assets/gares/plan_de_gare_GARE_DE_CAEN.jpg', 'assets/gares/plan_de_gare_GARE_DE_CAEN.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Normandie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Dieppe', 'GARE_DE_DIEPPE', 'assets/gares/plan_de_gare_GARE_DE_DIEPPE.jpg', 'assets/gares/plan_de_gare_GARE_DE_DIEPPE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Normandie'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Armada de Rouen', '2025-11-23 00:00:00', '2025-12-01 00:00:00', 'Événement maritime de grande envergure.', 10000000, (SELECT id FROM site WHERE name = 'Port de Rouen'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Beauregard à Hérouville-Saint-Clair', '2025-07-03 00:00:00', '2025-07-06 00:00:00', 'Festival de musique.', 110000, (SELECT id FROM site WHERE name = 'Château de Beauregard'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Fête de la Mer à Dieppe','2025-12-11 00:00:00', '2026-01-05 00:00:00', 'Événement maritime.', 250000, (SELECT id FROM site WHERE name = 'Plage de Dieppe'), (SELECT id FROM category WHERE name = 'Culture'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Port de Rouen'), (SELECT id FROM gare WHERE name = 'Gare de Rouen'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Château de Beauregard'), (SELECT id FROM gare WHERE name = 'Gare de Caen'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Plage de Dieppe'), (SELECT id FROM gare WHERE name = 'Gare de Dieppe'));

-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Cathédrale d''Orléans', 'Orléans', 'Site des Fêtes Johanniques.', 100000);
INSERT INTO site (name, town, description, capacity) VALUES ('Berges de la Loire', 'Orléans', 'Lieu du Festival de la Loire.', 650000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc des Expositions de Bourges', 'Bourges', 'Lieu du Printemps de Bourges.', 200000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Orléans', 'GARE_D''ORLÉANS', 'assets/gares/plan_de_gare_GARE_D''ORLÉANS.jpg', 'assets/gares/plan_de_gare_GARE_D''ORLÉANS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Centre-Val de Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Bourges', 'GARE_DE_BOURGES', 'assets/gares/plan_de_gare_GARE_DE_BOURGES.jpg', 'assets/gares/plan_de_gare_GARE_DE_BOURGES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Centre-Val de Loire'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Les Fêtes Johanniques à Orléans', '2025-05-10 00:00:00', '2025-05-11 00:00:00', 'Célébration historique.', 100000, (SELECT id FROM site WHERE name = 'Cathédrale d''Orléans'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Loire à Orléans', '2025-09-13 00:00:00', '2025-09-15 00:00:00', 'Festival sur la Loire.', 650000, (SELECT id FROM site WHERE name = 'Berges de la Loire'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Le Printemps de Bourges', '2025-04-15 00:00:00', '2025-04-20 00:00:00', 'Festival de musique.', 200000, (SELECT id FROM site WHERE name = 'Parc des Expositions de Bourges'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Cathédrale d''Orléans'), (SELECT id FROM gare WHERE name = 'Gare d''Orléans'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Berges de la Loire'), (SELECT id FROM gare WHERE name = 'Gare d''Orléans'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc des Expositions de Bourges'), (SELECT id FROM gare WHERE name = 'Gare de Bourges'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Clisson', 'Clisson', 'Site du Hellfest.', 180000);
INSERT INTO site (name, town, description, capacity) VALUES ('Cité des Congrès', 'Nantes', 'Site des Folles Journées de Nantes.', 150000);
INSERT INTO site (name, town, description, capacity) VALUES ('Parc du Port Mulon', 'Nort-sur-Erdre', 'Lieu de La Nuit de l''Erdre.', 45000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Clisson', 'GARE_DE_CLISSON', 'assets/gares/plan_de_gare_GARE_DE_CLISSON.jpg', 'assets/gares/plan_de_gare_GARE_DE_CLISSON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nantes', 'GARE_DE_NANTES', 'assets/gares/plan_de_gare_GARE_DE_NANTES.jpg', 'assets/gares/plan_de_gare_GARE_DE_NANTES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nort-sur-Erdre', 'GARE_DE_NORT_SUR_ERDRE', 'assets/gares/plan_de_gare_GARE_DE_NORT_SUR_ERDRE.jpg', 'assets/gares/plan_de_gare_GARE_DE_NORT_SUR_ERDRE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Hellfest à Clisson', '2025-06-19 00:00:00', '2025-06-22 00:00:00', 'Festival de musique métal.', 180000, (SELECT id FROM site WHERE name = 'Clisson'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Les Folles Journées à Nantes', '2025-01-29 00:00:00', '2025-02-02 00:00:00', 'Festival de musique classique.', 150000, (SELECT id FROM site WHERE name = 'Cité des Congrès'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('La Nuit de l''Erdre à Nort-sur-Erdre', '2025-07-03 00:00:00', '2025-07-06 00:00:00', 'Festival de musique.', 45000, (SELECT id FROM site WHERE name = 'Parc du Port Mulon'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Clisson'), (SELECT id FROM gare WHERE name = 'Gare de Clisson'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Cité des Congrès'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc du Port Mulon'), (SELECT id FROM gare WHERE name = 'Gare de Nort-sur-Erdre'));


-- Sites
INSERT INTO site (name, town, description, capacity) VALUES ('Gare de Lorient', 'Lorient', 'Site du Festival Interceltique de Lorient.', 800000);
INSERT INTO site (name, town, description, capacity) VALUES ('Prairies de Kerampuilh', 'Carhaix-Plouguer', 'Site des Vieilles Charrues.', 280000);
INSERT INTO site (name, town, description, capacity) VALUES ('Presqu''île de Crozon', 'Crozon', 'Site du Festival du Bout du Monde.', 60000);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lorient', 'GARE_DE_LORIENT', 'assets/gares/plan_de_gare_GARE_DE_LORIENT.jpg', 'assets/gares/plan_de_gare_GARE_DE_LORIENT.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Carhaix-Plouguer', 'GARE_DE_CARHAIX_PLOUGUER', 'assets/gares/plan_de_gare_GARE_DE_CARHAIX_PLOUGUER.jpg', 'assets/gares/plan_de_gare_GARE_DE_CARHAIX_PLOUGUER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Quimper', 'GARE_DE_QUIMPER', 'assets/gares/plan_de_gare_GARE_DE_QUIMPER.jpg', 'assets/gares/plan_de_gare_GARE_DE_QUIMPER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));

-- Événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Interceltique de Lorient','2025-08-01 00:00:00', '2025-08-10 00:00:00', 'Festival de culture celtique.', 800000, (SELECT id FROM site WHERE name = 'Gare de Lorient'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Les Vieilles Charrues à Carhaix', '2025-07-17 00:00:00', '2025-07-20 00:00:00', 'Festival de musique.', 280000, (SELECT id FROM site WHERE name = 'Prairies de Kerampuilh'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival du Bout du Monde à Crozon', '2025-08-02 00:00:00', '2025-08-04 00:00:00', 'Événement musical et culturel.', 60000, (SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM category WHERE name = 'Festival'));

-- Associations
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Gare de Lorient'), (SELECT id FROM gare WHERE name = 'Gare de Lorient'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Prairies de Kerampuilh'), (SELECT id FROM gare WHERE name = 'Gare de Carhaix-Plouguer'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM gare WHERE name = 'Gare de Quimper'));



-- Île-de-France
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'RER C'), (SELECT id FROM Gare WHERE name = 'Gare de Brétigny-sur-Orge'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'Transilien L'), (SELECT id FROM Gare WHERE name = 'Gare de Saint-Cloud'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'Transilien U'), (SELECT id FROM Gare WHERE name = 'Gare de Saint-Cloud'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'Tramway T2'), (SELECT id FROM Gare WHERE name = 'Gare de la Porte de Versailles'));

-- Auvergne-Rhône-Alpes
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare de Lyon-Part-Dieu'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Auvergne-Rhône-Alpes'), (SELECT id FROM Gare WHERE name = 'Gare de Lyon-Part-Dieu'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Auvergne-Rhône-Alpes'), (SELECT id FROM Gare WHERE name = 'Gare de Lyon-Vaise'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Auvergne-Rhône-Alpes'), (SELECT id FROM Gare WHERE name = 'Gare de Vienne'));

-- Provence-Alpes-Côte d'Azur
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Provence-Alpes-Côte d''Azur'), (SELECT id FROM Gare WHERE name = 'Gare de Cannes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Provence-Alpes-Côte d''Azur'), (SELECT id FROM Gare WHERE name = 'Gare de Menton'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Provence-Alpes-Côte d''Azur'), (SELECT id FROM Gare WHERE name = 'Gare de Saint-Raphaël-Valescure'));

-- Nouvelle-Aquitaine
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare d''Angoulême'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Nouvelle-Aquitaine'), (SELECT id FROM Gare WHERE name = 'Gare d''Angoulême'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Nouvelle-Aquitaine'), (SELECT id FROM Gare WHERE name = 'Gare de Cognac'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Nouvelle-Aquitaine'), (SELECT id FROM Gare WHERE name = 'Gare de Marmande'));

-- Occitanie
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Occitanie'), (SELECT id FROM Gare WHERE name = 'Gare de Carcassonne'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Occitanie'), (SELECT id FROM Gare WHERE name = 'Gare de Perpignan'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Occitanie'), (SELECT id FROM Gare WHERE name = 'Gare d''Argelès-sur-Mer'));

-- Bourgogne-Franche-Comté
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare de Dijon'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bourgogne-Franche-Comté'), (SELECT id FROM Gare WHERE name = 'Gare de Dijon'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bourgogne-Franche-Comté'), (SELECT id FROM Gare WHERE name = 'Gare de Beaune'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bourgogne-Franche-Comté'), (SELECT id FROM Gare WHERE name = 'Gare de Besançon'));

-- Hauts-de-France
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare de Lille-Flandres'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Hauts-de-France'), (SELECT id FROM Gare WHERE name = 'Gare de Lille-Flandres'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Hauts-de-France'), (SELECT id FROM Gare WHERE name = 'Gare de Tournai'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Hauts-de-France'), (SELECT id FROM Gare WHERE name = 'Gare d''Arras'));

-- Grand Est
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare de Strasbourg'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Grand Est'), (SELECT id FROM Gare WHERE name = 'Gare de Strasbourg'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Grand Est'), (SELECT id FROM Gare WHERE name = 'Gare de Nancy'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Grand Est'), (SELECT id FROM Gare WHERE name = 'Gare de Colmar'));

-- Pays de la Loire
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM Gare WHERE name = 'Gare de Clisson'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TGV'), (SELECT id FROM Gare WHERE name = 'Gare de Nantes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM Gare WHERE name = 'Gare de Nantes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM Gare WHERE name = 'Gare de Nort-sur-Erdre'));

-- Bretagne
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bretagne'), (SELECT id FROM Gare WHERE name = 'Gare de Lorient'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bretagne'), (SELECT id FROM Gare WHERE name = 'Gare de Carhaix-Plouguer'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Bretagne'), (SELECT id FROM Gare WHERE name = 'Gare de Quimper'));

-- Normandie
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Normandie'), (SELECT id FROM Gare WHERE name = 'Gare de Rouen'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Normandie'), (SELECT id FROM Gare WHERE name = 'Gare de Caen'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Normandie'), (SELECT id FROM Gare WHERE name = 'Gare de Dieppe'));

-- Centre-Val de Loire
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Centre-Val de Loire'), (SELECT id FROM Gare WHERE name = 'Gare d''Orléans'));

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM Ligne WHERE name = 'TER Centre-Val de Loire'), (SELECT id FROM Gare WHERE name = 'Gare de Bourges'));


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
INSERT INTO site (name, town, description, photo, capacity) VALUES ('Le Zénith de Nantes', 'Nantes', 'Le Zénith de Nantes est une salle de spectacles inaugurée en 2006, pouvant accueillir jusqu''à 9 000 spectateurs. Conçu par l''Atelier Chaix & Morel, son architecture moderne en métal perforé se distingue par sa forme ovale.','upload/sites/photos/zentihNantes/zenith-nantes.jpeg', 9000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('La Cité des Congrès', 'Nantes', 'La Cité des Congrès de Nantes, inaugurée en 1992, est un centre de congrès majeur en France, situé au cœur de Nantes, face à la gare TGV. Elle accueille chaque année plus de 300 événements économiques et culturels.','upload/sites/photos/congresNantes/Cité-des-congres-Nantes.jpeg', 3000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Le Grand Théâtre', 'Angers', 'Le Grand Théâtre d''Angers, situé sur la place du Ralliement, est un édifice emblématique inauguré en 1871. Conçu par les architectes Alphonse Botrel et Auguste Magne, il est caractéristique des théâtres à l''italienne .','upload/sites/photos/theatreAngers/theatre-angers.jpeg', 5000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('La Beaujoire', 'Nantes', 'Le Stade de la Beaujoire - Louis Fonteneau est le principal stade de la ville de Nantes, situé dans le quartier Nantes Erdre. Inauguré le 8 mai 1984, il a été construit pour accueillir des matchs du Championnat d''Europe de football 1984.','upload/sites/photos/beaujoir/beaujoirNantes.jpeg', 35000);
INSERT INTO site (name, town, description, photo,capacity) VALUES ('Les Machines de l''île', 'Nantes', 'Les Machines de l’île sont une attraction unique inspirée de l’univers de Jules Verne et de l’ingéniosité de Léonard de Vinci. Ce projet artistique et mécanique a vu le jour sur l’Île de Nantes, dans les anciens chantiers navals.','upload/sites/photos/machines-Nates/machines.jpg', 20000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('La Salle Paul Fort', 'Nantes', 'Salle de spectacles à Nantes, connue pour sa programmation musicale variée et ses événements culturels.', 'upload/sites/photos/paulFort-Nantes/paulFort-Nantes.jpeg', 1500);
INSERT INTO site (name, town, description, photo,capacity) VALUES ('La Maison de la Poésie', 'Nantes', 'La Maison de la Poésie est un lieu dédié à la promotion et à la diffusion de la poésie contemporaine sous toutes ses formes. Elle propose des événements autour de la littérature.', 'upload/sites/photos/MaisonPoesieNantes/poesie-nantes.jpeg', 500);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Le Parc des Expositions de La Roche-sur-Yon', 'La Roche-sur-Yon', 'Le Parc des Expositions des Oudairies, situé à La Roche-sur-Yon, est un complexe polyvalent conçu pour accueillir une variété d''événements, tels que des salons professionnels, des expositions, des spectacles culturels et des manifestations sportives', 'upload/sites/photos/expoLaRoche/rochesuryon.jpg', 30000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('La Base sous-marine', 'Saint-Nazaire', 'Construite pendant la Seconde Guerre mondiale par l''armée allemande, c''est un impressionnant bunker en béton armé destiné à abriter les sous-marins U-Boote. Après la guerre, cette structure imposante a été transformée en un espace culturel et touristique', 'upload/sites/photos/baseSousMarine/baseSaintNazaire.jpeg', 10000);
INSERT INTO site (name, town, description, photo, capacity) VALUES ('Le Théâtre Graslin', 'Nantes', 'Théâtre à l''italienne du XVIIIe siècle à Nantes, réputé pour son acoustique et sa programmation d''opéras et de concerts.', 'upload/sites/photos/theatreNantes/graslinNantes.jpg', 1500);

-- Gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nantes', 'GARE_DE_NANTES', 'upload/gares/plans/GARE_DE_NANTES/gare_nantes.jpg', 'assets/gares/plan_de_gare_NANTES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Angers', 'GARE_DE_ANGERS', 'upload/gares/plans/GARE_DE_ANGERS/gare_de_angers.jpg', 'assets/gares/plan_de_gare_ANGERS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Saint-Nazaire', 'GARE_DE_SAINT_NAZAIRE', 'upload/gares/plans/GARE_DE_SAINT_NAZAIRE/gare_de_saint_nazaire.jpg', 'assets/gares/plan_de_gare_SAINT_NAZAIRE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de La Roche-sur-Yon', 'GARE_DE_LA_ROCHE_SUR_YON', 'upload/gares/plans/GARE_DE_LA_ROCHE_SUR_YON/gare_de_la_Roche.jpg', 'assets/gares/plan_de_gare_LA_ROCHE_SUR_YON.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Cholet', 'GARE_DE_CHOLET', 'upload/gares/plans/GARE_DE_CHOLET/gare_de_cholet.jpg', 'assets/gares/plan_de_gare_CHOLET.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Les Sables-d''Olonne', 'GARE_DE_SABLES', 'upload/gares/plans/GARE_DE_SABLES/gare_des_sables.png', 'assets/gares/plan_de_gare_SABLES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de La Baule', 'GARE_DE_LA_BAULE', 'upload/gares/plans/GARE_DE_LA_BAULE/gare_de_la_baule-escoublac.jpg', 'assets/gares/plan_de_gare_LA_BAULE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare d''Ancenis', 'GARE_DE_ANCENIS', 'upload/gares/plans/GARE_DE_ANCENIS/gare_de_ancenis.jpg', 'assets/gares/plan_de_gare_ANCENIS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Pays de la Loire'));

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
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Parc des Expositions de Rennes', 'Rennes', 'Egalement connu sous le nom de Rennes Parc Expo, est un vaste complexe événementiel situé à Bruz, au sud-ouest de Rennes. Il s''étend sur une superficie totale de 110 000 m²,répartis en 11 halls modulables.','upload/sites/photos/expoRennes/parc-expo-rennes-3_2496.webp', 50000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Le Liberté', 'Rennes', 'Le Liberté est la principale salle de spectacles de Rennes, située entre l''Esplanade Charles de Gaulle et le boulevard de la Liberté. Ce lieu emblématique est conçu pour accueillir une variété d''événements culturels et sportifs.', 'upload/sites/photos/liberté/liberte-Rennes.jpeg',7000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Presqu''île de Crozon', 'Crozon', 'a Presqu ''île de Crozon, située dans le Finistère en Bretagne, est réputée pour ses paysages époustouflants et sa riche vie culturelle. Tout au long de l''année,de nombreux événements et festivals y sont organisés,attirant habitants et visiteurs.','upload/sites/photos/crozon/crozon.jpeg', 60000);
INSERT INTO site (name, town, description, photo, capacity) VALUES ('Port de Paimpol', 'Paimpol', 'Entouré de charmantes rues pavées, de maisons traditionnelles en pierre et de commerces locaux, offrant une atmosphère authentique. Les quais sont animés par le va-et-vient des bateaux de pêche et de plaisance, créant une ambiance maritime unique.','upload/sites/photos/paimpol/paimpol.jpg', 100000);

-- Insertion des gares
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Rennes', 'GARE_DE_RENNES', 'upload/gares/plans/GARE_DE_RENNES/gare_de_rennes.jpg', 'assets/gares/plan_de_gare_RENNES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));

INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Lorient', 'GARE_DE_LORIENT', 'upload/gares/plans/GARE_DE_LORIENT/gare_de_lorient.jpg', 'assets/gares/plan_de_gare_LORIENT.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Quimper', 'GARE_DE_QUIMPER', 'upload/gares/plans/GARE_DE_QUIMPER/gare_de_quimper.jpg', 'assets/gares/plan_de_gare_QUIMPER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Bretagne'));

-- Insertion des événements
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival du Bout du Monde', '2025-08-01 00:00:00', '2025-08-04 00:00:00', 'Festival culturel et musical.', 60000, (SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival du Chant de Marin', '2025-07-06 00:00:00', '2025-07-10 00:00:00', 'Festival maritime à Paimpol.', 100000, (SELECT id FROM site WHERE name = 'Port de Paimpol'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert au Liberté', '2025-06-15 00:00:00', '2025-06-15 22:00:00', 'Concert de musique.', 50000, (SELECT id FROM site WHERE name = 'Le Liberté'), (SELECT id FROM category WHERE name = 'Musique'));

-- Associations entre sites et gares
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Parc des Expositions de Rennes'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Le Liberté'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));

INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Presqu''île de Crozon'), (SELECT id FROM gare WHERE name = 'Gare de Quimper'));
INSERT INTO site_gare (site_id, gare_id) VALUES ((SELECT id FROM site WHERE name = 'Port de Paimpol'), (SELECT id FROM gare WHERE name = 'Gare de Lorient'));

-- Insertion des sites pour la région Occitanie
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Parc des Expositions de Toulouse', 'Toulouse', 'Situé à Aussonne, au nord-ouest de Toulouse, il s''étend sur 55 hectares et propose des infrastructures modernes et modulables pour accueillir une variété d''événements professionnels et grand public.','upload/sites/photos/expoToulouse/expo-Toulouse.jpg', 70000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Plage de Palavas', 'Palavas-les-Flots', 'Située sur la côte méditerranéenne, est un lieu prisé pour l''organisation de divers événements tout au long de l''année. Son cadre idyllique de sable fin et ses infrastructures adaptées en font un site événementiel de choix.', 'upload/sites/photos/palavas/palavas.jpg',30000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Zénith Sud', 'Montpellier', 'Salle de concert modulable à Montpellier, pouvant accueillir jusqu''à 6 300 spectateurs pour divers événements culturels.','upload/sites/photos/zenithSud/zenith-de-face-2-4.jpg', 12000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Aéroport de Toulouse-Blagnac', 'Toulouse', 'Espace unique pouvant accueillir divers événements professionnels et grand public. Grâce à ses infrastructures modernes l''aéroport offre un cadre original et prestigieux pour des manifestations de grande envergure..', 'upload/sites/photos/aeroport toulouse/aeroport-toulouse.jpeg',25000);
INSERT INTO site (name, town, description, photo,capacity) VALUES ('Place du Capitole', 'Toulouse', 'Située au cœur de Toulouse, est un lieu emblématique qui sert de cadre à de nombreux événements culturels, festifs et commémoratifs. Son vaste espace piétonnier et son architecture majestueuse en font un site privilégié pour les rassemblements publics.', 'upload/sites/photos/capitole/capitole.jpeg',10000);
INSERT INTO site (name, town, description,photo, capacity) VALUES ('Arena de Nîmes', 'Nîmes', 'Edifiées à la fin du Ier siècle, sont l''un des amphithéâtres romains les mieux conservés au monde. Situées au cœur de Nîmes, dans le département du Gard, elles témoignent de l''architecture et de l''ingénierie romaines.','upload/sites/photos/nimes/arenesNimes.jpeg', 16000);
-- Insertion des gares pour la région Occitanie
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Toulouse', 'GARE_DE_TOULOUSE', 'upload/gares/plans/GARE_DE_TOULOUSE/gare_de_toulouse.jpg', 'assets/gares/plan_de_gare_TOULOUSE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Montpellier','GARE_DE_MONTPELLIER', 'upload/gares/plans/GARE_DE_MONTPELLIER/gare_de_montpellier.jpg', 'assets/gares/plan_de_gare_MONTPELLIER.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Nîmes', 'GARE_DE_NIMES', 'upload/gares/plans/GARE_DE_NIMES/gare_de_nimes.jpg', 'assets/gares/plan_de_gare_NIMES.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));


INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Béziers', 'GARE_DE_BEZIERS', 'upload/gares/plans/GARE_DE_BEZIERS/gare_de_beziers.jpg', 'assets/gares/plan_de_gare_BEZIERS.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));
INSERT INTO gare (name, code, plan_de_gare, plan_de_gare_svg, accessibilite, region_id) VALUES ('Gare de Mende', 'GARE_DE_MENDE', 'upload/gares/plans/GARE_DE_MENDE/gare_de_mende.jpg', 'assets/gares/plan_de_gare_MENDE.svg', 'Accessible', (SELECT id FROM region WHERE name = 'Occitanie'));

-- Insertion des événements pour la région Occitanie
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival de Toulouse', '2025-07-10 00:00:00', '2025-07-12 00:00:00', 'Festival culturel et musical.', 70000, (SELECT id FROM site WHERE name = 'Parc des Expositions de Toulouse'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Palavas', '2025-08-05 00:00:00', '2025-08-07 00:00:00', 'Festival en bord de mer.', 30000, (SELECT id FROM site WHERE name = 'Plage de Palavas'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert au Zénith Sud', '2025-06-20 19:00:00', '2025-06-20 22:00:00', 'Concert rock au Zénith.', 12000, (SELECT id FROM site WHERE name = 'Zénith Sud'), (SELECT id FROM category WHERE name = 'Musique'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Festival Aérien Toulouse', '2025-08-15 00:00:00', '2025-08-16 00:00:00', 'Festival aérien à Toulouse.', 25000, (SELECT id FROM site WHERE name = 'Aéroport de Toulouse-Blagnac'), (SELECT id FROM category WHERE name = 'Culture'));
INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert Place du Capitole', '2025-07-01 17:00:00', '2025-07-01 23:00:00', 'Concert en plein air sur la place du Capitole.', 10000, (SELECT id FROM site WHERE name = 'Place du Capitole'), (SELECT id FROM category WHERE name = 'Musique'));

INSERT INTO event (name, start_event, end_event, description, nb_people_expected, site_id, category_id) VALUES ('Concert Arena de Nîmes', '2025-07-14 14:00:00', '2025-07-14 23:00:00', 'Concert de musique classique à l''Arena de Nîmes.', 16000, (SELECT id FROM site WHERE name = 'Arena de Nîmes'), (SELECT id FROM category WHERE name = 'Musique'));

-- Insertion des associations gare et site
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Toulouse'), (SELECT id FROM site WHERE name = 'Parc des Expositions de Toulouse'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Toulouse'), (SELECT id FROM site WHERE name = 'Aéroport de Toulouse-Blagnac'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Montpellier'), (SELECT id FROM site WHERE name = 'Zénith Sud'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Toulouse'), (SELECT id FROM site WHERE name = 'Place du Capitole'));
INSERT INTO site_gare (gare_id, site_id) VALUES ((SELECT id FROM gare WHERE name = 'Gare de Béziers'), (SELECT id FROM site WHERE name = 'Arena de Nîmes'));



-- Pays de la Loire
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de Nantes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare d''Angers'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare d''Angers'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de Saint-Nazaire'));

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare de Saint-Nazaire'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de La Roche-sur-Yon'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare de La Roche-sur-Yon'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de Cholet'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare de Cholet'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de Les Sables-d''Olonne'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare de Les Sables-d''Olonne'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare de La Baule'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare de La Baule'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Pays de la Loire'), (SELECT id FROM gare WHERE name = 'Gare d''Ancenis'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name ='Gare d''Ancenis'));

-- Bretagne
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Bretagne'), (SELECT id FROM gare WHERE name = 'Gare de Rennes'));




INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Lorient'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Bretagne'), (SELECT id FROM gare WHERE name = 'Gare de Lorient'));

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Quimper'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Bretagne'), (SELECT id FROM gare WHERE name = 'Gare de Quimper'));

-- Occitanie

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Toulouse'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Occitanie'), (SELECT id FROM gare WHERE name = 'Gare de Toulouse'));

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Montpellier'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Occitanie'), (SELECT id FROM gare WHERE name = 'Gare de Montpellier'));

INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TGV'), (SELECT id FROM gare WHERE name = 'Gare de Nîmes'));
INSERT INTO ligne_gare (ligne_id, gare_id) VALUES ((SELECT id FROM ligne WHERE name = 'TER Occitanie'), (SELECT id FROM gare WHERE name = 'Gare de Nîmes'));





INSERT INTO date_calendar(date, day_of_month, month_name_abbr, day_name, day_name_abbr, month_name, year) SELECT datum AS date, EXTRACT(DAY FROM datum) AS day_of_month, TO_CHAR(datum,'Mon') AS month_name_abbr, TO_CHAR(datum,'Day') AS day_name, TO_CHAR(datum,'Dy') AS day_name_abbr, TO_CHAR(datum,'Month') AS month_name, EXTRACT(year FROM datum) "Year" FROM generate_series(DATE '2025-01-01',DATE '2025-12-31',INTERVAL '1 hour') as datum;

INSERT INTO public.affluence(affluence_habituelle_down, affluence_habituelle_up, date_calendar_date_id, estimation_down, estimation_up, gare_id) SELECT floor(random() * 250 + 50)::int AS affluence_habituelle_down,floor(random() * 250 + 50)::int AS affluence_habituelle_up,calendar.date_id AS date_calendar_date_id,floor(random() * 250 + 50)::int AS estimation_down,floor(random() * 250 + 50)::int AS estimation_up,gareAt.id AS gare_id FROM (SELECT id FROM public.gare) AS gareAt CROSS JOIN (SELECT date_id FROM public.date_calendar ) AS calendar


--Ligne
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

INSERT INTO region (name) VALUES ('Provence-Alpes-Côte d\'Azur');

INSERT INTO ligne (name, code) VALUES ('RER A', 'A');
INSERT INTO ligne (name, code) VALUES ('RER B', 'B');
INSERT INTO ligne (name, code) VALUES ('RER C', 'C');
INSERT INTO ligne (name, code) VALUES ('RER D', 'D');
INSERT INTO ligne (name, code) VALUES ('RER E', 'E');
INSERT INTO ligne (name, code) VALUES ('Ligne H', 'H');
INSERT INTO ligne (name, code) VALUES ('Ligne J', 'J');
INSERT INTO ligne (name, code) VALUES ('Ligne K', 'K');
INSERT INTO ligne (name, code) VALUES ('Ligne L', 'L');
INSERT INTO ligne (name, code) VALUES ('Ligne N', 'N');
INSERT INTO ligne (name, code) VALUES ('Ligne P', 'P');
INSERT INTO ligne (name, code) VALUES ('Ligne R', 'R');
INSERT INTO ligne (name, code) VALUES ('Ligne U', 'U');
INSERT INTO ligne (name, code) VALUES ('Ligne T11', 'T11');

--Gare
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Avenue Foch', 'AVENUE_FOCH', '6462', 'assets/gares/6462_plan_de_gare_AVENUE_FOCH.jpg', 'assets/gares/6462_plan_de_gare_AVENUE_FOCH.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Aéroport Charles de Gaulle 1', 'AEROPORT_CHARLES_DE_GAULLE_1', '6243', 'assets/gares/6243_plan_de_gare_AEROPORT_CHARLES_DE_GAULLE_1.jpg', 'assets/gares/6243_plan_de_gare_AEROPORT_CHARLES_DE_GAULLE_1.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Aéroport Charles de Gaulle 2', 'AEROPORT_CHARLES_DE_GAULLE_2', '6244', 'assets/gares/6244_plan_de_gare_AEROPORT_CHARLES_DE_GAULLE_2.jpg', 'assets/gares/6244_plan_de_gare_AEROPORT_CHARLES_DE_GAULLE_2.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Bibliothèque Francois Mitterrand', 'BIBLIOTHEQUE_FRANCOIS_MITTERRAND', '6451', 'assets/gares/6451_plan_de_gare_BIBLIOTHEQUE_FRANCOIS_MITTERRAND.jpg', 'assets/gares/6451_plan_de_gare_BIBLIOTHEQUE_FRANCOIS_MITTERRAND.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Champ de Mars', 'CHAMP_DE_MARS', '6458', 'assets/gares/6458_plan_de_gare_CHAMP_DE_MARS.jpg', 'assets/gares/6458_plan_de_gare_CHAMP_DE_MARS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Chelles - Gournay', 'CHELLES_GOURNAY', '6814', 'assets/gares/6814_plan_de_gare_CHELLES_GOURNAY.jpg', 'assets/gares/6814_plan_de_gare_CHELLES_GOURNAY.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Dugny - La Courneuve', 'DUGNY_LA_COURNEUVE', '7805', 'assets/gares/7805_plan_de_gare_DUGNY_LA_COURNEUVE.jpg', 'assets/gares/7805_plan_de_gare_DUGNY_LA_COURNEUVE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Haussmann Saint-Lazare', 'HAUSSMANN_SAINT_LAZARE', '6823', 'assets/gares/6823_plan_de_gare_HAUSSMANN_SAINT_LAZARE.jpg', 'assets/gares/6823_plan_de_gare_HAUSSMANN_SAINT_LAZARE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Invalides', 'INVALIDES', '6456', 'assets/gares/6456_plan_de_gare_INVALIDES.jpg', 'assets/gares/6456_plan_de_gare_INVALIDES.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Javel', 'JAVEL', '6479', 'assets/gares/6479_plan_de_gare_JAVEL.jpg', 'assets/gares/6479_plan_de_gare_JAVEL.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('La Grande Arche de la Défense', 'LA_GRANDE_ARCHE_DE_LA_DEFENSE', '6028', 'assets/gares/6028_plan_de_gare_LA_GRANDE_ARCHE_DE_LA_DEFENSE.jpg', 'assets/gares/6028_plan_de_gare_LA_GRANDE_ARCHE_DE_LA_DEFENSE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('La Plaine Stade de France', 'LA_PLAINE_STADE_DE_FRANCE', '6233', 'assets/gares/6233_plan_de_gare_LA_PLAINE_STADE_DE_FRANCE.jpg', 'assets/gares/6233_plan_de_gare_LA_PLAINE_STADE_DE_FRANCE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Le Bourget', 'LE_BOURGET', '6235', 'assets/gares/6235_plan_de_gare_LE_BOURGET.jpg', 'assets/gares/6235_plan_de_gare_LE_BOURGET.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Le Stade', 'LE_STADE', '7207', 'assets/gares/7207_plan_de_gare_LE_STADE.jpg', 'assets/gares/7207_plan_de_gare_LE_STADE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Magenta', 'MAGENTA', '6822', 'assets/gares/6822_plan_de_gare_MAGENTA.jpg', 'assets/gares/6822_plan_de_gare_MAGENTA.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Massy-Palaiseau', 'MASSY_PALAISEAU', '6431', 'assets/gares/6431_plan_de_gare_MASSY_PALAISEAU.jpg', 'assets/gares/6431_plan_de_gare_MASSY_PALAISEAU.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Musée d''Orsay', 'MUSEE_D_ORSAY', '6455', 'assets/gares/6455_plan_de_gare_MUSEE_D_ORSAY.jpg', 'assets/gares/6455_plan_de_gare_MUSEE_D_ORSAY.svg', 'Accessible sauf UFR');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Nanterre la Folie', 'NANTERRE_LA_FOLIE', '6825', 'assets/gares/6825_plan_de_gare_NANTERRE_LA_FOLIE.jpg', 'assets/gares/6825_plan_de_gare_NANTERRE_LA_FOLIE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Pantin', 'PANTIN', '6820', 'assets/gares/6820_plan_de_gare_PANTIN.jpg', 'assets/gares/6820_plan_de_gare_PANTIN.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Parc des Expositions', 'PARC_DES_EXPOSITIONS', '6241', 'assets/gares/6241_plan_de_gare_PARC_DES_EXPOSITIONS.jpg', 'assets/gares/6241_plan_de_gare_PARC_DES_EXPOSITIONS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Austerlitz', 'PARIS_AUSTERLITZ', '6453', 'assets/gares/6453_plan_de_gare_PARIS_AUSTERLITZ.jpg', 'assets/gares/6453_plan_de_gare_PARIS_AUSTERLITZ.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Est', 'PARIS_EST', '7601', 'assets/gares/7601_plan_de_gare_PARIS_EST.jpg', 'assets/gares/7601_plan_de_gare_PARIS_EST.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Gare de Lyon', 'PARIS_GARE_DE_LYON', '6024', 'assets/gares/6024_plan_de_gare_PARIS_GARE_DE_LYON.jpg', 'assets/gares/6024_plan_de_gare_PARIS_GARE_DE_LYON.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Gare du Nord', 'PARIS_GARE_DU_NORD', '6648', 'assets/gares/6648_plan_de_gare_PARIS_GARE_DU_NORD.jpg', 'assets/gares/6648_plan_de_gare_PARIS_GARE_DU_NORD.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Montparnasse', 'PARIS_MONTPARNASSE', '7501', 'assets/gares/7501_plan_de_gare_PARIS_MONTPARNASSE.jpg', 'assets/gares/7501_plan_de_gare_PARIS_MONTPARNASSE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Paris Saint-Lazare', 'PARIS_SAINT_LAZARE', '7201', 'assets/gares/7201_plan_de_gare_PARIS_SAINT_LAZARE.jpg', 'assets/gares/7201_plan_de_gare_PARIS_SAINT_LAZARE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Pont de l''Alma', 'PONT_DE_L_ALMA', '6457', 'assets/gares/6457_plan_de_gare_PONT_DE_L_ALMA.jpg', 'assets/gares/6457_plan_de_gare_PONT_DE_L_ALMA.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Pont du Garigliano', 'PONT_DU_GARIGLIANO', '6480', 'assets/gares/6480_plan_de_gare_PONT_DU_GARIGLIANO.jpg', 'assets/gares/6480_plan_de_gare_PONT_DU_GARIGLIANO.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Rosa Parks', 'ROSA_PARKS', '6821', 'assets/gares/6821_plan_de_gare_ROSA_PARKS.jpg', 'assets/gares/6821_plan_de_gare_ROSA_PARKS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Saint-Denis', 'SAINT_DENIS', '6650', 'assets/gares/6650_plan_de_gare_SAINT_DENIS.jpg', 'assets/gares/6650_plan_de_gare_SAINT_DENIS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Saint-Michel Notre-Dame', 'SAINT_MICHEL_NOTRE_DAME', '6454', 'assets/gares/6454_plan_de_gare_SAINT_MICHEL_NOTRE_DAME.jpg', 'assets/gares/6454_plan_de_gare_SAINT_MICHEL_NOTRE_DAME.svg', 'Accessible sauf UFR');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Saint-Quentin en Yvelines', 'SAINT_QUENTIN_EN_YVELINES', '7528', 'assets/gares/7528_plan_de_gare_SAINT_QUENTIN_EN_YVELINES.jpg', 'assets/gares/7528_plan_de_gare_SAINT_QUENTIN_EN_YVELINES.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Stade de France Saint-Denis', 'STADE_DE_FRANCE_SAINT_DENIS', '6649', 'assets/gares/6649_plan_de_gare_STADE_DE_FRANCE_SAINT_DENIS.jpg', 'assets/gares/6649_plan_de_gare_STADE_DE_FRANCE_SAINT_DENIS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Vaires - Torcy', 'VAIRES_TORCY', '7609', 'assets/gares/7609_plan_de_gare_VAIRES_TORCY.jpg', 'assets/gares/7609_plan_de_gare_VAIRES_TORCY.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Versailles Chantiers', 'VERSAILLES_CHANTIERS', '7509', 'assets/gares/7509_plan_de_gare_VERSAILLES_CHANTIERS.jpg', 'assets/gares/7509_plan_de_gare_VERSAILLES_CHANTIERS.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Versailles Château Rive Gauche', 'VERSAILLES_CHATEAU_RIVE_GAUCHE', '6487', 'assets/gares/6487_plan_de_gare_VERSAILLES_CHATEAU_RIVE_GAUCHE.jpg', 'assets/gares/6487_plan_de_gare_VERSAILLES_CHATEAU_RIVE_GAUCHE.svg', 'Accessible avec assistance');
INSERT INTO gare (name, code, id_gare_idfm, plan_de_gare, plan_de_gare_svg, accessibilite) VALUES ('Versailles Rive Droite', 'VERSAILLES_RIVE_DROITE', '7336', 'assets/gares/7336_plan_de_gare_VERSAILLES_RIVE_DROITE.jpg', 'assets/gares/7336_plan_de_gare_VERSAILLES_RIVE_DROITE.svg', 'Accessible avec assistance');

--LigneGare
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Avenue Foch' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Aéroport Charles de Gaulle 1' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Aéroport Charles de Gaulle 2' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Bibliothèque Francois Mitterrand' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Bibliothèque Francois Mitterrand' AND l.code = 'M14';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Champ de Mars' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Chelles - Gournay' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Chelles - Gournay' AND l.code = 'P';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Dugny - La Courneuve' AND l.code = 'T11';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'J';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'L';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'M3';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'M12';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'M13';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Haussmann Saint-Lazare' AND l.code = 'M14';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Invalides' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Invalides' AND l.code = 'M8';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Invalides' AND l.code = 'M13';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Javel' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'A';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'L';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'U';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'T2';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Grande Arche de la Défense' AND l.code = 'M1';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'La Plaine Stade de France' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Le Bourget' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Le Bourget' AND l.code = 'T11';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Le Stade' AND l.code = 'J';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'D';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'H';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'K';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'M4';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Magenta' AND l.code = 'M5';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Massy-Palaiseau' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Massy-Palaiseau' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Massy-Palaiseau' AND l.code = 'T12';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Musée d''Orsay' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Nanterre la Folie' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Pantin' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Parc des Expositions' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Austerlitz' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Austerlitz' AND l.code = 'M5';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Austerlitz' AND l.code = 'M10';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Est' AND l.code = 'P';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Est' AND l.code = 'M4';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Est' AND l.code = 'M5';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Est' AND l.code = 'M7';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare de Lyon' AND l.code = 'A';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare de Lyon' AND l.code = 'D';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare de Lyon' AND l.code = 'R';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare de Lyon' AND l.code = 'M1';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare de Lyon' AND l.code = 'M14';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'D';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'H';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'K';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'M2';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'M4';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Gare du Nord' AND l.code = 'M5';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Montparnasse' AND l.code = 'N';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Montparnasse' AND l.code = 'M4';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Montparnasse' AND l.code = 'M6';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Montparnasse' AND l.code = 'M12';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Montparnasse' AND l.code = 'M13';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'J';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'L';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'M3';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'M12';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'M13';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Paris Saint-Lazare' AND l.code = 'M14';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Pont de l''Alma' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Pont du Garigliano' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Pont du Garigliano' AND l.code = 'T3A';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Rosa Parks' AND l.code = 'E';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Rosa Parks' AND l.code = 'T3B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Denis' AND l.code = 'D';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Denis' AND l.code = 'H';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Denis' AND l.code = 'T1';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Denis' AND l.code = 'T8';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Michel Notre-Dame' AND l.code = 'B';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Michel Notre-Dame' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Michel Notre-Dame' AND l.code = 'M4';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Michel Notre-Dame' AND l.code = 'M10';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Quentin en Yvelines' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Quentin en Yvelines' AND l.code = 'N';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Saint-Quentin en Yvelines' AND l.code = 'U';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Stade de France Saint-Denis' AND l.code = 'D';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Vaires - Torcy' AND l.code = 'P';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Versailles Chantiers' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Versailles Chantiers' AND l.code = 'N';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Versailles Chantiers' AND l.code = 'U';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Versailles Château Rive Gauche' AND l.code = 'C';
INSERT INTO ligne_gare (gare_id, ligne_id) SELECT g.id, l.id FROM gare g, ligne l WHERE g.name = 'Versailles Rive Droite' AND l.code = 'L';



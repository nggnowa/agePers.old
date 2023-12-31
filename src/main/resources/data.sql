INSERT INTO public.region(	id, code, nom)
VALUES  (1,'AD','Adamaoua'),
        (2,'CE','Centre'),
        (3,'EN','Extrême-Nord'),
        (4,'ES','Est'),
        (5,'LT','Littoral'),
        (6,'NO','Nord'),
        (7,'NW','Nord-Ouest'),
        (8,'OU','Ouest'),
        (9,'SU','Sud'),
        (10,'SW','Sud-Ouest');

INSERT INTO public.departement(	id, region_id, nom)
VALUES 	(1, 1,'Djérem'),
        (2, 1,'Faro-et-Déo'),
        (3, 1,'Mayo-Banyo'),
        (4, 1,'Mbéré'),
        (5, 1,'Vina'),
        (6, 2,'Haute-Sanaga'),
        (7, 2,'Lekié'),
        (8, 2,'Mbam-et-Inoubou'),
        (9, 2,'Mbam-et-Kim'),
        (10, 2,'Méfou-et-Afamba'),
        (11, 2,'Méfou-et-Akono'),
        (12, 2,'Mfoundi'),
        (13, 2,'Nyong-et-Kéllé'),
        (14, 2,'Nyong-et-Mfoumou'),
        (15, 2,'Nyong-et-Soo'),
        (16, 3,'Boumba-et-Ngoko'),
        (17, 3,'Haut-Nyong'),
        (18, 3,'Kadey'),
        (19, 3,'Lom-et-Djérem'),
        (20, 4,'Diamaré'),
        (21, 4,'Logone-et-Chari'),
        (22, 4,'Mayo-Danay'),
        (23, 4,'Mayo-Kani'),
        (24, 4,'Mayo-Sava'),
        (25, 4,'Mayo-Tsanaga'),
        (26, 5,'Moungo'),
        (27, 5,'Nkam'),
        (28, 5,'Sanaga-Maritime'),
        (29, 5,'Wouri'),
        (30, 6,'Bénoué'),
        (31, 6,'Faro'),
        (32, 6,'Mayo-Louti'),
        (33, 6,'Mayo-Rey'),
        (34, 7,'Boyo'),
        (35, 7,'Bui'),
        (36, 7,'Donga-Mantung'),
        (37, 7,'Menchum'),
        (38, 7,'Mezam'),
        (39, 7,'Momo'),
        (40, 7,'Ngo-Ketunjia'),
        (41, 8,'Bamboutos'),
        (42, 8,'Haut-Nkam'),
        (43, 8,'Hauts-Plateaux'),
        (44, 8,'Koung-Khi'),
        (45, 8,'Menoua'),
        (46, 8,'Mifi'),
        (47, 8,'Ndé'),
        (48, 8,'Noun'),
        (49, 9,'Dja-et-Lobo'),
        (50, 9,'Mvila'),
        (51, 9,'Océan'),
        (52, 9,'Vallée-du-Ntem'),
        (53, 10,'Fako'),
        (54, 10,'Koupé-Manengouba'),
        (55, 10,'Lebialem'),
        (56, 10,'Manyu'),
        (57, 10,'Meme'),
        (58, 10,'Ndian');

INSERT INTO public.arrondissement(departement_id, id, nom)
VALUES 	(1, 1,'Ngaoundal'),
        (1, 2,'Tibati'),
        (2, 3,'Galim-tignere'),
        (2, 4,'Kontcha'),
        (2, 5,'Mayo-baleo'),
        (2, 6,'Tignere'),
        (3, 7,'Bankim'),
        (3, 8,'Banyo'),
        (3, 9,'Mayo-darle'),
        (4, 10,'Dir'),
        (4, 11,'Djohong'),
        (4, 12,'Meiganga'),
        (4, 13,'Ngaoui'),
        (5, 14,'Belel'),
        (5, 15,'Martap'),
        (5, 16,'Mbe'),
        (5, 17,'Ngan-ha'),
        (5, 18,'Ngaoundere 1er'),
        (5, 19,'Ngaoundere 2e'),
        (5, 20,'Ngaoundere 3e'),
        (5, 21,'Nyambaka'),
        (6, 22,'Bibey'),
        (6, 23,'Lembe-yezoum'),
        (6, 24,'Mbandjock'),
        (6, 25,'Minta'),
        (6, 26,'Nanga-eboko'),
        (6, 27,'Nkoteng'),
        (6, 28,'Nsem'),
        (7, 29,'Batschenga'),
        (7, 30,'Ebebda'),
        (7, 31,'Elig-mfomo'),
        (7, 32,'Evodoula'),
        (7, 33,'Lobo'),
        (7, 34,'Monatele'),
        (7, 35,'Obala'),
        (7, 36,'Okola'),
        (7, 37,'Sa a'),
        (8, 38,'Bafia'),
        (8, 39,'Bokito'),
        (8, 40,'Deuk'),
        (8, 41,'Kiiki'),
        (8, 42,'Kon-yambetta'),
        (8, 43,'Makenene'),
        (8, 44,'Ndikinimeki'),
        (8, 45,'Nitoukou'),
        (8, 46,'Ombessa'),
        (9, 47,'Mbangassina'),
        (9, 48,'Ngambe-tikar'),
        (9, 49,'Ngoro'),
        (9, 50,'Ntui'),
        (9, 51,'Yoko'),
        (10, 52,'Afanloum'),
        (10, 53,'Assamba'),
        (10, 54,'Awae'),
        (10, 55,'Edzendouan'),
        (10, 56,'Esse'),
        (10, 57,'Mfou'),
        (10, 58,'Nkolafamba'),
        (10, 59,'Soa'),
        (11, 60,'Ngoumou'),
        (11, 61,'Akono'),
        (11, 62,'Mbankomo'),
        (11, 63,'Bikok'),
        (12, 64,'Yaounde i'),
        (12, 65,'Yaounde ii'),
        (12, 66,'Yaounde iii'),
        (12, 67,'Yaounde iv'),
        (12, 68,'Yaounde v'),
        (12, 69,'Yaounde vi'),
        (12, 70,'Yaounde vii'),
        (13, 71,'Biyouha'),
        (13, 72,'Bondjock'),
        (13, 73,'Bot-makak'),
        (13, 74,'Dibang'),
        (13, 75,'Eseka'),
        (13, 76,'Makak'),
        (13, 77,'Matomb'),
        (13, 78,'Messondo'),
        (13, 79,'Ngog-mapubi'),
        (13, 80,'Nguibassal'),
        (14, 81,'Akoeman'),
        (14, 82,'Akonolinga'),
        (14, 83,'Ayos'),
        (14, 84,'Endom'),
        (14, 85,'Mengang'),
        (14, 86,'Yakokombo'),
        (15, 87,'Dzeng'),
        (15, 88,'Mbalmayo'),
        (15, 89,'Mengueme'),
        (15, 90,'Ngomedzap'),
        (15, 91,'Nkol-metet'),
        (16, 92,'Gari-gombo'),
        (16, 93,'Moloundou'),
        (16, 94,'Salapoumbe'),
        (16, 95,'Yokadouma'),
        (17, 96,'Abong-mbang'),
        (17, 97,'Bebend'),
        (17, 98,'Dimako'),
        (17, 99,'Dja'),
        (17, 100,'Doumaintang'),
        (17, 101,'Doume'),
        (17, 102,'Lomie'),
        (17, 103,'Mboma'),
        (17, 104,'Mbouanz'),
        (17, 105,'Messamena'),
        (17, 106,'Messok'),
        (17, 107,'Ngoyla'),
        (17, 108,'Nguelemendouka'),
        (17, 109,'Samalomo'),
        (18, 110,'Batouri'),
        (18, 111,'Bombe'),
        (18, 112,'Kette'),
        (18, 113,'Mbang'),
        (18, 114,'Mbotoro'),
        (18, 115,'Ndelele'),
        (18, 116,'Ndem-nam'),
        (19, 117,'Belabo'),
        (19, 118,'Bertoua 1er'),
        (19, 119,'Bertoua 2e'),
        (19, 120,'Betare-oya '),
        (19, 121,'Diang'),
        (19, 122,'Garoua-boulaï'),
        (19, 123,'Mandjou'),
        (19, 124,'Ngoura'),
        (20, 125,'Bogo '),
        (20, 126,'Dargala'),
        (20, 127,'Gazawa'),
        (20, 128,'Maroua 1er '),
        (20, 129,'Maroua 2e'),
        (20, 130,'Maroua 3e'),
        (20, 131,'Meri'),
        (20, 132,'Ndoukoula'),
        (20, 133,'Pette'),
        (21, 134,'Blangoua'),
        (21, 135,'Darak'),
        (21, 136,'Fotokol'),
        (21, 137,'Goulfey'),
        (21, 138,'Hile-halifa'),
        (21, 139,'Kousseri'),
        (21, 140,'Logone-birni'),
        (21, 141,'Makary'),
        (21, 142,'Waza'),
        (21, 143,'Zina'),
        (22, 144,'Datcheka'),
        (22, 145,'Gobo'),
        (22, 146,'Guere'),
        (22, 147,'Kaï-kaï'),
        (22, 148,'Kalfou'),
        (22, 149,'Kar-hay'),
        (22, 150,'Maga'),
        (22, 151,'Tchatibali'),
        (22, 152,'Vele'),
        (22, 153,'Wina'),
        (22, 154,'Yagoua'),
        (23, 155,'Guidiguis'),
        (23, 156,'Kaele'),
        (23, 157,'Mindif'),
        (23, 158,'Moulvoudaye'),
        (23, 159,'Moutourwa'),
        (23, 160,'Porhi'),
        (23, 161,'Taibong'),
        (24, 162,'Kolofata'),
        (24, 163,'Mora'),
        (24, 164,'Tokombere'),
        (25, 165,'Bourrha'),
        (25, 166,'Hina'),
        (25, 167,'Koza'),
        (25, 168,'Mayo-maskota'),
        (25, 169,'Mogode'),
        (25, 170,'Mokolo'),
        (25, 171,'Soulede-roua'),
        (26, 172,'Bare-bakem'),
        (26, 173,'Dibombari '),
        (26, 174,'Fiko'),
        (26, 175,'Loum'),
        (26, 176,'Manjo'),
        (26, 177,'Mbanga '),
        (26, 178,'Melong'),
        (26, 179,'Mombo'),
        (26, 180,'Njombe-penja'),
        (26, 181,'Nkongsamba 1er'),
        (26, 182,'Nkongsamba 2e'),
        (26, 183,'Nkongsamba 3e'),
        (26, 184,'Nlonako'),
        (27, 185,'Nkondjock '),
        (27, 186,'Nord-makombe'),
        (27, 187,'Yabassi'),
        (27, 188,'Yingui'),
        (28, 189,'Dibamba'),
        (28, 190,'Dizangue'),
        (28, 191,'Edea 1er'),
        (28, 192,'Edea 2e'),
        (28, 193,'Massock-songloulou'),
        (28, 194,'Mouanko'),
        (28, 195,'Ndom '),
        (28, 196,'Ngambe '),
        (28, 197,'Ngwei'),
        (28, 198,'Nyanon'),
        (28, 199,'Pouma'),
        (29, 200,'Douala 1er'),
        (29, 201,'Douala 2e'),
        (29, 202,'Douala 3e'),
        (29, 203,'Douala 4e'),
        (29, 204,'Douala 5e'),
        (29, 205,'Douala 6'),
        (30, 206,'Bascheo'),
        (30, 207,'Bibemi'),
        (30, 208,'Dembo'),
        (30, 209,'Demsa'),
        (30, 210,'Garoua 1er '),
        (30, 211,'Garoua 2e'),
        (30, 212,'Garoua 3e'),
        (30, 213,'Lagdo'),
        (30, 214,'Mayo hourna'),
        (30, 215,'Pitoa'),
        (30, 216,'Tcheboa'),
        (30, 217,'Touroua'),
        (31, 218,'Beka'),
        (31, 219,'Poli'),
        (32, 220,'Figuil'),
        (32, 221,'Guider'),
        (32, 222,'Mayo-oulo'),
        (33, 223,'Madingring'),
        (33, 224,'Rey-bouba'),
        (33, 225,'Tchollire'),
        (33, 226,'Touboro'),
        (34, 227,'Belo'),
        (34, 228,'Bum'),
        (34, 229,'Fundong'),
        (34, 230,'Njinikom'),
        (35, 231,'Jakiri'),
        (35, 232,'Kumbo'),
        (35, 233,'Mbven'),
        (35, 234,'Nkum'),
        (35, 235,'Noni'),
        (35, 236,'Oku'),
        (36, 237,'Ako'),
        (36, 238,'Misaje'),
        (36, 239,'Ndu'),
        (36, 240,'Nkambe'),
        (36, 241,'Nwa'),
        (37, 242,'Fungom'),
        (37, 243,'Furu-awa'),
        (37, 244,'Menchum valley'),
        (37, 245,'Wum'),
        (38, 246,'Bafut'),
        (38, 247,'Bali'),
        (38, 248,'Bamenda 1er'),
        (38, 249,'Bamenda 2e'),
        (38, 250,'Bamenda 3e'),
        (38, 251,'Santa'),
        (38, 252,'Tubah'),
        (39, 253,'Batibo'),
        (39, 254,'Mbengwi'),
        (39, 255,'Ngie'),
        (39, 256,'Njikwa'),
        (39, 257,'Widikum-menka'),
        (40, 258,'Babessi'),
        (40, 259,'Balikumbat'),
        (40, 260,'Ndop'),
        (41, 261,'Babadjou'),
        (41, 262,'Batcham'),
        (41, 263,'Galim'),
        (41, 264,'Mbouda'),
        (42, 265,'Bafang'),
        (42, 266,'Bakou'),
        (42, 267,'Bana'),
        (42, 268,'Bandja'),
        (42, 269,'Banka'),
        (42, 270,'Banwa'),
        (42, 271,'Kekem'),
        (43, 272,'Baham'),
        (43, 273,'Bamendjou'),
        (43, 274,'Bangou'),
        (43, 275,'Batie'),
        (44, 276,'Bayangam '),
        (44, 277,'Djebem'),
        (44, 278,'Poumougne'),
        (45, 279,'Dschang'),
        (45, 280,'Fokoue'),
        (45, 281,'Fongo tongo'),
        (45, 282,'Nkong-ni'),
        (45, 283,'Penka-michel'),
        (45, 284,'Santchou'),
        (46, 285,'Bafoussam 1er'),
        (46, 286,'Bafoussam 2e'),
        (46, 287,'Bafoussam 3e'),
        (47, 288,'Bangangte '),
        (47, 289,'Bassamba'),
        (47, 290,'Bazou'),
        (47, 291,'Tonga'),
        (48, 292,'Bangourain'),
        (48, 293,'Foumban'),
        (48, 294,'Foumbot'),
        (48, 295,'Kouoptamo'),
        (48, 296,'Koutaba'),
        (48, 297,'Magba'),
        (48, 298,'Malentouen'),
        (48, 299,'Massangam'),
        (48, 300,'Njimon'),
        (49, 301,'Bengbis'),
        (49, 302,'Djoum'),
        (49, 303,'Meyomessala'),
        (49, 304,'Meyomessi'),
        (49, 305,'Mintom '),
        (49, 306,'Oveng'),
        (49, 307,'Sangmelima'),
        (49, 308,'Zoetele'),
        (50, 309,'Biwong-bane'),
        (50, 310,'Biwong bulu'),
        (50, 311,'Ebolowa 1er'),
        (50, 312,'Ebolowa 2e'),
        (50, 313,'Efoulan'),
        (50, 314,'Mengong'),
        (50, 315,'Mvangan'),
        (50, 316,'Ngoulemakong'),
        (51, 317,'Akom ii'),
        (51, 318,'Bipindi'),
        (51, 319,'Campo'),
        (51, 320,'Kribi 1er'),
        (51, 321,'Kribi 2e'),
        (51, 322,'Lokoundje'),
        (51, 323,'Lolodorf'),
        (51, 324,'Mvengue'),
        (51, 325,'Niete'),
        (52, 326,'Ambam'),
        (52, 327,'Kye ossi'),
        (52, 328,'Ma an'),
        (52, 329,'Olamze'),
        (53, 330,'Buea'),
        (53, 331,'Limbe 1er'),
        (53, 332,'Limbe 2e'),
        (53, 333,'Limbe 3e'),
        (53, 334,'Muyuka'),
        (53, 335,'Tiko'),
        (53, 336,'West-coast'),
        (54, 337,'Bangem'),
        (54, 338,'Nguti'),
        (54, 339,'Tombel'),
        (55, 340,'Alou'),
        (55, 341,'Fontem'),
        (55, 342,'Wabane'),
        (56, 343,'Akwaya'),
        (56, 344,'Eyumodjock'),
        (56, 345,'Mamfe'),
        (56, 346,'Upper-bayang'),
        (57, 347,'Bonge'),
        (57, 348,'Konye'),
        (57, 349,'Kumba 1er'),
        (57, 350,'Kumba 2e'),
        (57, 351,'Kumba 3e'),
        (58, 352,'Bamusso'),
        (58, 353,'Dikome-balue'),
        (58, 354,'Ekondo-titi '),
        (58, 355,'Idabato'),
        (58, 356,'Isanguele'),
        (58, 357,'Kombo abedimo'),
        (58, 358,'Kombo idinti'),
        (58, 359,'Mundemba'),
        (58, 360,'Toko');

INSERT INTO public.ethnie(id, nom)
VALUES  (1, 'Akpwakoum'),
        (2, 'Akunakuna'),
        (3, 'Arabes choua'),
        (4, 'Babanki'),
        (5, 'Babimbi'),
        (6, 'Babinga'),
        (7, 'Babong'),
        (8, 'Babungo'),
        (9, 'Badjia'),
        (10, 'Badjoué'),
        (11, 'Bafaw'),
        (12, 'Bafeuk'),
        (13, 'Bafia'),
        (14, 'Bafut'),
        (15, 'Baggaras'),
        (16, 'Baka'),
        (17, 'Bakaka'),
        (18, 'Bakoko'),
        (19, 'Bakole'),
        (20, 'Bakossi'),
        (21, 'Bakundu'),
        (22, 'Bakweri'),
        (23, 'Bali'),
        (24, 'Balom'),
        (25, 'Balondo'),
        (26, 'Balong'),
        (27, 'Balue'),
        (28, 'Bamboko'),
        (29, 'Bamilékés'),
        (30, 'Bamouns'),
        (31, 'Bana'),
        (32, 'Banda'),
        (33, 'Bandem'),
        (34, 'Bané'),
        (35, 'Baneka'),
        (36, 'Banen'),
        (37, 'Bangandu'),
        (38, 'Bangoua'),
        (39, 'Bankon'),
        (40, 'Banyang'),
        (41, 'Bapé'),
        (42, 'Baréko'),
        (43, 'Bassa'),
        (44, 'Bata'),
        (45, 'Batanga'),
        (46, 'Batschenga'),
        (47, 'Beti'),
        (48, 'Bidjouki'),
        (49, 'Bikélé'),
        (50, 'Bikok (Bassa)'),
        (51, 'Bima'),
        (52, 'Bobilis'),
        (53, 'Bodiman'),
        (54, 'Boki'),
        (55, 'Bonkeng'),
        (56, 'Boulou'),
        (57, 'Boundjou'),
        (58, 'Buduma'),
        (59, 'Chambas'),
        (60, 'Daba'),
        (61, 'Djanti'),
        (62, 'Djem'),
        (63, 'Djimi'),
        (64, 'Dourou'),
        (65, 'Dowayo'),
        (66, 'Duala'),
        (67, 'Duupa'),
        (68, 'Dzimou'),
        (69, 'Ekoï'),
        (70, 'Etenga'),
        (71, 'Eton'),
        (72, 'Evuzok'),
        (73, 'Ewondo'),
        (74, 'Fali'),
        (75, 'Fang'),
        (76, 'Gamergu'),
        (77, 'Gbaya'),
        (78, 'Gbete'),
        (79, 'Glavda'),
        (80, 'Gude'),
        (81, 'Guemzek'),
        (82, 'Guidar'),
        (83, 'Guiziga'),
        (84, 'Gyele'),
        (85, 'Hidé'),
        (86, 'Igbo'),
        (87, 'Isubu'),
        (88, 'Jukun'),
        (89, 'Kaka'),
        (90, 'Kanouri'),
        (91, 'Kapsiki'),
        (92, 'Kéra'),
        (93, 'Kirdi'),
        (94, 'Kolbila'),
        (95, 'Kom'),
        (96, 'Koma d Adamawa'),
        (97, 'Kombe'),
        (98, 'Konabembe'),
        (99, 'Korup'),
        (100, 'Kotoko'),
        (101, 'Kpe'),
        (102, 'Kwanja'),
        (103, 'Kwele'),
        (104, 'Laga'),
        (105, 'Lemande'),
        (106, 'Likol'),
        (107, 'Limba'),
        (108, 'Mabi'),
        (109, 'Mada'),
        (110, 'Mafa'),
        (111, 'Maka'),
        (112, 'Mambay'),
        (113, 'Mambila'),
        (114, 'Mandara'),
        (115, 'Mandija'),
        (116, 'Manehas'),
        (117, 'Manguissa'),
        (118, 'Mankon'),
        (119, 'Massa'),
        (120, 'Mbembe'),
        (121, 'Mbida-Mbani'),
        (122, 'Mbo'),
        (123, 'Mbonge'),
        (124, 'Mboum'),
        (125, 'Medzan'),
        (126, 'Meta'),
        (127, 'Mfumte'),
        (128, 'Mineo'),
        (129, 'Mofu'),
        (130, 'Mofu-Gudur'),
        (131, 'Mouamenam'),
        (132, 'Mouktélé'),
        (133, 'Moundang'),
        (134, 'Mousgoum'),
        (135, 'Moussey'),
        (136, 'Mouyeng'),
        (137, 'Mpiemo'),
        (138, 'Mumuye'),
        (139, 'Mvaï'),
        (140, 'Mvele'),
        (141, 'Mvog Nyengue'),
        (142, 'Ndog Sul'),
        (143, 'Ndog Tindi'),
        (144, 'Ndowe'),
        (145, 'Ngemba'),
        (146, 'Ngolo'),
        (147, 'Ngoro'),
        (148, 'Ngoumba'),
        (149, 'Nkwen'),
        (150, 'Noni'),
        (151, 'Nsa a'),
        (152, 'Nso'),
        (153, 'Nsungli'),
        (154, 'Ntumu'),
        (155, 'Nyamtan'),
        (156, 'Nyokon'),
        (157, 'Okak'),
        (158, 'Omvang'),
        (159, 'Oroko'),
        (160, 'Ossananga'),
        (161, 'Ouldémé'),
        (162, 'Pere'),
        (163, 'Peuls'),
        (164, 'Podoko'),
        (165, 'Pongo'),
        (166, 'Pygmée'),
        (167, 'Sao (civilisation)'),
        (168, 'Saras'),
        (169, 'Sawa'),
        (170, 'Sso'),
        (171, 'Tikar'),
        (172, 'Tiv'),
        (173, 'Toupouri'),
        (174, 'Tsinga'),
        (175, 'Vamé'),
        (176, 'Vere'),
        (177, 'Vute'),
        (178, 'Wawa'),
        (179, 'Widekum'),
        (180, 'Wodaabes'),
        (181, 'Wum'),
        (182, 'Yabassi'),
        (183, 'Yakalak'),
        (184, 'Yamba'),
        (185, 'Yambassa'),
        (186, 'Yambetta'),
        (187, 'Yebekolo'),
        (188, 'Yelinda'),
        (189, 'Yembama'),
        (190, 'Yengono'),
        (191, 'Yezoum'),
        (192, 'Zulgo');

INSERT INTO public.formation(id, nom)
VALUES  (1, 'Lettres'),
        (2, 'Sciences'),
        (3, 'Sciences de l''Education'),
        (4, 'Sciences Humaines');

INSERT INTO public.discipline(formation_id, id, nom)
VALUES  (1, 1,'Français'),
        (1, 2,'Anglais'),
        (1, 3,'Langue et cultures camerounaises'),
        (1, 4,'Langues étrangères'),
        (1, 5,'Lettres classiques'),
        (2, 6,'Biologie'),
        (2, 7,'Chimie'),
        (2, 8,'Informatique et technologies éducatives'),
        (2, 9,'Mathématiques'),
        (2, 10,'Physique'),
        (3, 11,'Géographie'),
        (3, 12,'Histoire'),
        (3, 13,'Philosophie'),
        (4, 14,'Science de l éducation');

INSERT INTO public.diplome(id, code, nom)
VALUES  (1, 'BAC','Baccalauréat'),
        (2, 'L','Licence'),
        (3, 'M','Master'),
        (4, 'D','Doctorat');

INSERT INTO public.poste(id, rang, titre)
VALUES  (1, 'DIRECTEUR_ADJOINT','Délégué Régional'),
        (2, 'SOUS_DIRECTEUR','Délégué Départemental'),
        (3, 'SOUS_DIRECTEUR','Sous Directeur des Affaires Générales'),
        (4, 'SOUS_DIRECTEUR','Sous Directeur des Examens, des Concours et de la Certification'),
        (5, 'SOUS_DIRECTEUR','Proviseur'),
        (6, 'CHEF_SERVICE','Directeur de CES'),
        (7, 'CHEF_SERVICE','Censeur'),
        (8, 'CHEF_SERVICE','Surveillant Général de lycée'),
        (9, 'CHEF_SERVICE','Intendant'),
        (10, 'CHEF_SERVICE_ADJOINT','Surveillant Général de CES'),
        (11, 'CHEF_SERVICE_ADJOINT','Econome'),
        (12, 'CHEF_SERVICE','Chef de travaux de lycée technique'),
        (13, 'CHEF_SERVICE_ADJOINT','Chef de travaux de CETIC'),
        (14, 'CHEF_BUREAU','Animateur pédagogique'),
        (15, 'CADRE','Enseignant'),
        (16, 'AGENT','Secretaire'),
        (17, 'AGENT','Agent de bureau');
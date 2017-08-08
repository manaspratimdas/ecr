--insert into  PRODUCT(id,NAME , PRICE, WEIGHT) values (1,'Pen',10.10 , 12.00)

 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(1,'ASIA', 'AS');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(2,'Europe', 'EU');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(3,'North America', 'NA');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(4,'South America', 'SA');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(5,'Africa','AF');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(6,'Australia','AUS');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(7,'Antarctica','AN');
 

  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(1,'IN','INDIA','IND',1);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(2,'CH','CHINA','CNN',1);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(3,'US','USA','USA',3);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(4,'CA','CANADA','CAN',3);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(5,'DE','GERMANY','DEU',2);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(6,'FR','FRANCE','FRA',2);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(7,'KE','KENYA','KEN',5);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(8,'UG','UGANDA','UGA',5);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(9,'BR','BRAZIL','BRA',4);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(10,'AR','ARGENTINA','ARG',4);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(11,'NZ','NEWZEALAND','NZL',6);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(12,'NO','NORWAY','NOR',7);
 
 
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(1, 'MARINE LINES', 'MUMBAI', 'LANE PORT', '411235', 1);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(2, '5/F ABCO TRADE CENTRE','MANAGLORE','NH-17, KOTTARA CHOWKI, KARNATKA','33012',1);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(3, '150 MOTOR PARKWAY','MIAMI','SUITE 401','88825',3);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(4, '30/FL., SEAVIEW PLAZA','SHENZHEN, 518067','18 TAIZI ROAD,SHEKOU','88825',2);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(5, 'ROOM 1206, RAFFLES CITY','SHANGHAI','NO 268 XIZANG ROAD MIDDLE','65802',2);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(6, 'FOREIGN TRADE ZONE #61','PUEBLO VIEJO, GUAYNABO','ROAD 165 KM 2.4, BLDG 1 WAREHOUSE 10','00965',3);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(7, '3030 ORLANDO DRIVE','MISSISSAUGA, L4V 1S8, ONTARIO','NO. 1111 LI YANG ROAD','11369',4);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(8, 'WILLY-BRANDT-PLATZ 1','BREMEN 28215','JHONGSHAN DISTRICT','50033',5);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(9, 'MESSBERG 4','HAMBURG  20095','552-566 CASTLE PEAK ROAD','33130',5);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(10, '4 RUE DU CHAPELIER - 95704','ROISSY CDG','SUITE 310','33166',6);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(11, 'PICO 1639-45 STREET','BUENES AIRES   1429','2/F., SUITE B/D','03081',10);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(12, '19 RICHARD PEARSE DRIVE','MANGERE, AUCKLAND','P.O. BOX 53004, AIRPORT OAKS','33178',11);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(13, 'RUA LUIZ SERAPHICO JUNIOR, 511 - 18° ANDAR', 'SAO PAULO  04729-080', 'JARDIM CARAVELAS', '07066', 9);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(14, '7880 CONVOY COURT', 'SAN DIEGO', 'SUITE 205', '91748', 3);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(15, '159, TRANSPORT CENTER', 'NEW DELHI  110035', 'NEAR PUNJABI BAGH FLYOVER', '92111', 1);
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(16, 'ONE INDUSTRIAL PLAZA', 'VALLEY STREAM', 'BLDG. C', '11581', 2);
 
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(1,'SYSTEM LINERS',1);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(2,'APOC',2);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(3,'TCS',3);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(4,'CTS',4);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(5,'Procom Services',7);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(6,'Sonango',5);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(7,'Sinopec',6);
 
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(1,'INKTR','Kathinhar','235716253761.9','798273498273.8',1);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(2,'INPHB','Phulbari','235716253761.9','798273498273.8',1);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(3,'CHSNN','Sarnen','235712353761.9','798253498273.8',2);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(4,'USVIH','Vichy','235712353731.9','794253498273.8',3);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(5,'CAWAT','Watson Lake','235722353731.9','794253498173.8',4);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(6,'DEPKS','Plankstsdt','235722353732.9','794253498174.8',5);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(7,'FRBOB','Bobigny','235722353733.9','794253498175.8',6);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(8,'CHWTG','Wettingen','235722353734.9','794253498176.8',2);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(9,'USLSN','Los Banos','235722353735.9','794253498177.8',3); 
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(10,'CAODS','Olds','23572235376.9','794253498178.8',4);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(11,'KEWJR','Wajir','235722353737.9','794253498179.8',7);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(12,'DEPOC','Pocking','235722353738.9','7942534981710.8',5);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(13,'FRBRG','Brignoud','235722353739.9','794253498171.8',6);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(14,'KEUKA','Ukunda','235722353701.9','794253498172.8',7);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(15,'BRBSS','Balsas','235722353702.9','794253498173.8',9);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(16,'ARLUQ','San Luis','235722353703.9','794253498174.8',10);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(17,'NOMAG','Magnor','235722353704.9','794253498175.8',12);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(18,'UGMBQ','Mbarara','235722353705.9','794253498176.8',8);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(19,'NZTKA','Temuka','235722353706.9','794253498177.8',11);
 
 
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(1,'Kandla ','KAN',1);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(2,'Kingscote','KGC',1);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(3,'Venne','VEN',2);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(4,'Botwood','AOH',3);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(5,'Yangsan','SHY',4);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(6,'Everglades','EVG',5);
 
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(1,'40x4.3 Open Top Containers','40','DC');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(2,'40x8.5 Non-Vented, Open 1/Both Ends','40','HC');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(3,'20x8.5 Passive Vents','20','DV');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(4,'20x8 Tank for Gases','20','TK');

  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(1,'Good','CLHU8817405','A',1,1,1,'24 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(2,'Good','CLHU8817406','A',2,2,2,'24 jul 2017',CURRENT_TIMESTAMP,1,1);  
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(3,'Good','CLHU8817407','A',1,1,3,'25 jul 2017',CURRENT_TIMESTAMP,1,1);  
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(4,'Damaged','CLHU8817408','NA',2,2,3,'25 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(5,'Damaged','CLHU8817409','A',1,1,1,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(6,'Good','CLHU88174010','A',2,2,2,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(7,'Good','CLHU88174011','A',3,3,3,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(8,'Damaged','CLHU88174012','NA',3,4,4,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(9,'Damaged','CLHU88174013','NA',3,4,5,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(10,'Good','CLHU88174014','NA',4,3,1,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(11,'Good','CLHU88174015','NA',4,4,4,'28 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(12,'Damaged','CLHU88174016','A',4,3,2,'28 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(13,'Good','CLHU88174017','A',5,4,4,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(14,'Good','CLHU88174018','NA',5,4,4,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(15,'Damaged','CLHU88174019','A',5,4,5,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(16,'Good','CLHU88174020','NA',4,4,5,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(17,'Good','CLHU88174021','A',5,1,5,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(18,'Good','CLHU88174022','A',5,2,5,'28 jul 2017',CURRENT_TIMESTAMP,1,1); 
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(19,'Good','CLHU88174023','A',5,4,3,'28 jul 2017',CURRENT_TIMESTAMP,1,1); 
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(20,'Good','CLHU88174024','A',4,3,5,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(21,'Good','CLHU88174025','A',3,3,3,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(22,'Good','CLHU88174026','A',1,2,3,'25 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(23,'Good','CLHU88174027','A',1,2,3,'25 jul 2017',CURRENT_TIMESTAMP,1,1);
// INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(22,'Damaged','CLHU88174028','A',1,2,3,'24 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(24,'Damaged','CLHU88174029','A',1,2,3,'24 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(25,'Good','CLHU88174030','NA',1,4,5,'25 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(26,'Good','CLHU88174031','NA',3,4,5,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(27,'Good','CLHU88174032','NA',2,3,4,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(28,'Good','CLHU88174033','NA',4,2,3,'28 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(29,'Good','CLHU88174034','A',4,2,3,'29 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(30,'Good','CLHU88174035','A',2,4,1,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(31,'Good','CLHU88174036','A',2,3,5,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(32,'Good','CLHU88174037','A',2,1,3,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(33,'Good','CLHU88174038','A',3,2,3,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(34,'Good','CLHU88174039','A',3,1,3,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(35,'Good','CLHU88174040','NA',4,2,3,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(36,'Good','CLHU88174041','NA',4,2,3,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(37,'Good','CLHU88174042','A',4,2,3,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(38,'Damaged','CLHU88174043','A',3,4,2,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(39,'Damaged','CLHU88174044','A',5,2,3,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(40,'Good','CLHU88174045','A',1,2,3,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
 INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(41,'Good','CLHU88174046','A',1,3,6,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(42,'Good','CLHU88174047','A',3,4,7,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(43,'Good','CLHU88174048','A',4,2,8,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(44,'Good','CLHU88174049','A',5,2,9,'26 jul 2017',CURRENT_TIMESTAMP,1,1);  
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(45,'Damaged','CLHU88174050','NA',2,1,10,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(46,'Damaged','CLHU881740451','NA',1,2,11,'23 jul 2017',CURRENT_TIMESTAMP,1,1);  
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(47,'Good','CLHU88174052','A',3,3,12,'26 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(48,'Good','CLHU88174053','A',4,4,13,'27 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(49,'Good','CLHU88174054','A',3,1,14,'28 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(50,'Good','CLHU88174055','A',2,2,15,'23 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(51,'Good','CLHU88174056','NA',3,1,16,'22 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(52,'Good','CLHU88174057','NA',2,2,17,'22 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(53,'Damaged','CLHU88174058','NA',3,1,18,'22 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(54,'Damaged','CLHU88174059','A',2,2,19,'22 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(55,'Good','CLHU88174060','A',2,3,13,'30 jul 2017',CURRENT_TIMESTAMP,1,1);   
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(56,'Good','CLHU88174061','A',1,1,14,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(57,'Good','CLHU88174062','NA',5,1,15,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(58,'Damaged','CLHU88174063','A',4,4,16,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(59,'Good','CLHU88174064','A',3,1,17,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(60,'Good','CLHU88174065','NA',2,4,18,'30 jul 2017',CURRENT_TIMESTAMP,1,1);
INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE,LAST_UPDATED_DATE,DEPOT_ID, record_status) VALUES(61,'Good','CLHU88174066','A',1,2,19,'31 jul 2017',CURRENT_TIMESTAMP,1,1);
    

INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(1,'Manas','manas','manas',1);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(2,'Dhiraj','dhiraj','dhiraj',1);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(3,'ARUN','arun','arun',2);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(4,'SHWETA','shweta','shweta',2);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(5,'Tanya','tanya','tanya',3);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(6,'Nehal','nehal','nehal',3);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(7,'Ayushi','ayushi','ayushi',3);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(8,'Ashwin','ashwin','ashwin',6);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(9,'Heraj','heraj','heraj',5);
INSERT INTO User(USER_ID,NAME,USERNAME,PASSWORD,COMPANY_ID) VALUES(10,'Neeraj','neeraj','neeraj',4);
 
 INSERT INTO ROLE(ID,NAME) VALUES(1,'Admin');
 INSERT INTO ROLE(ID,NAME) VALUES(2,'Admin');
 INSERT INTO ROLE(ID,NAME) VALUES(3,'Admin');
 --INSERT INTO ROLE(ID,NAME) VALUES(4,'Admin');

 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(1,1);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,1);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,1);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,2);
 --INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(1,2);
-- INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(1,3);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,3);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,2);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,3);
 --INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(1,4);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,4);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,6);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,5);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,5);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,4);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,6);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(3,7);
-- INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(1,8);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,9);
 INSERT INTO user_role(ROLE_ID,USER_ID) VALUES(2,10);
 
 
 INSERT INTO CART(CART_ID,REQUISITION_NO,PORT_ID,COMPANY_ID,REQUEST_DATE,RELEASE_DATE,PORT_SOURCE,PORT_DESTINATION,REQUESTED_QUANTITY,STATUS,PICKUP_DATE,NOTE) values(1,101,3,1, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'INKTR','USVIH',5,1,'2017-07-01','dsfsdgf');
 
 INSERT INTO CART_CONTAINER(CART_ID,CONTAINER_ID) values(1,1);
 INSERT INTO CART_CONTAINER(CART_ID,CONTAINER_ID) values(1,5);
 INSERT INTO CART_CONTAINER(CART_ID,CONTAINER_ID) values(1,30);
 
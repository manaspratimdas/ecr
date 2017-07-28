--insert into  PRODUCT(id,NAME , PRICE, WEIGHT) values (1,'Pen',10.10 , 12.00)

 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(1,'ASIA', 'AS');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(2,'Europe', 'EU');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(3,'North America', 'NA');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(4,'South America', 'SA');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(5,'Africa','AF');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(6,'Australia','AUS');
 INSERT INTO  REGION(REGION_ID,NAME, REGION_CODE) values(7,'Antarctica','AN');
 

  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(1,'IND','INDIA','IN',1);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(2,'CHN','CHINA','CN',1);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(3,'USA','USA','US',3);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(4,'CAN','CANADA','CA',3);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(5,'DEU','GERMANY','DE',2);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(6,'FRA','FRANCE','FR',2);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(7,'KEN','KENYA','KE',5);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(8,'UGA','UGANDA','UG',5);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(9,'BRA','BRAZIL','BR',4);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(10,'ARG','ARGENTINA','AR',4);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(11,'NZL','NEWZEALAND','NZ',6);
  INSERT INTO  COUNTRY(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(12,'NOR','NORWAY','NO',7);
 
 
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
 
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(1,'FRBNN','Brionne','235716253761.9','798273498273.8',1);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(2,'USNPH','Nephi','235716253761.9','798273498273.8',1);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(3,'AUXCO','Colac','235712353761.9','798253498273.8',2);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(4,'CHSNN','Sarnen','235712353731.9','794253498273.8',3);
 INSERT INTO PORT(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(5,'FRBOB','Bobigny','235722353731.9','794253498173.8',4);

 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(1,'Kandla ','kan',1);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(2,'Cochin','coc',1);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(3,'Paradip','para',2);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(4,'Panaji','pan',3);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(5,'Haldia','hal',4);
 INSERT INTO DEPOT(DEPOT_ID,DEPOT_NAME,DEPOT_CODE,PORT_ID) VALUES(6,'Everglades','evg',5);
 
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(1,'40x4.3 Open Top Containers','40','DC');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(2,'40x8.5 Non-Vented, Open 1/Both Ends','40','HC');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(3,'20x8.5 Passive Vents','20','DV');
 INSERT INTO CONTAINERTYPE(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(4,'20x8 Tank for Gases','20','TK');

  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(1,'Good','CLHU8817405','A',1,1,1,'24 jul 2017');
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(2,'Good','CLHU8817406','A',2,2,2,'24 jul 2017');  
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(3,'Good','CLHU8817407','A',1,1,3,'25 jul 2017');  
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(4,'Damaged','CLHU8817408','NA',2,2,3,'25 jul 2017');
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(5,'Damaged','CLHU8817409','NA',1,1,1,'26 jul 2017');
  INSERT INTO container(CONTAINER_ID,CONTAINER_CONDITION,Code,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID,UPDATED_DATE) VALUES(6,'Good','CLHU8817404','NA',2,2,2,'26 jul 2017');
  
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(1,'Manas','manas','manas','Admin',1);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(2,'Dhiraj','dhiraj','dhiraj','Admin',1);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(3,'ARUN','arun','arun','Admin',2);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(4,'SHWETA','shweta','shweta','Admin',2);


 
 
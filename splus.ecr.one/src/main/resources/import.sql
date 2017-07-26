--insert into  PRODUCT(id,NAME , PRICE, WEIGHT) values (1,'Pen',10.10 , 12.00)

 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(1,'ASIA', 'AS');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(2,'Europe', 'EU');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(3,'North America', 'NA');
 insert into  REGION(REGION_ID,NAME, REGION_CODE) values(4,'South America', 'SA');
 
 
 
 insert into country(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(1,'IN','INDIA','INDIA',1);
 insert into country(COUNTRY_ID,ISO_COUNTRY_CODE,ISO_LOCAL_NAME,ISO_COUNTRY_NAME,REGION_ID) values(2,'US','USA','USA',3);
 
 INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(1, 'MARINE LINES', 'MUMBAI', 'LANE PORT', '411235', 1);
 --INSERT INTO ADDRESS(ADDRESS_ID, ADDRESS_LINE_ONE, CITY, STREET_NAME, ZIP, COUNTRY_ID) values(2, 'NEW YORK LINES', 'NEW YORK', 'HUDSON PORT', '88825', 3);
 
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(1,'SYSTEM LINERS',1);
 INSERT INTO COMPANY(COMPANY_ID,NAME,ADDRESS_ID) VALUES(2,'APOC',1);
 
 INSERT INTO port(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(1,'FRBZL','FRBZL','235716253761.9','798273498273.8',1);
 INSERT INTO port(PORT_ID,ISO_PORT_CODE,ISO_PORT_NAME,LATITUDE,LONGITUDE,COUNTRY_ID)VALUES(2,'FRBZO','FRBZO','235716253761.9','798273498273.8',1);
 
 INSERT INTO containertype(CONTAINERTYPE_ID,DESCRIPTION,SIZE,TYPE) VALUES(1,'40x9 6,Open top, open ends (skeletal)','40','PS');
 

  INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(1,'CLHU8817405','20x8.5 Open Top Remv Top Members','A',1,1,1);
 INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(2,'CLHU8984151','20x8 6,Nonpressurized - closed','A',1,1,1);
 INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(3,'CLHU8992769','20x8.5 Platform, Comp Free Standing Posts','A',1,1,1);
 
 INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(4,'AAAU8817405','AAA container 111','A',2,1,1);
INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(5,'AAAU8984151','AAA container 222','A',2,1,2);
INSERT INTO container(CONTAINER_ID,Code,Name,STATUS,COMPANY_ID,CONTAINERTYPE_ID,PORT_ID) VALUES(6,'AAAU8992769','AAA container 333','A',2,1,2);

INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(1,'Manas','manas','manas','Admin',1);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(2,'Dhiraj','dhiraj','dhiraj','Admin',2);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(3,'ARUN','arun','arun','Admin',3);
 INSERT INTO User(id,NAME,LOGIN_ID,PASSWORD,ROLE,COMPANY_ID) VALUES(4,'SHWETA','shweta','shweta','Admin',1);


 
 
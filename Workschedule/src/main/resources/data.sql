INSERT INTO EMPLOYEE(firstname, lastname, worktime)
VALUES ('Kalle', 'Anka', 40),
       ('Bengt', 'Bengtsson', 76),
       ('Stina', 'Karlsson', 100);
INSERT INTO COMPANY(companyname, address, contact)
VALUES ('YA','Skogsvägen', 'Gudrun' ),
       ('Kth', 'Isgatan', 'Fritjof');
INSERT INTO COURSE(coursename,workhour,startdate, stopdate,company_company_id,employee_employee_id)
VALUES ('JavaIntro', 50, '2023-07-13', '2023-12-20', 2, 3),
       ( 'Soldyrkan', 75, '2023-06-23', '2024-12-08', 1, 1),
       ( 'Backend', 50, '2023-07-13', '2023-12-20', 1, 3),
       ( 'Frontend', 50, '2024-01-13', '2024-04-20',1, 2);
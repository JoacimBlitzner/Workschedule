INSERT INTO EMPLOYEE(firstname, lastname, worktime, active)
VALUES ('Frida', 'Pettersson', 40, TRUE),
       ('Bengt', 'Bengtsson', 76, FALSE),
       ('Stina', 'Karlsson', 100, TRUE);
INSERT INTO COMPANY(companyname, address, contact)
VALUES ('YA','Skogsvägen', 'Gudrun' ),
       ('Kth', 'Isgatan', 'Fritjof');
INSERT INTO COURSE(coursename,courseclass,workhour,startdate, stopdate, coursebooked ,company_company_id,employee_employee_id)
VALUES ('JavaIntro','java-23', 50, '2023-07-13', '2023-12-20', FALSE,2, 3),
       ( 'Soldyrkan','java-22', 75, '2023-06-23', '2024-12-08', TRUE,1, 1),
       ( 'Backend','.net-23', 50, '2023-07-13', '2023-12-20', TRUE,1, 3),
       ( 'Frontend','.net-22', 50, '2024-01-13', '2024-04-20',FALSE,1, 2);

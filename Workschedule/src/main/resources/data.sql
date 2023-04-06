INSERT INTO EMPLOYEE(firstname, lastname, worktime, active, coursebooked)
VALUES ('Kalle', 'Anka', 40, true, false),
       ('Bengt', 'Bengtsson', 76, false, false),
       ('Stina', 'Karlsson', 100, true, true);
INSERT INTO COMPANY(companyname, address, contact)
VALUES ('YA','Skogsvägen', 'Gudrun' ),
       ('Kth', 'Isgatan', 'Fritjof');
INSERT INTO COURSE(coursename,courseclass,workhour,startdate, stopdate,company_company_id,employee_employee_id)
VALUES ('JavaIntro','java-23', 50, '2023-07-13', '2023-12-20', 2, 3),
       ( 'Soldyrkan','java-22', 75, '2023-06-23', '2024-12-08', 1, 1),
       ( 'Backend','.net-23', 50, '2023-07-13', '2023-12-20', 1, 3),
       ( 'Frontend','.net-22', 50, '2024-01-13', '2024-04-20',1, 2);
-- INSERT INTO TAKEN(determined,undetermined)
-- VALUES ('determined')
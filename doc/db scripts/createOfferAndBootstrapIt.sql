/*CREATING OFFER TABLE AND RELATED TABLES*/
CREATE TABLE OFFER_STATUS (ID INTEGER PRIMARY KEY NOT NULL IDENTITY, DESCRIPTION VARCHAR(255) NOT NULL);
CREATE TABLE OFFER_CANDIDATE_STATUS (ID INTEGER PRIMARY KEY NOT NULL IDENTITY, DESCRIPTION VARCHAR(255) NOT NULL);
CREATE TABLE OFFER (ID INTEGER PRIMARY KEY  NOT NULL IDENTITY, ACRONYM VARCHAR(255), DESCRIPTION VARCHAR(1000), APPLICANT VARCHAR(255), OFFER_STATUS INTEGER, CREATION_DATE DATE, START_DATE DATE, END_DATE DATE);
CREATE TABLE OFFER_CANDIDATES (ID INTEGER PRIMARY KEY NOT NULL IDENTITY, OFFER_ID INTEGER NOT NULL, CANDIDATE_ID INTEGER NOT NULL, OFFER_CANDIDATE_STATUS INTEGER);

/*ALTER TABLE TO ADD FOREIGN KEYS*/
ALTER TABLE OFFER ADD CONSTRAINT OFFER_FK_OFFER_STATUS FOREIGN KEY (OFFER_STATUS) REFERENCES OFFER_STATUS(ID);
ALTER TABLE OFFER_CANDIDATES ADD CONSTRAINT OFFER_CANDIDATES_FK_CANDIDATES FOREIGN KEY (CANDIDATE_ID) REFERENCES CANDIDATE(ID);
ALTER TABLE OFFER_CANDIDATES ADD CONSTRAINT OFFER_CANDIDATES_FK_OFFER FOREIGN KEY (OFFER_ID) REFERENCES OFFER(ID);
ALTER TABLE OFFER_CANDIDATES ADD CONSTRAINT OFFER_CANDIDATES_FK_OFFER_CANDIDATES_STATUS FOREIGN KEY (OFFER_CANDIDATE_STATUS) REFERENCES OFFER_CANDIDATE_STATUS(ID);

/*BOOTSTRAP TABLES*/
INSERT INTO OFFER_STATUS (DESCRIPTION) VALUES('PENDING');
INSERT INTO OFFER_CANDIDATE_STATUS (DESCRIPTION) VALUES('INTERVIEW');
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Digital Twin', 'Two new Java developers should be incorporated. The salary range is between 20k€ and 30k€. The location is in Vigo full time.', 'Janna Tirte', 0, '2020-01-01', '2020-02-07', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Exotic language programmer', 'We are looking for a talented Programmer to create secure and functional code.
You may have to provide quality coding solutions both for simple applications and complex information or operating systems.
The ideal candidate will have a passion for technology and software building.
Attention to detail and an analytical mind are essential qualities for a successful career in programming.', 'Richard Stallman', 0, '2019-12-01', '2019-12-15', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('HR Manager', 'We are looking for an experienced leader for our project management office focused on Project Management activities within our service delivery center to join our team in our Atlanta office. This role is integral to achieve accurate project management and process standardization throughout the organization. The major priority for the successful candidate will be to lead a team of project managers across a large portfolio of projects. Projects range from small enhancements, large-scale technology implementations, and daily operational activities.', 'Harry May', 0, '2020-01-01', '2020-01-07', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Software developer', 'Works under the direction and supervision of application managers and project managers to help build the next generation of global financial data systems to support the client’s front office, middle office processes and back-office risk, finance, compliance reporting, regulatory reporting, and capital markets and banking needs.', 'Tanya Howard', 0, '2020-01-01', '2020-01-02', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('UI developer', 'The ideal candidate will be responsible for developing user interfaces and controls that achieve maximum usability for our enterprise application and our customers.', 'Francis Harris', 0, '2019-12-01', '2019-12-24', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Entry level management', 'With the addition of various new clients requesting that we expand our services to new markets, we have an urgent need for a passionate individual that we can train, support, and groom to accept a role as a Manager within our firm.

To ensure your success, we offer training that encompasses all facets of our business operations. You’ll experience hands on training provided by seasoned professionals in each department, primarily:

Promotional Marketing
Customer Service
Consumer Relations
Business Administration
Recruiting and Talent Acquisition', 'Joy Boyd', 0, '2019-11-01', '2019-11-06', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('PHP developer', 'Responsible for all requests for data processing services including, preparation of specifications, development and maintenance of computer programs, job control language and operational documentation. Assists productions systems group. Interfaces with other departments to determine user needs.', 'Rebecca Bowman', 0, '2020-01-01', '2020-01-06', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Security engineer', 'This position is open within the Security Engineering teams, which has full end-to-end ownership of security tools that allows for strong security prevention, detection and response capabilities. Our mission is to ensure cyber infrastructure is in line with industry standards by performing day-to-day system administration, product selection for new tools, deployment, configuration, maintenance, and support and license management.', 'Harry Gardner', 0, '2020-01-01', '2020-01-16', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Project Manager', 'Performs a variety of duties associated with the development and production of the aircraft maintenance manuals, wiring diagram manuals and other associated documents. Utilize an automated publishing system to download, import, and distribute manual data.Individual will incorporate vendor revisions and Delta engineering documents into a Delta customized manual and coordinate the publishing of the same. Additional responsibilities may include continuous improvement of revision processes, training and point person for data issues. The Project Leader may also be responsible for review and distribution of Aircraft Maintenance Alerts (AMAs), company policy & procedures, bulletins, vendor access, and other technical information.', 'Erika Torres', 0, '2020-01-01', '2020-01-15', NULL);
INSERT INTO OFFER
(ACRONYM, DESCRIPTION, APPLICANT, OFFER_STATUS, CREATION_DATE, START_DATE, END_DATE)
VALUES('Istari support', 'Will provide administrative and logistical support to members of the executive team and may support other as needed. Must display professionalism and a strong work ethic while fostering a work environment that is positive, optimistic and collaborative. Position requires excellent administrative, communication, organizational and time management skills paired with flexibility, integrity and the ability to work independently. Must have Balrog fighting proficiency.', 'Eru Iúvatar', 0, '2020-01-01', '2020-01-06', NULL);
INSERT INTO OFFER_CANDIDATES (ID, OFFER_ID, CANDIDATE_ID, OFFER_CANDIDATE_STATUS) VALUES(0, 0, 0, 0);
INSERT INTO OFFER_CANDIDATES (ID, OFFER_ID, CANDIDATE_ID, OFFER_CANDIDATE_STATUS) VALUES(1, 0, 3, 0);
INSERT INTO OFFER_CANDIDATES (ID, OFFER_ID, CANDIDATE_ID, OFFER_CANDIDATE_STATUS) VALUES(2, 0, 8, 0);
INSERT INTO OFFER_CANDIDATES (ID, OFFER_ID, CANDIDATE_ID, OFFER_CANDIDATE_STATUS) VALUES(3, 0, 12, 0);

/*IMPORTANT!!!!!!!!!
 * SELECT QUERY BLOCK WITHOUT COMMENTS AND PRESS ALT + X (EXECUTE SQL SCRIPT) OR CHECK ONLY ONE STATEMENT AND PRESS CONTROL + ENTER
 */

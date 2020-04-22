SET sql_notes = 0;
CREATE TABLE IF NOT EXISTS `persistent_logins` (
                                                 username  VARCHAR(64) NOT NULL,
                                                 series    VARCHAR(64) NOT NULL,
                                                 token     VARCHAR(64) NOT NULL,
                                                 last_used TIMESTAMP   NOT NULL,
                                                 PRIMARY KEY (series)
);

CREATE TABLE IF NOT EXISTS SPRING_SESSION (
                                              PRIMARY_ID CHAR(36) NOT NULL,
                                              SESSION_ID CHAR(36) NOT NULL,
                                              CREATION_TIME BIGINT NOT NULL,
                                              LAST_ACCESS_TIME BIGINT NOT NULL,
                                              MAX_INACTIVE_INTERVAL INT NOT NULL,
                                              EXPIRY_TIME BIGINT NOT NULL,
                                              PRINCIPAL_NAME VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS SPRING_SESSION_ATTRIBUTES (
                                                         SESSION_PRIMARY_ID CHAR(36) NOT NULL,
                                                         ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
                                                         ATTRIBUTE_BYTES BLOB NOT NULL
                                                         );

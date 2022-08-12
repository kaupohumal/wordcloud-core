CREATE TABLE IF NOT EXISTS migrations.words
(
    id         SERIAL NOT NULL PRIMARY KEY,
    identifier varchar(36),
    wordName   varchar(100),
    count      integer
);
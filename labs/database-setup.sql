use imdbclone;

CREATE TABLE `star` (
  `nconst` varchar(200) NOT NULL,
  `primaryName` varchar(1000) DEFAULT NULL,
  `birthYear` varchar(1000) DEFAULT NULL,
  `deathYear` varchar(1000) DEFAULT NULL,
  `primaryProfession` varchar(1000) DEFAULT NULL,
  `knownForTitles` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`nconst`)
) ENGINE=InnoDB
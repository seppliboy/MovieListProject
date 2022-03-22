DROP TABLE IF EXISTS `movie_list`;

CREATE TABLE movie_list( 
id long AUTO_INCREMENT, 
title VARCHAR(30) NOT NULL,
genre VARCHAR(25) NOT NULL,
runningTime int NOT NULL,
releaseYear int NOT NULL,
watched boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `movie_list` (`title`, `genre`, `runningTime`, `releaseYear`, `watched`) VALUES ('testtitle1', 'testgenre1', 122, 1999, true);
INSERT INTO `movie_list` (`title`, `genre`, `runningTime`, `releaseYear`, `watched`) VALUES ('testtitle2', 'testgenre2', '5, 1945, false);
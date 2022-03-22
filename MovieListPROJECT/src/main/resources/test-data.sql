DROP TABLE IF EXISTS `movie_list`;

CREATE TABLE movie_list( 
id long AUTO_INCREMENT, 
title VARCHAR(30) NOT NULL,
genre VARCHAR(30) NOT NULL,
running_time int NOT NULL,
release_year int NOT NULL,
watched boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `movie_list` (`title`, `genre`, `running_time`, `release_year`, `watched`) VALUES ('TestMovie1', 'TestGenre1', 100, 1985, false);
INSERT INTO `movie_list` (`title`, `genre`, `running_time`, `release_year`, `watched`) VALUES ('TestMovie2', 'TestGenre2', 80, 1965, false);
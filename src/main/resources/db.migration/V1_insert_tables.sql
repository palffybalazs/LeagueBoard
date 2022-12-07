CREATE TABLE "team_group" (
                            id INTEGER NOT NULL PRIMARY KEY auto_increment,
                            name TEXT
);


CREATE TABLE "team" (
                        id INTEGER NOT NULL PRIMARY KEY auto_increment,
                        name TEXT,
                        points INTEGER,
                        played_matches INTEGER,
                        CONSTRAINT fk_team_group_team
                            FOREIGN KEY(team_group_id)
                                REFERENCES team_group(id)
);


CREATE TABLE "player"(
                         id INTEGER NOT NULL PRIMARY KEY auto_increment,
                         name TEXT,
                         goals INTEGER,
                         assists INTEGER,
                         yellow_cards INTEGER,
                         red_cards INTEGER,
                         played_matches INTEGER,
                         CONSTRAINT fk_team_player
                             FOREIGN KEY(team_id)
                                 REFERENCES team(id)
                         CONSTRAINT username_unique UNIQUE (playername)
);

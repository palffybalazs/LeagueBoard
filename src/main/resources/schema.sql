CREATE TABLE "team_group" (
id SERIAL NOT NULL,
PRIMARY KEY (id),
name TEXT
);


CREATE TABLE "team" (
id SERIAL NOT NULL,
PRIMARY KEY (id),
name TEXT,
points INTEGER,
played_matches INTEGER,
team_group_id INTEGER,
CONSTRAINT fk_team_group_team
    FOREIGN KEY(team_group_id)
    REFERENCES team_group(id)
);


CREATE TABLE "player"(
id SERIAL NOT NULL,
PRIMARY KEY (id),
name TEXT,
goals INTEGER,
assists INTEGER,
yellow_cards INTEGER,
red_cards INTEGER,
played_matches INTEGER,
picture TEXT,
team_id INTEGER,
CONSTRAINT fk_team_player
    FOREIGN KEY(team_id)
    REFERENCES team(id)
);

CREATE TABLE "users" (
id SERIAL NOT NULL,
PRIMARY KEY (id),
username TEXT,
email VARCHAR(100),
password VARCHAR(300),
role VARCHAR(100),
player_id INTEGER,
CONSTRAINT fk_player_user
    FOREIGN KEY(player_id)
    REFERENCES player(id)
);

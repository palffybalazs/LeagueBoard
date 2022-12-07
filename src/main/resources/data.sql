
insert into team_group(name) values ('GROUP A');
insert into team_group(name) values ('GROUP B');

insert into team(name, points, played_matches, team_group_id) select 'A', 3, 2, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'B', 2, 2, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'C', 4, 2, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'D', 3, 2, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'E', 6, 2, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'F', 0, 2, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'G', 3, 2, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'H', 6, 2, id from team_group where name = 'GROUP B';

insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select '', 0,0,0,0,0, '',id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'George', 2, 2, 1, 2, 5, 'https://picsum.photos/id/1/50/50',id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'John', 1, 2, 1, 3, 5, 'https://picsum.photos/id/2/50/50',id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Paul', 3, 4, 2, 3, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Ringo', 2, 3, 5, 3, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Clara', 3, 2, 4, 5, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Mike', 2, 4, 4, 3, 5, 'https://picsum.photos/id/3/50/50',id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Johanna', 2, 3, 4, 1, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Juliet', 3, 2, 3, 1, 5, 'https://picsum.photos/id/4/50/50',id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Lily', 2, 3, 1, 4, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Olive', 2, 1, 3, 4, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'William', 2, 0, 0, 4, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Bill', 0, 3, 4, 1, 5, 'https://picsum.photos/id/5/50/50',id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Miles', 1, 2, 0, 2, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Oscar', 3, 2, 0, 3, 5, 'https://picsum.photos/id/6/50/50',id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Georgia', 0, 3, 4, 0, 5, 'https://picsum.photos/id/7/50/50',id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Anna', 1, 0, 0, 2, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Jamie', 2, 0, 2, 1, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Charlie', 3, 0, 0, 2, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Smith', 4, 0, 0, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Jack', 2, 0, 0, 3, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Daniel', 3, 1, 2, 3, 5, 'https://picsum.photos/id/8/50/50',id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Eric', 4, 0, 3, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Son', 1, 0, 0, 2, 5, 'https://picsum.photos/id/9/50/50',id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Tökmag', 3, 1, 0, 1, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Boli', 4, 0, 3, 4, 0, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Somalia', 3, 2, 3, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Mmae', 2, 2, 3, 2, 5, 'https://picsum.photos/id/10/50/50',id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Ryan', 4, 1, 1, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Liam', 1, 0, 3, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Amelia', 2, 3, 4, 5, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Charlotte', 3, 0, 3, 0, 5, 'https://picsum.photos/id/11/50/50',id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, picture, team_id)select 'Emma', 5, 0, 0, 0, 5, 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__480.png',id from team where name = 'H';




insert into "users"(username, email, password, role, player_id) select 'Guest', '', '','ROLE_GUEST', 1;
insert into "users"(username, email, password, role, player_id) select 'Admin', '', '$2a$12$.Z0My8IQi.gd7Zf0RBWlluaOu80p178IGSCOYs6nJjTeBK9pDb3/O', 'ROLE_ADMIN', 1;
insert into "users"(username, email, password, role, player_id) select 'Anna', 'Anna@gmail.com', '$2a$12$.Z0My8IQi.gd7Zf0RBWlluaOu80p178IGSCOYs6nJjTeBK9pDb3/O','ROLE_USER', id from player where name = 'Anna';
insert into "users"(username, email, password, role, player_id) select 'Somalia', 'Somalia@gmail.com', '$2a$12$.Z0My8IQi.gd7Zf0RBWlluaOu80p178IGSCOYs6nJjTeBK9pDb3/O','ROLE_USER', id from player where name = 'Somalia';
insert into "users"(username, email, password, role, player_id) select 'Emma', 'Emma@gmail.com', '$2a$12$.Z0My8IQi.gd7Zf0RBWlluaOu80p178IGSCOYs6nJjTeBK9pDb3/O','ROLE_USER', id from player where name = 'Emma';
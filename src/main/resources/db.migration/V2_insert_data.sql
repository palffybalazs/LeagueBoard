
insert into team_group(name) values ('GROUP A');
insert into team_group(name) values ('GROUP B');

insert into team(name, points, played_matches, team_group_id) select 'A', 0, 0, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'B', 0, 0, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'C', 0, 0, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'D', 0, 0, id from team_group where name = 'GROUP A';
insert into team(name, points, played_matches, team_group_id) select 'E', 0, 0, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'F', 0, 0, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'G', 0, 0, id from team_group where name = 'GROUP B';
insert into team(name, points, played_matches, team_group_id) select 'H', 0, 0, id from team_group where name = 'GROUP B';


insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'George', 0, 0, 0, 0, 0, id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'John', 0, 0, 0, 0, 0, id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Paul', 0, 0, 0, 0, 0, id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Ringo', 0, 0, 0, 0, 0, id from team where name = 'A';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Clara', 0, 0, 0, 0, 0, id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Mike', 0, 0, 0, 0, 0, id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Johanna', 0, 0, 0, 0, 0, id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Juliet', 0, 0, 0, 0, 0, id from team where name = 'B';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Lily', 0, 0, 0, 0, 0, id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Olive', 0, 0, 0, 0, 0, id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'William', 0, 0, 0, 0, 0, id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Bill', 0, 0, 0, 0, 0, id from team where name = 'C';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Miles', 0, 0, 0, 0, 0, id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Oscar', 0, 0, 0, 0, 0, id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Georgia', 0, 0, 0, 0, 0, id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Anna', 0, 0, 0, 0, 0, id from team where name = 'D';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Jamie', 0, 0, 0, 0, 0, id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Charlie', 0, 0, 0, 0, 0, id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Smith', 0, 0, 0, 0, 0, id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Jack', 0, 0, 0, 0, 0, id from team where name = 'E';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Daniel', 0, 0, 0, 0, 0, id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Eric', 0, 0, 0, 0, 0, id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Son', 0, 0, 0, 0, 0, id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Tökmag', 0, 0, 0, 0, 0, id from team where name = 'F';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Boli', 0, 0, 0, 0, 0, id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Somalia', 0, 0, 0, 0, 0, id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Mmae', 0, 0, 0, 0, 0, id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Ryan', 0, 0, 0, 0, 0, id from team where name = 'G';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Liam', 0, 0, 0, 0, 0, id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Amelia', 0, 0, 0, 0, 0, id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Charlotte', 0, 0, 0, 0, 0, id from team where name = 'H';
insert into player(name, goals, assists, yellow_cards, red_cards, played_matches, team_id)select 'Emma', 0, 0, 0, 0, 0, id from team where name = 'H';

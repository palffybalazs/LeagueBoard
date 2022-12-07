# LeagueBoard
 
This is the background implementation of my LeageBoard project for Advanced Java course 2022, autumn </br>

## Installations
One should clone this repository in a new folder.
It requires a postgres background server installed on the machine with the username and password to it, given in intellij. </br>
The one used in the project: https://www.postgresqltutorial.com/postgresql-getting-started/install-postgresql/ working on Port 5432

### Running the code
After installation, the code can be run from intellij. The project automatically creates four tables:
* Users
* Players
* Teams
* TeamGroups </br>

and inserts test data into them with foreign keys.</br>
The server can be reached on http://localhost:8080/${desiredlocation}, which can be choosed from the following list (some of these are secured to show the working authentication and authorization functions working from the user table from the database, User: Admin, psw: 123):
* teams/, listing all the teams in order of the points
   * /teams/{name} gives back the team with the name
   * /teams/groups/{groupId} gives back teams in the given group
   * /teams/find/{id} gives back the team with given id
   * /teams/add/teamclass adds a new team
   * /teams/delete/{id} deletes team with id
   * /teams/update/{id} updates team with id
* teamgroups/, listing the groups
   * /teamgroups/{name} gives back the team with the name
   * /teamgroups/groups/{name} gives back teamgroups with the name
   * /teamgroups/find/{id} gives back the teamgroups with given id, only ROLE_ADMIN
   * /teamgroups/add/teamgroup adds a new teamgroup
   * /teamgroups/delete/{id} deletes teamgroup with id
   * /teamgroups/update/{id} updates teamgroup with id
* players/, listing the players in order of the scored goals
   * /players/{name} gives back the player with the name
   * /players/team/{id} gives back players with the team with id
   * /players/add/player adds a new player
   * /players/delete/{id} deletes player with id
   * /players/update/{id} updates player with id
* users, defended by authentication and authorization
   * /users/{id} gives back player with the user with id, foreign key connection, only ROLE_ADMIN
   
### Structure of the database

<p align="center">
<img src="https://user-images.githubusercontent.com/50795664/206267496-4374289c-979f-4198-8361-9a46c77ac625.png" width="450" height="200">
</p>

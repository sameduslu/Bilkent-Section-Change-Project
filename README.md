# Bilkent Section Change Project

The application provides easy management of the registration period for Bilkent students. The users will be able to change the sections of the subjects according to their request by checking the availability of the user's schedule. The main design will consist of a user interface that will allow users to have subjects and their schedules that will also be implemented considering the limits of the current courses. Users should create single and multiple section change requests in our third-party program. They will be in queue accordingly to their request timing, and if available, the program will perform the action. There will also be a forum for people to create and view the exchange section requests. Suppose another user in the targetted section accepts the requests. In that case, action will be performed automatically to exchange the sections of the subjects between those two people who gave the request and approved the request. In addition, the program will inform users of the changes if it concerns the user's requests. If they desire, they can also be notified for various reasons, such as when the targetted section has an available quota or a targetted exchange order in the forum.

## Installation

### Server

Server requires mongodb as the database. To run mongodb on your local, follow these steps:

   * Install docker
   * On a terminal, run `docker volume create mongodbdata`
   * Chenge directory to `server/docker`
   * run `docker compose up -d mongo`

Those commands should run mongodb on the default port of mongo database.

To compile the server sources, we have used maven. Run the following commands to compile the server code.

   * On the terminal, change directory to `server`
   * Run `mvnw clean install`
   * Run `java -jar target\registerplusplus-server-0.0.1-SNAPSHOT.jar`

In the development and test environments of the server codes, we used JDK 13. We have not tested against other versions. If you want to use another version, use at your own risk.
Having said that, JDK 9-17 range should work fine.

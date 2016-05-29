To run the application please execute these steps:<br>
1. Run command line.<br>
2. Clone repository to your local machine: git clone https://github.com/texhad3op/bundleselector.git<br>
3. Change folder to created by git: cd bundleselector<br>
4. Build application: mvn clean -DskipTests<br>
5. Run application tests: mvn clean test<br>
6. Run application: mvn spring-boot:run <br>
7. Requests examples:<br>
http://localhost:8080/getbundle?age=15&isstudent=true&income=32<br>
http://localhost:8080/checkbundle?age=15&isstudent=true&income=32&bundle=GOLD<br><br>
You will get JSON with results.<br>
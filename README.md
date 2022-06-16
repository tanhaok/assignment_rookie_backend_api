<!-- PROJECT INFO -->
<div align="center">
  <h4 align="center">FIRST ASSIGNMENT IN BATCH 5 - ROOKIES PROGRAM.</h4>
  <h2 align="center">BACK END API FOR PROJECT: E-COMMERCE</h2>
  <h3 align="center">Hao Nguyen - Mentor: Mr. Minh Le</h3>
</div>


<!-- TABLE OF CONTENTS -->
##  Table of Contents
<ol>
    <li> 
        <a href="#about"> About The Project </a>
        <ul>
            <li><a href='#intro'>Introduction</a></li>
            <li><a href="#user_case">User Case</a></li>
            <li><a href="#entity">Entity</a></li>
            <li><a href="#database">Database</a></li>
            <li><a href="#config">Configuration And Dependency</a></li>
        </ul>
    </li>
    <li> <a href="#getting">Getting Started</a></li>
    <li> <a href='#usage'> Usage</a></li>
    <li> <a href="license"> License</a></li>
</ol>



<!-- ABOUT THE PROJECT -->
## About The Project
<!-- INTRODUCTION -->
### <div id="intro">Introduction</div>
    This project is an assignment. Undertake this project to review and consolidate all the knowledge that has been trained.

    Time to implement this project: 4 weeks.

    Mentor: Mr. Minh Le.

    Performed by: Hao Nguyen.

    Begin  Date: 06-16-2022

    Finish Date:  


<!-- USER CASE -->
### <div id='user_case'>User case</div>
![USER CASE]('asset/usercase.png')

According to requirement of assignment: 

1. Have two actor `customer` and `admin`
2. With each actor:
* `customer`: checkout, register, log in/out, view product, rate product, shopping, ordered, add product to cart. 
* `admin`: Log in/out, manager product, manager category, manager user.

<!-- ENTITY -->
### <div id='entity'>Entity</div>
List of `Entity` had been define:
- Admin
- Customer
- Product
- Category
- Shopping Cart
- Order


<!-- DATABASE -->
### <div id='database'>Database</div>

<!-- CONFIGURATION AND DEPENDENCY-->
### <div id='config'>Configuration And Dependency</div>
1. Configuration

2. Dependency

```xml
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
```



<!-- GETTING STARTED -->
## GETTING STARTED
1. Clone code from github


```sh
git clone https://github.com/tanhao111/assignment_rookie_backend_api.git
```


2. Run app using Maven
```sh
cd assignment_rookie_backend_api
mvn spring-boot:run
```

<!-- USAGE -->
## USAGE

Use POSTMAN to test API

<!-- LICENSE -->
## LICENSE
Distributed under the MIT License. See `LICENSE.txt` for more information.

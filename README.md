# API Buses Technical Challenge
It is a restful api connected with mysql to create schemas, there are 2 endpoints with security and paging.
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="">
    <img src="https://miro.medium.com/v2/resize:fit:600/1*ljHUhFnaBissdRBe7DIo6g.png" alt="Logo" height="80">
  </a>

  <h3 align="center">Challenge API Buses</h3>

</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![image](https://github.com/user-attachments/assets/934de99e-f0d0-4170-ba20-9cb1dec63169)

This project is an API and was made with Spring Boot Web and JPA, connecting with MySQL to create 3 tables, for buses, bus branding and users for authorization and endpoint security, in the controller there are 2 endpoints to list all buses and get a bus by id, we also used pagination with Paginable class to receive more data, apart from that it was usefult to apply DTO patterns to parse data we received.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

This section should list any major frameworks/libraries used to bootstrap your project. 
* [![Spring][Spring]][Spring-url]
* [![MySQL][MySQL]][MySQL-url]
* [![Postman][Postman]][Postman-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

To get the project you need to have an IDE to run java programming language.
* JAVA IDE

### Installation

1. Get credentials to PostgreSQL database and put them into environment variables
2. Clone the repo
   ```sh
   git clone https://github.com/Lenas25/OracleNextChallengeLiterature.git
   ```
3. Change git remote url to avoid accidental pushes to base project
   ```sh
   git remote set-url origin Lenas25/OracleNextChallengeLiterature.git
   git remote -v # confirm the changes
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Here you can check the different functionalities and options that the program has to execute.

1. Login to obtein Jwt Token
  ![image](https://github.com/user-attachments/assets/f98ecb68-7a42-420f-8d75-413440e76890)

2. Get all buses and pagination data with authorization header
   </br>
  ![image](https://github.com/user-attachments/assets/efc7ac45-8908-44f5-8743-6116c56e9208)


3. Get a bus by id with authorization header
    </br>
  ![image](https://github.com/user-attachments/assets/5c6e0c54-0eee-4b02-8b63-fbb73e00af62)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Spring]: https://img.shields.io/badge/spring-green?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]:https://start.spring.io/
[MySQL]: https://img.shields.io/badge/mysql-blue?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/
[Postman]: https://img.shields.io/badge/postman-orange?style=for-the-badge&logo=postman&logoColor=white
[Postman-url]: https://www.postman.com/

# WageExchange

Excercise I've done before, but since the result was not satsifying I decided to redo whole project.

The application is a salary calculator with REST api:
1. Provide code of the country and daily gross wage in local currency
2. Get monthly net salary in PLN (exchange rates are being taken from the [Narodowy Bank Polski api](http://api.nbp.pl/en.html))

Since it's only an excercise, calculations shouldn't be taken as a real predictions in real life situations.
The monthly net salary in PLN is being calculated with formula:

*gross_daily x exchange_rate x 22 - (gross_daily x exchange_rate x 22 - cost_of_income) * taxation_rate*

with fixed number for the countries:

| Code | Country | Currency | Cost of Income | Taxation Rate |
| --- | --- | --- | --- | --- |
| PL | Poland | PLN | 1200 | 19 |
| UK | United Kingdom | GBP | 600 | 25 |
| DE | Germany | EUR | 800 | 20 |

## Getting Started

### Prerequisites

To run server side of this project you will need Tomcat (the easiest way of running it for development purposes will be opening whole catalog as a project in [NetBeans IDE](https://netbeans.org/) with [NB Spring Boot](http://plugins.netbeans.org/plugin/67888/nb-springboot) plugin installed.

### Installing and running

If set as described in **Prerequisites** running project with normal "run" command should start the service automatically.

To use this application send a **GET** request to the address used by Tomcat (usually *http://localhost:8080/*) with parameters:

* **value** - being the amount of money in the currency coresponding with country given in "country" parameter
* **country** - being code of the country in which money was earned (PL for Poland, UK for United Kingdom, DE for Germany)

Application will return result of calculation in JSON format with *value* and *currency* parameters.

## Built With

* [Spring](https://spring.io/docs) - The back-end platform used
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Krzysztof Kułak** - [Labalve](https://github.com/Labalve)

## License

This project is licensed under the Beerware License

# SWAPI Report
### Build and run application
To build and run tests:
```
gradle clean build
```
To run application on embedded tomcat:
```
gradle bootRun
```
## Example PUT request
```
PUT /report
{
    "characterPhrase": "Leia",
    "planetName": "Alderaan"
}
```
## Author
* **Krzysztof Panek**
# IoT - 2018 

## Deploying

Project uses two-step approach to manage application:

- **Staging**: [IoT_Problem_stage.herokuapp.com](https://stagging-problem.herokuapp.com/)
- **Production**: [IoT_Problem_production.herokuapp.com](https://problem-production.herokuapp.com/)

## Example endpoints:

```
https://problem-production.herokuapp.com/api/devices (GET)
https://problem-production.herokuapp.com/api/temperatureMeasurement/{id} (GET)
https://problem-production.herokuapp.com/api/temperatureMeasurement/{id}?start=yyyy-MM-ddTHH:mm:ss&end=yyyy-MM-ddTHH:mm:ss (GET)
https://problem-production.herokuapp.com/api/temperatureMeasurement (GET)
https://problem-production.herokuapp.com/api/temperatureMeasurement?start=yyyy-MM-ddTHH:mm:ss&end=yyyy-MM-ddTHH:mm:ss (GET)

https://problem-production.herokuapp.com/collect (POST)

https://problem-production.herokuapp.com/api/temperatureMeasurement/1/2018-05-24T15:00:00/2018-05-24T19:00:00 (GET)

```

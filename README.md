**Weather API**

| Parameter     |               | Description  |
| ----------- |----------- | ----- |
| `city`       | Default city is Moscow. | City name e.g.: Dublin|
| `start_date` | Not required (and, actually, substituted with today) in case if `end_date` absents.      | Date in yyyy-MM-dd format. No earlier than 7 days before `end_date` and today.|
| `end_date`   | Not required (and, actually, substituted with today) in case if `start_date` absents.  | Date in yyyy-MM-dd format. No later than 7 days after `start_date`.  |

_*Example:*_ `http://localhost:8080/weather?start_date=2020-12-06&end_date=2020-12-08&city=Dublin`
```
{
  "weather" : [ {
    "date" : 1607212800000,
    "city" : "Dublin",
    "temp" : 4.3
  }, {
    "date" : 1607299200000,
    "city" : "Dublin",
    "temp" : 5.0
  }, {
    "date" : 1607385600000,
    "city" : "Dublin",
    "temp" : 5.0
  } ]
}
```

**Currency API**

| Parameter     |               | Description  |
| ----------- |-----------  | -----|
| `start_date`    | Not required (and, actually, substituted with today) in case if `end_date` absents. | Date in yyyy-MM-dd format. |
| `end_date` | Not required (and, actually, substituted with today) in case if `start_date` absents. | Date in yyyy-MM-dd format. |

_*Example:*_ `http://localhost:8080/currency?start_date=2020-11-01&end_date=2020-11-10`
```
{
  "currency" : [ {
    "code" : "R01235",
    "value" : 80.5749,
    "date" : 1604361600000
  }, {
    "code" : "R01235",
    "value" : 80.0006,
    "date" : 1604448000000
  }, {
    "code" : "R01235",
    "value" : 78.4559,
    "date" : 1604620800000
  }, {
    "code" : "R01235",
    "value" : 77.1875,
    "date" : 1604707200000
  }, {
    "code" : "R01235",
    "value" : 76.9515,
    "date" : 1604966400000
  } ]
}
```

**Predict API**

_*Example:*_ `http://localhost:8080/prediction`
```
{
  "prediction" : 75.41535013579576
}
```
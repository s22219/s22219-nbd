// 6.	Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne);
printjson(db.people.insertOne(
    {
        "sex" : "Male",
        "first_name" : "Grzegorz",
        "last_name" : "Sokolowski",
        "job" : "Student",
        "email" : "s22219@pjwstk.com",
        "location" : {
            "city" : "Warsaw",
            "address" : {
                "streetname" : "Nowowiejska",
                "streetnumber" : "8690"
            }
        },
        "description" : "sapien quis libero nullam sit amet turpis elementum ligula vehicula",
        "height" : "197.68",
        "weight" : "70.9",
        "birth_date" : "1997-05-03T07:23:16Z",
        "nationality" : "Poland",
        "credit" : [
            {
                "type" : "solo",
                "number" : "3530733569132235",
                "currency" : "CNY",
                "balance" : "4413.72"
            },
            {
                "type" : "mastercard",
                "number" : "3546411670581739",
                "currency" : "PEN",
                "balance" : "6157.36"
            },
            {
                "type" : "switch",
                "number" : "3578595580550809",
                "currency" : "ARS",
                "balance" : "4534.77"
            }
        ]
    }))

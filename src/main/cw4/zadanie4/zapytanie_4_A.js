// 4.	Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości;
printjson(db.people.aggregate({$group:{
    _id: "$nationality",
        "avgBMI": {"$avg": {"$multiply": [{ "$divide":[{"$toDouble": "$weight" },{"$multiply": [{"$toDouble": "$height" },{"$toDouble": "$height" }]}]},{"$toDouble": "10000" }]}},
        "minBMI": {"$min":{"$multiply": [{ "$divide":[{"$toDouble": "$weight" },{"$multiply": [{"$toDouble": "$height" },{"$toDouble": "$height" }]}]},{"$toDouble": "10000" }]}},
        "maxBMI": {"$max":{"$multiply": [{ "$divide":[{"$toDouble": "$weight" },{"$multiply": [{"$toDouble": "$height" },{"$toDouble": "$height" }]}]},{"$toDouble": "10000" }]}},
    }
}).toArray())

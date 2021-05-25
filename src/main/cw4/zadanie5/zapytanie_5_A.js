// 5.	Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty. ,
printjson(db.people.aggregate([
    {$match: {
            "sex": "Female",
            "nationality": "Poland"
            }
    },
    {$unwind: "$credit"},
    {$group:{
            _id: "$credit.currency",
            "avgBalance": {$avg: {$toDouble: "$credit.balance"}},
            "totalBalance": {$sum: {$toDouble: "$credit.balance"}}
        }}
]).toArray())

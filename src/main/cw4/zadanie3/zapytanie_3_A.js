// 3.	Listę unikalnych zawodów
printjson(db.people.aggregate({$group:{
    _id: "null","uniqueJob": {
        "$addToSet": "$job"
    }
}}).toArray())

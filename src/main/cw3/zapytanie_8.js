// Zastąp nazwę miasta „Moscow” przez „Moskwa” u wszystkich osób w bazie;
printjson(db.people.updateMany({"location.city": {$eq:"Moscow"}}, {$set: {"location.city": "Moskwa"}}))

// 3.	Lista mężczyzn narodowości niemieckiej;
printjson(db.people.find({"sex":{$eq:"Male"},"nationality":{$eq:"Germany"}}).toArray())

// 9.	Dodaj do wszystkich osób o imieniu Antonio własność „hobby” o wartości „pingpong”;
printjson(db.people.updateMany({"first_name": {$eq:"Antonio"}}, {$set: {"hobby": "pingpong"}}))

// 7.	Usuń z bazy osoby o wzroście przekraczającym 190;
printjson(db.people.deleteMany({"height":{$gt:"190"}}))

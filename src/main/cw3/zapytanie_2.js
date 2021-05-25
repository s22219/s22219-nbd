// 2.	Jedna kobieta narodowości chińskiej
printjson(db.people.findOne({"sex":{$eq:"Female"},"nationality":{$eq:"China"}}))

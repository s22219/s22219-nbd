// 5.	Lista imion i nazwisk wszystkich osób znajdujących się w bazie oraz miast, w których mieszkają, ale tylko dla osób urodzonych w XXI wieku;
printjson(db.people.find({"birth_date":{$gt:"2001-01-01T00:00:00Z"}},{"first_name": 1, "last_name": 1, "location.city": 1}).toArray())

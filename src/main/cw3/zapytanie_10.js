// 10.	Usuń u wszystkich osób o zawodzie „Editor” własność „email”.
printjson(db.people.updateMany({"job": {$eq:"Editor"}}, {$unset: {email: 1}}, false, true))

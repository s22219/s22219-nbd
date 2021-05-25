// 5.	Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty. ,
var finalizeFunction = function(key, values) {
    money = { totalBalance: 0, avgBalance: 0 };
    money.avgBalance =  values.balance/values.count;
    money.totalBalance =  values.balance;
    return money;
}
printjson(db.people.mapReduce(
    function(){
        for(var i = 0; i < this.credit.length; i++){
            emit(this.credit[i].currency, money = {
                balance: parseFloat(this.credit[i].balance),
                count: 1
            })
        }
    },
    function(key, values){
        money = { balance: 0, count: 0 };
        for (var idx = 0; idx < values.length; idx++) {
            money.balance += values[idx].balance;
            money.count += values[idx].count;
        }
        return money;
    },
    {
        query:{sex:{$eq:"Female"}, nationality:{$eq:"Poland"}},
        out:{inline:1},
        finalize: finalizeFunction
    }
)).toArray()

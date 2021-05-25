// 1.	Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet);
var finalizeFunction = function(key, values) {
        avgWeightAndHeight = { avgWeight: 0, avgHeight: 0 };
        avgWeightAndHeight.avgWeight =  values.weight/values.count;
        avgWeightAndHeight.avgHeight =  values.height/values.count;
        return avgWeightAndHeight;
    }
printjson(db.people.mapReduce(
    function(){
        emit(this.sex, {
            weight: parseFloat(this.weight),
            height: parseFloat(this.height),
            count: 1
        })
    },
    function(key, values){
        reducedWeightAndHeight = { weight: 0, height: 0, count: 0 };
        for (var idx = 0; idx < values.length; idx++) {
            reducedWeightAndHeight.weight += values[idx].weight;
            reducedWeightAndHeight.height += values[idx].height;
            reducedWeightAndHeight.count += values[idx].count;
        }
        return reducedWeightAndHeight;
    },
    {
        finalize: finalizeFunction,
        out: {inline: 1}
    }
))

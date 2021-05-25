// 4.	Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości;

var finalizeFunction = function(key, values) {
    bmi = { avgBmi: 0, bmiMax: 0, bmiMin: 0 };
    bmi.avgBmi =  values.bmi/values.count;
    bmi.bmiMin =  values.bmiMin;
    bmi.bmiMax =  values.bmiMax;
    return bmi;
}
printjson(db.people.mapReduce(
    function(){
        emit(this.nationality, {
            bmi: parseFloat(this.weight)/(parseFloat(this.height)*parseFloat(this.height))*10000,
            bmiMax: parseFloat(this.weight)/(parseFloat(this.height)*parseFloat(this.height))*10000,
            bmiMin: parseFloat(this.weight)/(parseFloat(this.height)*parseFloat(this.height))*10000,
            count: 1
        })
    },
    function(key, values){
        reducedBmi = { bmi: 0, bmiMax: values[0].bmi, bmiMin: values[0].bmi, count: 0 };
        for (var idx = 0; idx < values.length; idx++) {
            reducedBmi.bmi += values[idx].bmi;
            reducedBmi.bmiMax = values[idx].bmi > reducedBmi.bmiMax ? values[idx].bmi : reducedBmi.bmiMax;
            reducedBmi.bmiMin = values[idx].bmi < reducedBmi.bmiMin ? values[idx].bmi : reducedBmi.bmiMin;
            reducedBmi.count += values[idx].count;

        }
        return reducedBmi;
    },
    {
        finalize: finalizeFunction,
        out: {inline: 1}
    }
))

printjson(
  db.people.mapReduce(
  function() {
    this.credit.forEach(c => emit(c.currency, { balance: parseFloat(c.balance), sum: 0, avg: 0 }));
  },
  function(keys, vals) {
    let balances = vals.map(v => v.balance);
    
    return {
              sum: balances.reduce((a, b) => a + b),
              avg: balances.reduce((a, b) => a + b) / balances.length,
      balance: 0
          };
  },
  {
    out: { inline: 1 },
    query: { sex: "Female", nationality: "Poland" },
    finalize: function(k, rv) {
      return {
        currency: k,
        sum: rv.sum,
        avg: rv.avg
      }
    }
  }
)
);
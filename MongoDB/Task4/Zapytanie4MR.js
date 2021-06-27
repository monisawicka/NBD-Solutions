printjson(
  db.people.mapReduce(
  function() {
    emit(this.nationality, parseFloat(this.weight) / Math.pow(parseFloat(this.height)/100, 2));
  },
  function(keys, vals) {
          return vals.reduce((a,b) => a + b) / vals.length;
  },
  {
    out: { inline: 1 },
    finalize: function(k, rv) {
      return { avg: rv }
    }
  }
)
);

printjson(
  db.people.mapReduce(
  function() {
    emit(this.nationality, parseFloat(this.weight) / Math.pow(parseFloat(this.height)/100, 2));
  },
  function(keys, vals) {
          return Math.min(...vals);
  },
  {
    out: { inline: 1 },
    finalize: function(k, rv) {
      return { min: rv }
    }
  }
)
);

printjson(
  db.people.mapReduce(
  function() {
    emit(this.nationality, parseFloat(this.weight) / Math.pow(parseFloat(this.height)/100, 2));
  },
  function(keys, vals) {
          return Math.max(...vals);
  },
  {
    out: { inline: 1 },
    finalize: function(k, rv) {
      return { max: rv }
    }
  }
)
);


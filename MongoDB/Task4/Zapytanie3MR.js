
printjson(
  db.people.mapReduce(
  function() {
    emit(this.job, this.job);
  },
  function(keys, vals) {
    return 0;
  },
  {
    out: { inline: 1 }
  }
)
);
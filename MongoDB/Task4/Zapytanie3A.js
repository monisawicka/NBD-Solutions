printjson(db.people.aggregate([{$group: {_id: "$job",count: {$sum: 0}}}]).toArray());
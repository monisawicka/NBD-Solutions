import riak
riakClient = riak.RiakClient(pb_port=8098)

bucket = riakClient.bucket('S23097')

# dodanie dokumentu
student = {"NBD": True, "name": "Monika Sawicka"}
key = bucket.new('student', data=student)
key.store()
print('Dodano dokument')


# pobranie i wypisanie dokumentu
dok = bucket.get('student')
print('Dany nowy dokument: ' + str(dok.data))


# modyfikacja dokumentu
dok.data['NBD'] = False
dok.store()
dok2 = bucket.get('student')
print('Zmodyfikowano pole NBD: ' + str(dok2.data))


# usuniecie dokumentu
dok2.delete()
print('Usunieto dokument')
dok3 = bucket.get('student')
print('Pobrany usuniety dokument: ' + str(dok3.data))
mongoimport --uri "mongodb+srv://root:<password>@cluster0.wqnpn.mongodb.net/covitality?retryWrites=true&w=majority" --collection units --file units.json --jsonArray

mongoimport --uri "mongodb+srv://root:<password>@cluster0.wqnpn.mongodb.net/covitality?retryWrites=true&w=majority" --collection transactions --file 293115_txn.json --jsonArray
в файле .env и классе EmailService сменить почту на @mai.ru и пароль для внешних сервисов. 

Для базы данных вот пример транзакций, следует заменить userId, вот пример данных:

[{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1074"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-26T10:00:00",
  "category": "GROCERIES",
  "description": "Weekly grocery shopping",
  "amount": 150.5,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1075"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-26T12:30:00",
  "category": "RESTAURANTS",
  "description": "Lunch at cafe",
  "amount": 25,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1076"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-27T09:00:00",
  "category": "SALARY",
  "description": "Monthly salary deposit",
  "amount": 3000,
  "type": "CREDIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1077"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-27T18:00:00",
  "category": "RENT",
  "description": "Monthly rent payment",
  "amount": 1500,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1078"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-28T10:00:00",
  "category": "UTILITIES",
  "description": "Electricity bill",
  "amount": 80,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1079"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-28T16:00:00",
  "category": "SAVINGS",
  "description": "Savings deposit",
  "amount": 500,
  "type": "CREDIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107a"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-29T11:30:00",
  "category": "ENTERTAINMENT",
  "description": "Movie ticket",
  "amount": 18,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107b"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-29T19:00:00",
  "category": "TRANSPORTATION",
  "description": "Bus ticket",
  "amount": 5,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107c"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-30T08:00:00",
  "category": "HEALTHCARE",
  "description": "Doctor visit",
  "amount": 75,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107d"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-30T14:00:00",
  "category": "CLOTHING",
  "description": "New jeans",
  "amount": 60,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107e"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-31T10:00:00",
  "category": "EDUCATION",
  "description": "Online course subscription",
  "amount": 40,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d107f"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-10-31T17:00:00",
  "category": "GIFTS",
  "description": "Birthday gift for friend",
  "amount": 35,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1080"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-01T11:00:00",
  "category": "GROCERIES",
  "description": "Mid-week shopping",
  "amount": 70,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1081"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-01T15:00:00",
  "category": "TRAVEL",
  "description": "Train ticket",
  "amount": 100,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1082"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-02T13:30:00",
  "category": "RESTAURANTS",
  "description": "Dinner at restaurant",
  "amount": 55,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1083"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-02T19:00:00",
  "category": "HOBBIES",
  "description": "Art supplies",
  "amount": 25,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1084"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-03T10:30:00",
  "category": "SUBSCRIPTIONS",
  "description": "Streaming service",
  "amount": 15,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1085"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-03T17:00:00",
  "category": "OTHER",
  "description": "Random purchase",
  "amount": 10,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1086"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-04T09:00:00",
  "category": "SALARY",
  "description": "Monthly salary payment",
  "amount": 3200,
  "type": "CREDIT"
},
{
  "_id": {
    "$oid": "6769d5f0963f95323547cda5"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-04T14:00:00",
  "category": "RENT",
  "description": "Monthly rent payment",
  "amount": 1500,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1088"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-05T11:00:00",
  "category": "UTILITIES",
  "description": "Internet bill",
  "amount": 50,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1089"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-05T16:30:00",
  "category": "TRANSPORTATION",
  "description": "Train ticket",
  "amount": 120,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108a"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-06T10:00:00",
  "category": "ENTERTAINMENT",
  "description": "Concert tickets",
  "amount": 80,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108b"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-06T16:00:00",
  "category": "RESTAURANTS",
  "description": "Dinner",
  "amount": 65,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108c"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-07T09:30:00",
  "category": "CLOTHING",
  "description": "New shoes",
  "amount": 95,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108d"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-07T15:00:00",
  "category": "HEALTHCARE",
  "description": "Pharmacy purchase",
  "amount": 45,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108e"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-08T11:00:00",
  "category": "EDUCATION",
  "description": "Book for course",
  "amount": 30,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d108f"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-08T17:00:00",
  "category": "GIFTS",
  "description": "Wedding gift",
  "amount": 70,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1090"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-09T12:30:00",
  "category": "TRAVEL",
  "description": "Plane tickets",
  "amount": 300,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1091"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-09T20:00:00",
  "category": "SUBSCRIPTIONS",
  "description": "Antivirus subscription",
  "amount": 10,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1092"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-10T11:00:00",
  "category": "HOBBIES",
  "description": "Painting tools",
  "amount": 20,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1093"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-10T16:00:00",
  "category": "OTHER",
  "description": "Random purchase",
  "amount": 15,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1094"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-11T13:00:00",
  "category": "GROCERIES",
  "description": "Weekend shopping",
  "amount": 120,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1095"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-11T19:30:00",
  "category": "RENT",
  "description": "Rent payment",
  "amount": 1500,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1096"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-12T10:00:00",
  "category": "UTILITIES",
  "description": "Gas bill",
  "amount": 90,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1097"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-12T15:30:00",
  "category": "TRANSPORTATION",
  "description": "Taxi fare",
  "amount": 30,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1098"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-13T11:00:00",
  "category": "ENTERTAINMENT",
  "description": "Board game",
  "amount": 25,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d1099"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-13T18:00:00",
  "category": "RESTAURANTS",
  "description": "Lunch with colleague",
  "amount": 15,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d109a"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-14T10:00:00",
  "category": "CLOTHING",
  "description": "New winter coat",
  "amount": 120,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d109b"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-14T16:00:00",
  "category": "HEALTHCARE",
  "description": "Medical checkup",
  "amount": 100,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d109c"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-15T10:00:00",
  "category": "EDUCATION",
  "description": "University payment",
  "amount": 200,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d109d"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-15T14:30:00",
  "category": "OTHER",
  "description": "Miscellaneous expenses",
  "amount": 12.5,
  "type": "DEBIT"
},
{
  "_id": {
    "$oid": "67648cf108f27ccbeb7d109e"
  },
  "userId": "6769d5f0963f95323547cda5",
  "date": "2023-11-16T09:30:00",
  "category": "SAVINGS",
  "description": "Transfer for deposit",
  "amount": 400,
  "type": "CREDIT"
},
{
  "_id": {
 

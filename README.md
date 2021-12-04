# JavaSoftwareEngineer
Questionnaire and answer for Java Software Engineer

2.1)  Basic spring-boot application
Application name: spring-boot
Server port:8080
Endpoints:
GET - http://localhost:8080/index
POST - http://localhost:8080/dotransaction 
Request Body
{
"requestId": "A32W4ER2357",
"requester": "XYZ App",
"transactionType": "VFJBTlNGRVI=",
"sourceAccountNumber": "MzIzNDEyMDA5MjM0ODc=",
"strAmount": "MTUwMC41MA==",
"destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
"note": "Transferring amount"
}

2.2 ) Microservice
Application name: discovery-server
Server port: 8761
URL: http://localhost:8761/

Application name: transaction-service
Server port:8084
POST - http://localhost:8084/transaction-service/dotransaction
Request Body
{
"requestId": "A32W4ER2357",
"requester": "XYZ App",
"transactionType": "VFJBTlNGRVI=",
"sourceAccountNumber": "MzIzNDEyMDA5MjM0ODc=",
"strAmount": "MTUwMC41MA==",
"destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
"note": "Transferring amount"
}


Response: 
{
    "outcome": "success",
    "message": "Transaction success ",
    "data": {
        "requestId": "A32W4ER2357",
        "transactionTime": "2021-12-04T08:08:44.784+0000",
        "requester": "XYZ App",
        "transactionType": "TRANSFER",
        "sourceAccountNumber": "32341200923487",
        "amount": 1500.5,
        "destinationAccountNumber": "001241009211439",
        "note": "Transferring amount",
        "strAmount": null
    },
    "error": null
}

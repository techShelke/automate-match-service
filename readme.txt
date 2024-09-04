
H
D
Basic Text
V
X
Heading 2

DAL :To automate the whole process for success scenarios.
Ve receive the following in excel could be single or multiple records.
ANI 				4806654303
Account number  	6045831292872902
Sys 				9356
PRN					1200
Agent				9000
STEP 1: RUN THE EDL INSERT API
URL: https://edlpayfoneupsertservice-qa.app.dev2.dal.pcf.syfbank.com/payfoneupsert/insertPayfoneRecord
REPLACE ANI from excel with phonenumber
REPLACE Account Number form excel with accountnumber
REPLACE SYS,PRN, Agent with sys, prn, agent from excel
To make transactions unique also make sure to have a unique Id placed for payfoneid in request.

REQUEST:
{
   "transid": "NadeemNewRequest14",
   "eventName": "PayfoneDataService.JavaAPI.Insert",
   "eventTimestamp": "2019-12-10 09:04:08",
   "serverName": "10.245.345",
   "action": "insert",
   "requestMetadata": {
      "version": {
         "major": "1",
         "minor": "1",
         "patch": "0",
         "versionDate": "2019-12-04 17:04:08"
      }
   },
   "request": {
      "accountnumber": "93265498745241980",
      "phonenumber": "3210361980",
      "eventtype": "TN_PORT",
      "loaddatetime": "2020-04-12 11:10:00.365",
      "carrier": "Visible",
      "verified": "false",
      "payfoneid": "",
      "linetype": "",
      "countrycode": "US",
      "namescore": "",
      "addressscore": "",
      "reasoncodes": "",
      "clientid": "",
      "lastcalldate": "2020-04-12 23:10:59",
      "sys": "1408",
      "prin": "2800",
      "agent": "0001",
      "ssn": "658786",
      "dob": "1993-01-10",
      "ppflag": "",
      "lexid": "",
      "syfid": "",
      "tokenid": "felix.cuevas",
      "details": "felix.cuevas",
      "eventdate": "2000-04-22 11:31:00",
      "eventadditionalinfo": "NadeemQA",
      "cif": "687687",
      "firstloaddate": "20201231235959",
      "firstauthdate": "2000-04-22 11:31:00",
      "email": "felix.cuevas@svf.com",
      "acct.type": "PLCC"
   }
}



RESPONSE:
{
   "transid": "NadeemNewRequest14",
   "eventName": "PayfoneDataService JavaAPI.Insert",
   "eventTimestamp": "2019-12-10 09:04:08",
   "serverName": "10.245.345",
   "requestMetadata": {
      "version": {
         "major": "1",
         "minor": "1",
         "patch": "0",
         "versionDate": "2019-12-04 17:04:08"
      }
   },
   "response": {
      "code": "EDLMYSQLUPO00",
      "flag": "Y",
      "message": "Success",
      "operation": "insert"
   }
}

In most cases it should be success,still go to step 2 and make sure this details are added successfully.

Step 2: Run the GET Details API to cross verify if the insert happened fine.

REPLACE the phone number with the one received in request ANI
URL: https://edlpayfonedataservice.app.qa.pcf.syfbank.com/payfonedata/getDetailsByPhoneNumber

Request:
{
   "transld": "TestPCCBENROLL3",
   "eventName": "PayfoneDataService.JavaAPI.Read",
   "eventTimestamp": "2021-03-25T10:04:08.015",
   "serverName": "10.245.345",
   "requestMetadata": {
      "version": {
         "major": "001",
         "minor": "002",
         "patch": "0500",
         "versionDate": "2021-03-27T15:55:42-04:00"
      }
   },
   "request": {
      "phonenumber": "4806654304"
   }
}

RESPONSE :
This will be a detailed response.
Last call date will tell you exact time data was inserted in this API.

Step 3:Go to the data base and run the below queries

Login to Data base: to check the lookup ID by using the below queries
SELECT * FROM rubptyqa01.lookup_s where sys= '9356 [this is coming from excel sheet sys param]


Step 4:Pay Phone Applicator API to capture

https://payfoneapplicatorservice-v2-uat.app.dev.use1.pcf.syfbank.com/ANIMatchRestSvc/V2/fetchANI

Request:
{
   "header": {
      "username": "ANISearch",
      "password": "Ani5e@rc#5erv!ce",
      "transactionId": "04192022013007"
   },
   "body": {
      "phoneNumber": "4807074304",
      "lookupld": "F10SAMCO",
      "ob": "collectionda"
   }
}

Response:

This will be detailed response
And this will mark the closure of the conditioning scenario 1.

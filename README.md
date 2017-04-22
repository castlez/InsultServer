# InsultServer
Scala applications that maintains a persistent list of insults, which can be added to or randomly retrieved.

### To Run
I wrote this in Intellij so I would suggest you import the project from version control. Ensure Scala (version 2.11.7 or higher) and Playframework Support (version 1.0 or higher) is installed correctly.

### API 
##### GET 
`Endpoint: /insultme`  
`Result: a random insult pulled from insults.txt.  If insults.txt doesnt exist, you get insulted anyway.`  

##### POST
`Endpoint: /add/insult`  
`Result: A success message if the addition worked, an error if it didn't`  

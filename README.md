### Wikipedia Parsing/Querying Tool

- This project has demonstrated the use of several different scripts and tools in order to download and store 10,000 random Wikipedia articles.

- All articles are stored in a MySQL database where there are roughly 5000 articles in English and 5000 articles in Japanese

- In order to support easily importing the articles, the open source python wikipedia project was used `Link` <https://pypi.org/project/wikipedia/>

- Access to the articles is exposed in the form of a RESTful API built using the Java Spring Boot Framework

##Running the Java service
- The service is packaged with Maven and can be started on port 9020 by running 
`$ java -jar /prod/software/wikiProject/java/target/wikiProject-0.0.1-SNAPSHOT.jar`

##Running the Python Flask service
- Additionally there is a python service which mimics the same API functionality of the Java service which can be started by default on port 5000 with the command
`$python /prod/software/wikiProject/python/pythonWikiApp.py`
**In order to access this service, simply start it, and replace the port numbers in the example below with 5000**



##API
- Once running, the following API endpoints are made available to localhost on Port 9020

1. GET `http://localhost:9020/wikiPage/{id}`

This endpoint will return a JSON resource representing the Wikipedia page, including the **title** , **content**, and **url**

2. GET `http://localhost:9020/wikiPage?param1=val1&param2=val2`

This endpoint will return a list of Wikipedia page resources as JSON which match the provided query.  **Note** by default the query performs a LIKE search and will return any results which contain the values provided.  As an example the following query can be performed

	GET http://localhost:9020/wikiPage?title=japan

Which will return all pages which contain the text 'japan' within their titles

###Reversing text
>There is an optional query param which can be passed called **reverse**.  If the param is passed with a value of true, all text within the content of matching articles will be returned in reverse String order.  

Any of these endpoints can be queried from within the console using **wget** or by opening **firefox** and entering the url into the browser

##Scripts and MongoDB

Two python scripts have been used for this project, both of which are in the directory  `/prod/softwared/wikiProject/utils`

1. `mongoInsertion.py`
	This script was used to randomly collect 1000 of the 10,000 articles within the MySQL database and store them within the local mongo database instance.  The 1000 articles are stored in the db called **content** and in the **collection** pages
	
2. `wikiFetcher.py`
	This script was created in order to utilize the python wikipedia article library to pull 10,000 random articles and store them in the local MySQL instance.  The script takes the languge to use as a parameter.










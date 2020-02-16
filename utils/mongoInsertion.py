#!/usr/bin/python

from pymongo import MongoClient
import mysql.connector
import random
import pdb

MONGO_HOST='localhost'
MONGO_PORT=27017
MONGO_DB='content'
MONGO_COLLECTION='pages'

MYSQL_HOST='localhost'
MYSQL_DB='wiki'
MYSQL_USER='root'
MYSQL_PASS='root'

mongoConnection = MongoClient(MONGO_HOST, MONGO_PORT)
wikiCollection = mongoConnection[MONGO_DB][MONGO_COLLECTION]

mysqlConnection = mysql.connector.connect(
    host = MYSQL_HOST,
    user = MYSQL_USER,
    passwd = MYSQL_PASS,
    database = MYSQL_DB
)

mysqlCursor = mysqlConnection.cursor()

#choose random record from between the 10000 stored wikipages
randomPageId = random.randint(1,10000)
sql = "SELECT title, body, url FROM page WHERE id =" + str(randomPageId) + ";"
mysqlCursor.execute(sql)
wikiPage = mysqlCursor.fetchone()

wikiPageForMongo = {'title': wikiPage[0], 'content': wikiPage[1], 'url': wikiPage[2], 'references':[]}

referenceQuerySql = "SELECT uri FROM reference WHERE page_id =" + str(randomPageId) + ";"
mysqlCursor.execute(referenceQuerySql)
references = mysqlCursor.fetchall()



for ref in references:
	wikiPageForMongo['references'].append(ref)


wikiCollection.insert(wikiPageForMongo)
pdb.set_trace()




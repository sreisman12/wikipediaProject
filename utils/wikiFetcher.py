#!/usr/bin/python

import requests
import pdb
import mysql.connector
import wikipedia
import sys

URL = "https://en.wikipedia.org/api/rest_v1/page/random/summary"
ENGLISH_WIKI_URL = "https://en.wikipedia.org/w/api.php?action=query&list"
JAPANESE_WIKI_URL = "https://jp.wikipedia.org/w/api.php?action=query&list"

def createRefTuple(ref):
	return (pageId, ref)

pageid = 0

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="root",
  database="wiki"
)

mycursor = mydb.cursor()
count = int(sys.argv[1])
print(str(sys.argv[1]))

while count < 5000:
	try:
		content = wikipedia.WikipediaPage(title=wikipedia.random())
	except wikipedia.DisambiguationError, err:
		#pdb.set_trace()
		content = wikipedia.page(err.options[0])
	try:
		title = content.title
	except wikipedia.DisambiguationError, err:
		pdb.set_trace()
		title = err.options[0]
	sql = "INSERT INTO page (title, body, url) VALUES (%s, %s, %s)"
	val = (title, content.content.encode(encoding='UTF-8', errors='strict'), content.url)
	print("Inserting page: " + content.title)
	try:
		mycursor.execute(sql, val)
		pageId = mycursor.lastrowid
		references = content.references

		#pdb.set_trace()
		refInsertSql = "INSERT INTO reference (page_id, uri) VALUES (%s, %s)"
		refValues = map(createRefTuple, references)
		mycursor.executemany(refInsertSql, refValues)

		mydb.commit()
		count+=1
		#pdb.set_trace()
		print("count is now: " +str(count))
	except:
		print("Exception caught skipping this page")
		pass




#!/usr/bin/python

import requests
import pdb
import mysql.connector
import wikipedia

URL = "https://en.wikipedia.org/api/rest_v1/page/random/summary"
ENGLISH_WIKI_URL = "https://en.wikipedia.org/w/api.php?action=query&list"
JAPANESE_WIKI_URL = "https://jp.wikipedia.org/w/api.php?action=query&list"


#r = requests.get(url =  URL)

#pdb.set_trace()
#data = r.json()

content = wikipedia.WikipediaPage(title=wikipedia.random())
print(content.content)


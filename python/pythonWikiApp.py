from flask import Flask, request, jsonify
import mysql.connector
import pdb

mysqlDb = mysql.connector.connect(
    host="localhost",
    user="root",
    passwd="root",
    database="wiki",
)

dbCursor = mysqlDb.cursor()

app = Flask(__name__)


@app.route("/wikiPage/<id>")
def fetchPageById(id):
    dbCursor.execute("SELECT * FROM page WHERE id=" + id + ";")
    wikiPage = dbCursor.fetchone()
    return jsonify(wikiPage)


@app.route("/wikiPage")
def fetchPagesByParams():
    reverse = False
    searchKeys = request.args.keys()
    query = "SELECT * FROM page WHERE "

    paramsList = []
    for key in searchKeys:
        if key != "reverse":
	    print ("key " + key)
            paramsList.append( key + "  LIKE \'%" + request.args[key] + "%\'")
	else:
	   reverse = request.args[key] == 'true'
    i = 0

    for param in paramsList:
        if i != len(paramsList) - 1:
	    print("ABOUT TO APPEND param: " + param)
            query = query + param + " AND "
        else:
            query = query + param
	i+=1

    query = query + ";"

    print(query)
    dbCursor.execute(query)
    wikiPages = dbCursor.fetchall()
    pagesToReturn = []
    for page in wikiPages:
	if reverse:
		textToReverse = page[3]
		splitText = textToReverse.split(" ")
		textReversed = [word[::-1] for word in splitText]
		pagesToReturn.append((page[0], page[1], page[2], " ".join(textReversed)))
	else:
		pagesToReturn.append(page)
    return jsonify(pagesToReturn)


if __name__ == "__main__":
    app.run(debug=True)

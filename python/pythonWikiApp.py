from flask import Flask, request, jsonify
import mysql.connector

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
	searchKeys = request.args.keys()
	query = "SELECT * FROM page WHERE "
	
	paramsList = []
	for key in searchKeys:
		if(key is not "reverse"):
			paramsList.append(query + key + "  LIKE '%" + str(searchKeys[key] + "%'")

	for i, param in paramsList:
	    if i != len(paramsList) - 1:
	        query = query + param + " AND "
	    else:
	        query = query + param
	query = query + ";"

	dbCursor.execute(query)
	wikiPages = dbCursor.fetchall()
	return jsonify(wikiPages)

if __name__=="__main__":
	app.run(debug=True)

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
	
	tempParams = []
	for key in searchKeys:
		if(key is not "reverse"):
			tempParams.append(query + key + "  LIKE '%" + str(searchKeys[key] + "%'")
	
	return str(request.args.keys())

if __name__=="__main__":
	app.run(debug=True)

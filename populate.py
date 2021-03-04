import requests
import json
import random

PEOPLE_DB_URL = "http://localhost:8080/api/db/people"
RELATIONSHIP_DB_URL = "http://localhost:8080/api/db/relationships"

headers = {'Content-type': 'text/plain'}

def populatePeople():
    data_url = "https://randomuser.me/api/?results=50"
    data = requests.get(data_url).json()["results"]

    def createPerson(name, school):
        person_data = json.dumps({"name":name, "school":school, "actionCode":"CREATE"})
        requests.post(url=PEOPLE_DB_URL, data=person_data, headers=headers)

    for person in data:
        name = person["name"]["first"] + " " + person["name"]["last"]
        school = person["location"]["city"]
        createPerson(name, school)


def createRelationship(p1, p2):
	relationship_data = json.dumps({"personId1":p1, "personId2":p2, "actionCode":"CREATE_RELATIONSHIP"})
	requests.post(url=RELATIONSHIP_DB_URL, data=relationship_data, headers=headers)

def populateRelationships():
	min_ = 2
	max_ = 50

	for i in range(20):
		p1 = random.randint(min_, max_)
		p2 = random.randint(min_, max_)
		createRelationship(p1, p2)


populateRelationships()
// a function that gets all from database and sends JSON to all functions
// singleton?
// return JSON
// I want to start loading get all facts upon signing in

// export
function getAllFacts(){
    let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let facts = JSON.parse(xhr.responseText);
 //               console.log(facts);
            }
        }
//    if (typof getAllFacts.instance === 'object'); {
//        return getAllFacts.instance;
//    }

        xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/facts", true);
        xhr.send();
        return facts;
       // console.log(facts);
}

function getFactsFactory(facts){
    return facts;
//    if (typeof getFactsFactory.instance === 'object') {
//     return getFactsFactory.instance;
//    }
//    this.facts = facts;
//    getFactsFactory.instance = this;
//    return this;
}


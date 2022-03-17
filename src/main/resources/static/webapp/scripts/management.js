//Management Questions
// Charts
// What is the most common payment type? Table/barchart/pie chart?
// What percentage of all transactions fail to process? Pie Chart
// Tables
//Not a question: show all from data mart
//What is the most common payment type per country? table
//Which three countries have the most sales revenue? table (switch with button)

// Extras in table
// Transaction Success Rates by Country
// Total Orders by country
// Total Product Sold by country
// Top transaction Fail reason by country? stretch goal

//properties needed:
    // product: price
    // payment: id?
    // payment: paymentType
    // payment: paymentTxnSuccess
    // payment: failureReason?
    // order: qty
    // customer: country




// ---------------------------
// Event Handlers for Buttons
// ---------------------------
//document.addEventListener("load", getFactsFactory);
//document.addEventListener("load", getMgmtMart); // load mgmt mart
//document.getElementById("getMgmtMart").addEventListener("load", getMgmtMart);
//document.getElementById("getByCountry").addEventListener("click", getByCountry)
//document.getElementById("SalesByCountry").addEventListener("click", getSalesByCountry);

// -------------------------------
// Get All Facts
// -------------------------------
let factsArray = [];
function getAllFacts(){
    let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                
                let facts = JSON.parse(xhr.responseText);
                factsArray=facts
                getByCountry();

            }
        }

        xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/facts", true);
        xhr.send();
       // getTxnChartData();
       // getTypeChartData();
        
}


// -----------------------------------------------------
// Table 1: Get Payment Type & Sales Revenue by Country
// -----------------------------------------------------
function getByCountry(){
    mainMap=createTable(factsArray);
//     aggregate payment type
//     aggregate quantity (total Sales)
//     aggregate Revenue
    let x = document.getElementById("mgmtStatsTable");
    x.remove();

    let table = document.createElement("table");
    table.setAttribute("id", "mgmtStatsTable");
    table.setAttribute("class", "table table-striped table-bordered table-sort sortable");
    let thead = document.createElement("thead");
    thead.setAttribute("id", "thead");
    let tbody = document.createElement("tbody");
    tbody.setAttribute("id", "tbody");
    table.appendChild(thead);
    table.appendChild(tbody);
    document.getElementById("mgmtDiv").appendChild(table);

    // Create table header array
    let header = [
        "Country",
        "Top Payment Type",
        "Revenue", // arrow
        "Product Sold", // arrow
        "Transaction Success Rates", // arrow
        "Total Orders",
        //"Top Transaction Failure Reason"
    ];

    // Create table header row
    let headerRow = document.createElement("tr");
    header.forEach(function (header) {
        let th = document.createElement("th");
        th.setAttribute("style", "cursor: pointer");
        th.innerHTML = header;
        headerRow.appendChild(th);
    });
    thead.appendChild(headerRow);

//    let mgmtObjectArray = [];
//    for (let i = 0; i < response.length; i++) {
//        let mgmtObject = response[i];
//        mgmtObjectArray.push(mgmtObject);
//    }
    

    
    // Create table body
    for (let key of mainMap.keys()) {
        for(let key1 of mainMap.get(key).keys()){
        let row = document.createElement("tr");
        let country = document.createElement("td");
        country.innerHTML = key;
        
        row.appendChild(country);
        let paymentType = document.createElement("td");
        paymentType.innerHTML = mainMap.get(key).get(key1).get("TopPaymentType");
        
        row.appendChild(paymentType);
        let revenue = document.createElement("td");
        revenue.innerHTML = mainMap.get(key).get(key1).get("Revenue");
       
        row.appendChild(revenue);
        let productSold = document.createElement("td");
        productSold.innerHTML = key1
        
        row.appendChild(productSold);
        let txnSuccess = document.createElement("td");
        txnSuccess.innerHTML = ((mainMap.get(key).get(key1).get("TransSuc")/(mainMap.get(key).get(key1).get("TransSuc")+mainMap.get(key).get(key1).get("TransFail")))*100);
        
        row.appendChild(txnSuccess);
        let totalOrders = document.createElement("td");
        totalOrders.innerHTML = mainMap.get(key).get(key1).get("TotalOrder");
        

        row.appendChild(totalOrders);
        table.append(row);

    }
    
//    sorttable.makeSortable(table);

}
}


// -------------------------------------------
// Pie Chart for Transaction Success/Failure
// -------------------------------------------
function getTxnChartData(){
    //     Transactions failed:
    //     access fail/success
    //     calculate percentage
    //     Display in pie chart

    
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = JSON.parse(xhr.responseText);
            let labels = [];
            let data = [];
            for (let i = 0; i < response.length; i++) {
                if (labels.indexOf(response[i].paymentTxnSuccess) == -1) {
                    labels.push(response[i].paymentTxnSuccess);
                    data.push(1);
                } else {
                    data[labels.indexOf(response[i].paymentTxnSuccess)]++;
                }
            }
                let ctx = document.getElementById('pieChart1').getContext('2d');
                let myChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Number of Transactions',
                            data: data,
                            backgroundColor: ['rgba(0, 182, 0, .75)', 'rgba(237, 20, 0, .75)'],
                            borderColor: 'rgba(0, 0, 0, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        scales: {
                            y: {
                                display: false,
                                beginAtZero: true
                            }
                        },
                    }
                });
            }
        }
        xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/payments", true);
        xhr.send();
    
}
    
// ------------------------------
// Pie Chart for Payment Types?
// ------------------------------
function getTypeChartData(){
    // create an array of unique payment types
    // count how many types there are
    let chartStatus = Chart.getChart("barChart1");
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = JSON.parse(xhr.responseText);
            console.log(response)
            arr = paymentType1(response);
            console.log(arr);
            let labels = [];
            let data = [];
            let paymentTypeCount = {};
            let topPaymentType = [];
            let paymentType = [];
            for (let i = 0; i < response.length; i++) {
                // if the paymentType at index i of response is not in paymentTypeCount, include that payment type and add 1
                if (paymentTypeCount[response[i].paymentType] == undefined) {
                paymentTypeCount[response[i].paymentType] = 1;
                }else {
                // if it is, just add 1 to the corresponding paymentType count
                paymentTypeCount[response[i].paymentType]++;
                }
                // find the top 5? most popular payment types
                let topPT = "";
                let topPaymentTypeCount = 0;
                for (let key in topPaymentTypeCount) {
                    if (paymentTypeCount[key] > topPaymentTypeCount) {
                        topPT = key;
                        topPaymentTypeCount = paymentTypeCount[key];
                    }
                }
                paymentType.push(topPT);

//                 push labels in paymentType to labels
//                 push data in paymentTypeCount to Data

                if (labels.indexOf(paymentType[i]) == -1) {
                    labels.push(paymentType[i].paymentType);
                    data.push(1);
                } else {
                    data[labels.indexOf(paymentType[i].paymentType)]++;
                }
            }

            let ctx = document.getElementById('barChart1').getContext('2d');
            let myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: arr[0],
                    datasets: [{
                        label: 'Payment Types',
                        data: arr[1],
                        backgroundColor: ['rgba(0, 182, 0, .75)', 'rgba(237, 20, 0, .75)'],
                        borderColor: 'rgba(0, 0, 0, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    scales: {
                        y: {
                            display: false,
                            beginAtZero: true
                        }
                    },
                }
            });
        }
    }
    xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/payments", true);
    xhr.send();

}

function paymentType1(data){
    labelArr=[]
    barHeightArr=[]
    centralArray=[]
    packagedArray=[]
    theMap=new Map();
    for( i=0;i<data.length;i++){
        theMap.set(data[i]['paymentType'],0)

    }
    console.log(theMap)
    for( i=0;i<data.length;i++){
       
        theMap.set(data[i]['paymentType'],theMap.get(data[i]['paymentType'])+1)
        

    }
    const iterator1 = theMap.entries();

    for(const val of iterator1){
        arr1=[]
        arr1.push(val[0])
        arr1.push(val[1])
        centralArray.push(arr1)

    }
    newarr=centralArray.sort(function compare(a,b){
        if(a[1]>b[1]){
            return 1
        }else if(a[1]<b[1]){
            return -1
        }else{
            return 0
        }

    })
    for(i=0;i<newarr.length;i++){
        labelArr.push(newarr[i][0])
        barHeightArr.push(newarr[i][1])
    }
    packagedArray.push(labelArr)
    packagedArray.push(barHeightArr)
    return packagedArray;

}


function createTable(data){
    map=new Map();
    innerMap0=new Map();
    innerMap1=new Map();
    innerMap2=new Map();
    startVal=0;
    topPymntTyp=''
    for(i=0; i<data.length;i++){
        if(map.get(data[i].customerEntity.country)==undefined){
        map.set(data[i].customerEntity.country,new Map())}
        
        if(map.get(data[i].customerEntity.country).get(data[i].productEntity.productName)==undefined){
        map.get(data[i].customerEntity.country).set(data[i].productEntity.productName,new Map())}

        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('Revenue',0)
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TransSuc',0)
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TransFail',0)
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TotalOrder',0)
        
        if(map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal')==undefined){
            
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('PaymentTypetotal',new Map())}
       
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').set(data[i].paymentEntity.paymentType,0)
        
    }
    for(i=0; i<data.length;i++){
        
        console.log(map)
        console.log(data[i].customerEntity.country)
       
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('Revenue',
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('Revenue')+
        data[i].orderEntity.price*data[i].orderEntity.qty)



        if(data[i].paymentEntity.paymentTxnSuccess=='Y'){
            map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TransSuc',
            map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('TransSuc')+1) 
        }else{
            map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TransFail',
            map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('TransFail')+1) 
        }

        
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TotalOrder',
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('TotalOrder')+data[i].orderEntity.qty)

        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').set(data[i].paymentEntity.paymentType,
            map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').get(data[i].paymentEntity.paymentType)+1)
        
    }
    for(i=0;i<data.length;i++){
        for(let key of map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').keys()){
            if(map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').get(key)>startVal){
                topPaymentType=key
                startVal=map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).get('PaymentTypetotal').get(key)
            }


        }
        map.get(data[i].customerEntity.country).get(data[i].productEntity.productName).set('TopPaymentType',topPaymentType)
        topPaymentType=''
        startVal=0

  
    
}

return map;


}





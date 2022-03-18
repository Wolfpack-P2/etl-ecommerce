//Research Questions
// Charts
// What is the average quantity of items purchased per transaction? not a graph, just a dynamic div?
// How much does each customer spend on average^^^
// Which days of the week are best for product sales? Barchart

// Table
// How much does each customer spend on average Per Country?
// Extra question: What is the average quantity of items purchased per transaction? per country?
$(document).ready(function () {
    getAllResearch();
});

function getAllResearch(){
    let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let response = JSON.parse(xhr.responseText);
                console.log(response);
            let x = document.getElementById("researchTable");
            x.remove();

            let table = document.createElement("table");
            table.setAttribute("id", "researchTable");
            table.setAttribute("class", "table table-striped table-bordered table-sort sortable");
            let thead = document.createElement("thead");
            thead.setAttribute("id", "thead");
            let tbody = document.createElement("tbody");
            tbody.setAttribute("id", "tbody");
            table.appendChild(thead);
            table.appendChild(tbody);
            document.getElementById("researchDiv").appendChild(table);
            // Create table header array
            let header = [
                "Country",
                "Average Sale Per Transaction",
                "Average Quantity of Items Per Sale"
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

            let researchArray = [];
            for (let i = 0; i < response.length; i++) {
                let research = response[i];
                researchArray.push(research);
            }
            let countries = [];
            let averageSale = [];
            let averageQty = [];
            for(let i = 0; i < researchArray.length; i++){
                if (countries.indexOf(researchArray[i].country) == -1) {
                    countries.push(researchArray[i].country);
                    averageSale.push(0);
                    averageQty.push(0);

                    let countryIndex = countries.indexOf(researchArray[i].country);
                    if (researchArray[i].paymentTxnSuccess == "Y"){
                        averageSale[countryIndex] += researchArray[i].totalPrice;
                        averageQty[countryIndex] += researchArray[i].qty;
                    }
                }
           }
            for (let i = 0; i < countries.length; i++) {
                let row = document.createElement("tr");
                let country = document.createElement("td");
                country.innerHTML = countries[i];
                row.appendChild(country);

                let sale = document.createElement("td");
                sale.innerHTML = averageSale[i];
                row.appendChild(sale);

                let qty = document.createElement("td");
                qty.innerHTML = averageQty[i];
                row.appendChild(qty);

                table.append(row);
            }

//            sorttable.makeSortable(table);

        }
    }
    xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/research", true);
    xhr.send();
    getDayBarChart();
}

function getDayBarChart(){
    let chartStatus = Chart.getChart("barChart");
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = JSON.parse(xhr.responseText);
            const labels = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
            const data = [0, 0, 0, 0, 0, 0, 0];
            // put all dates in response into an array called dates
            for (let i = 0; i < response.length; i++) {
//          datesArr.push(response.orderDate[i]);
            const d = new Date(response[i].orderDate);
            let day = d.getDay();
                if (day == 0) {
                    data[0]++;
                } else if (day == 1) {
                    data[1]++;
                } else if (day == 2) {
                    data[2]++;
                } else if (day == 3) {
                    data[3]++;
                } else if (day == 4) {
                    data[4]++;
                } else if (day == 5) {
                    data[5]++;
                } else {
                    data[6]++;
                }
            }
            let ctx = document.getElementById('barChart').getContext('2d');
            let myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Sales by Day of Week',
                        data: data,
                        backgroundColor: 'rgba(0, 40, 255, 0.59)',
                        borderColor: 'rgba(0, 40, 255, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }
    }
    xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/orders", true);
    xhr.send();

}
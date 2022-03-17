//Research Questions
// Charts
// What is the average quantity of items purchased per transaction? not a graph, just a dynamic div?
// How much does each customer spend on average^^^
// Which days of the week are best for product sales? Barchart

// Table
// How much does each customer spend on average Per Country?
// Extra question: What is the average quantity of items purchased per transaction? per country?

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
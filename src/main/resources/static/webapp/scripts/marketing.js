//Marketing Questions
// CHARTS
// What is the top selling category of items?
// How does the popularity of products change throughout the year? (by most popular product each month) line graph
// What times have the highest traffic of sales?

// TABLES
//What is the top selling category of items Per Country? (country table- most popular item)
//How does the popularity of products change throughout the year Per Country? (country table - view button)
//Which locations see the highest traffic of sales?(country table - highest performing city)
//What times have the highest traffic of sales? Per Country? (country table-highest traffic)
function $(x) {
    return document.getElementById(x)
}
x=0;

let catUrl="http://localhost:8080/ETL-E-Commerce/order/category"
/* function drawChart() {
    // Define the chart to be drawn.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Element');
    data.addColumn('number', 'Percentage');
    data.addRows([
      ['Nitrogen', 0.78],
      ['Oxygen', 0.21],
      ['Other', 0.01]
    ]);

    var options = {
        backgroundColor: '#1b232e'
    }

    // Instantiate and draw the chart.
    var chart = new google.visualization.PieChart($('my-pie-chart'));
    chart.draw(data, options);
  } */

  function drawDataComp() {
    let chartData = new google.visualization.arrayToDataTable([
      ['Data', 'Clean', 'Dirty'],
      [1000, 732, 268]
    ])

    let chart = new google.visualization.BarChart(document.getElementById('bar-div'));
    let options = {
      bars: 'horizontal',
      width: '900',
      backgroundColor: '#363c4d',
      hAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      vAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      legend: {
        textStyle: {
          color: '#ffffff'
        }
      }
    }

    chart.draw(chartData, options)
  }

  async function drawColumnChart() {

    let chartData = new google.visualization.DataTable();
    chartData.addColumn('string', 'Product Category');
    chartData.addColumn('number', 'Order Volume');

    await fetch(catUrl)
    .then((resp) => {return resp.json()})
    .then(data => {data.forEach(element => {
        chartData.addRow([element.product_category, element.count])});
    })
    .catch(error => {console.log(error)})
                      
    var chart = new google.visualization.ColumnChart(document.getElementById('column-div'));
    
    let options = {
      title: "Order Volume per Product Category",
      titleTextStyle: {
        color: '#ffffff'
      },
      backgroundColor: '#363c4d',
      width: '1000',
      height: '450',
      hAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      vAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      legend: {
        textStyle: {
          color: '#ffffff'
        }
      },
      annotations: {
        textStyle: {
          fontSize: 10
        }
      }
    }

    chart.draw(chartData, options);


  }

  async function drawTable() {
    await fetch(catUrl)
    .then(resp => {
      return resp.json()
    })
    .then(data => {
      data.forEach(element => {
        let tr = document.createElement('tr')
        let th = document.createElement('th')
        th.innerHTML = element.product_category
        let td = document.createElement('td')
        td.innerHTML = element.count
        tr.append(th)
        tr.append(td)
        $('category-table').append(tr)
      })
    })
  }

  async function drawRegionsMap() {


    let chartData = new google.visualization.DataTable();
    chartData.addColumn('string', 'Country');
    chartData.addColumn('string', 'Product Category');
    chartData.addColumn('number', 'Order Volume');
      

    await fetch ('http://localhost:8080/ETL-E-Commerce/order/category/country')
    .then(resp => {
      return resp.json()
    })
    .then(data => {
      data.forEach(element => {
        chartData.addRow([element.country, element.product_category, element.count])
      })
    })
    .catch(error => {
      console.log(error)
    })

    var options = {
        backgroundColor: '#363c4d',
        width: '900',
        height: '450'
    };

    var chart = new google.visualization.GeoChart(document.getElementById('regions-div'));

    chart.draw(chartData, options);
  }

  async function drawBarChart() {
    let chartData = [
      ['Month', 'Baby', 'Clothing', 'Electronics', 'Grocery', 'Home Essentials', 'Home Improvement', 'Patio & Garden'],
    ['Jan'],
    ['Feb'],
    ['Mar'],
    ['Apr'],
    ['May'],
    ['Jun'],
    ['Jul'],
    ['Aug'],
    ['Sep'],
    ['Oct'],
    ['Nov'],
    ['Dec']
    ]
    await fetch('http://localhost:8080/ETL-E-Commerce/order/year')
    .then(resp => {
      return resp.json()
    })
    .then(data => {
      data.forEach(element => {
       chartData[parseInt(element.month)].push(element.count)
      })
    })

    let viz = google.visualization.arrayToDataTable(chartData)

      

      var options = {
       backgroundColor: { fill: "#363c4d" },
        width: '1050',
        height: '500',
        hAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      vAxis: {
        textStyle: {
          color: '#ffffff'
        }
      },
      legend: {
        textStyle: {
          color: '#ffffff'
        }
      },
      annotations: {
        textStyle: {
          fontSize: 10
        }
      }
      };

      var chart = new google.charts.Bar(document.getElementById('step-div'));
      chart.draw(viz, google.charts.Bar.convertOptions(options));
    }

    async function drawGeoChart() {


      let chartData = new google.visualization.DataTable();
      chartData.addColumn('string', 'Country');
      chartData.addColumn('number', 'Order Volume');
        
  
      await fetch ('http://localhost:8080/ETL-E-Commerce/order/sales/country')
      .then(resp => {
        return resp.json()
      })
      .then(data => {
        data.forEach(element => {
          chartData.addRow([element.country, element.count])
        })
      })
      .catch(error => {
        console.log(error)
      })
  
      var options = {
          backgroundColor: '#363c4d',
          width: '1000',
          height: '500'
      };
  
      var chart = new google.visualization.GeoChart(document.getElementById('geo-div'));
  
      chart.draw(chartData, options);
    }
   

    function getQ3Data(){
      //     Transactions failed:
      //     access fail/success
      //     calculate percentage
      //     Display in pie chart
        select=document.getElementById('q3Div')
      
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
          if (xhr.readyState == 4 && xhr.status == 200) {
              let response = JSON.parse(xhr.responseText);
             console.log(response)
             if(x<1){
             getCountrysAndDrDown(response)
            }
            x++;
            if(document.getElementById("3").value=='All Countrys'||document.getElementById("select x category").value=='country'){
              arr=populateBarChart(response,10,document.getElementById("select x category").value);
              getCountrysAndDrDown(response)
            }else{
             arr=populateBarChart1(response,10,document.getElementById("select x category").value,document.getElementById("3").value);
            }
                  let ctx = document.getElementById('Q3').getContext('2d');
                  let chartStatus = Chart.getChart('Q3');
                  if (chartStatus != undefined) {
                      chartStatus.destroy();
                  }

                  let myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: arr[0],
                        datasets: [{
                            label: 'top tansactions per location',
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
          xhr.open("GET", "http://localhost:8080/ETL-E-Commerce/marketing", true);
          xhr.send();
      
  } 
  
function populateBarChart1(data,value,breakdown,country){
  labelArr=[]
  barHeightArr=[]
  centralArray=[]
  packagedArray=[]
    map=new Map();
   
 
    for(i=0; i<data.length;i++){
      if(data[i].country==country){
        map.set(data[i][breakdown],0)
      }
        
       

    }
    for(i=0; i<data.length;i++){
      if(data[i].country==country){
      
      map.set(data[i][breakdown],map.get(data[i][breakdown])+1)
    }
     
    }
  const iterator1 = map.entries();

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
    
    packagedArray.push(labelArr.splice(labelArr.length-value-1,labelArr.length-1))
    packagedArray.push(barHeightArr.splice(barHeightArr.length-value-1,barHeightArr.length-1))
    console.log(map)
    console.log(packagedArray)
    return packagedArray;
      
    
}
function populateBarChart(data,value,breakdown){
  
  labelArr=[]
  barHeightArr=[]
  centralArray=[]
  packagedArray=[]
    map=new Map();
   
 
    for(i=0; i<data.length;i++){
       
        map.set(data[i][breakdown],0)
       
        
       

    }
    for(i=0; i<data.length;i++){
      
      
      map.set(data[i][breakdown],map.get(data[i][breakdown])+1)
      
     
    }
  const iterator1 = map.entries();

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
    
    packagedArray.push(labelArr.splice(labelArr.length-value-1,labelArr.length-1))
    packagedArray.push(barHeightArr.splice(barHeightArr.length-value-1,barHeightArr.length-1))
    console.log(map)
    console.log(packagedArray)
    return packagedArray;
      
    
}
function getCountrysAndDrDown(data){
  map=new Map();
  for(i=0; i<data.length;i++){
    if(map.get(data[i].country)==undefined){
    map.set(data[i].country,0)}

}
div=document.getElementById('2')
div.innerHTML=""
select=document.createElement('select')
select.setAttribute('onchange',"getQ3Data()")
select.setAttribute('id',"3")
option1=document.createElement('option')
option1.innerHTML="All Countrys"
option1.setAttribute('value','All Countrys')
 select.append(option1)

for(let key of map.keys()){

 option=document.createElement('option')
 option.innerHTML=key
 option.setAttribute('value',key)
 select.append(option)
  

}
div.append(select);

}

//Marketing Questions
// CHARTS
// What is the top selling category of items?
// How does the popularity of products change throughout the year? (by most popular product each month) line graph
// What times have the highest traffic of sales?

// TABLES
//What is the top selling category of items Per Country? (country table- most popular item)
//How does the popularity of products change throughout the year Per Country? (country table - view button)
//Which locations see the highest traffic of sales?(country table - highest city)
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
              xlabel = changeLabels(arr[0],document.getElementById("select x category").value);
            }else{
             arr=populateBarChart1(response,10,document.getElementById("select x category").value,document.getElementById("3").value);
             xlabel = changeLabels(arr[0],document.getElementById("select x category").value);
            }
                  let ctx = document.getElementById('Q3').getContext('2d');
                  let chartStatus = Chart.getChart('Q3');
                  if (chartStatus != undefined) {
                      chartStatus.destroy();
                  }

                  let myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: xlabel,
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


function changeLabels(xData,value){
  xlabels =[]
  if(value == "qty" || value == "country" || value == "city" || value == "productCategory")
  {
    for (i = 0; i<xData.length;i++){
      xlabels.push(xData[i])
    }

  }
  else if(value == "timeOfDay"){
    for (i = 0; i<xData.length;i++){
      if (xData[i] > 12) {
        newtime = xData[i] - 12;
        xlabels.push(newtime +' PM')
      }
      if (xData[i] < 12) {
        xlabels.push(xData[i]+' AM')
      }
    }


  }
  else if(value == "months"){
    for (i = 0; i<xData.length;i++){
      if (xData[i] == 1) {
        xlabels.push("January")
      }
      if (xData[i] == 2) {
        xlabels.push("February")
      }
      if (xData[i] == 3) {
        xlabels.push("March")
      }
      if (xData[i] == 4) {
        xlabels.push("April")
      }
      if (xData[i] == 5) {
        xlabels.push("May")
      }
      if (xData[i] == 6) {
        xlabels.push("June")
      }
      if (xData[i] == 7) {
        xlabels.push("July")
      }
      if (xData[i] == 8) {
        xlabels.push("August")
      }
      if (xData[i] == 9) {
        xlabels.push("September")
      }
      if (xData[i] == 10) {
        xlabels.push("October")
      }
      if (xData[i] == 11) {
        xlabels.push("November")
      }
      if (xData[i] == 12) {
        xlabels.push("December")
      }

    }

  }
  
  return xlabels;

}
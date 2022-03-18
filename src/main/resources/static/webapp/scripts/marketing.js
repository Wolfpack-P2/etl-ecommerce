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
$(document).ready(function () {
    marketingTable();
});
function mark




   

    function getQ3Data(){
      //     Transactions failed:
      //     access fail/success
      //     calculate percentage
      //     Display in pie chart
  
      
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
          if (xhr.readyState == 4 && xhr.status == 200) {
              let response = JSON.parse(xhr.responseText);
             console.log(response)
             arr=populateBarChart(response,10,'country');
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
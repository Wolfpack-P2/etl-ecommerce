function $(x) {
    return document.getElementById(x)
}

function fetchUser() {
    let header = $("dashboard-heading")
    header.innerHTML = `Dashboard`
}


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


  async function drawRegionsMap() {
    var data = google.visualization.arrayToDataTable([
      ['Country', 'Category', "Sales"],
      ['Germany', "Snitzel", 1000],
      ['United States', "Guns", 300],
      ['Brazil', "Coconuts", 400],
      ['Canada', "Maple Syrup", 500],
      ['France', "Baguets", 600],
      ['RU', "Violence", 700]
    ]);

    var options = {
        backgroundColor: '#363c4d',
        width: '900',
        height: '450'
    };

    var chart = new google.visualization.GeoChart(document.getElementById('regions-div'));

    chart.draw(data, options);
  }

    /* let geoTab = $("nav-geochart")
    console.log(geoTab)
    geoTab.click(function(){
      $(this).tab('show');
    }) */

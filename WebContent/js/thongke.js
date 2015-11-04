      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Ghe ngoi', 7],
          ['Ghe trong', 3]
        ]);

        // Set chart options
        var options = {'title':'',
                       'width':700,
                       'height':600};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('thongketheotuyen'));
        chart.draw(data, options);
      }



//Thong ke theo thang
google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Element', 'Khach di', { role: 'style' }],
          ['1', 10, '#428BCA'],            // RGB value
           ['2', 8.94, '#428BCA'],            // RGB value
            ['3', 22, '#428BCA'],            // RGB value
             ['4', 25.3, '#428BCA'],            // RGB value
              ['5', 35.1, '#428BCA'],            // RGB value
               ['6', 8.94, '#428BCA'],            // RGB value
                ['7', 45.2, '#428BCA'],            // RGB value
                 ['8', 8.94, '#428BCA'],            // RGB value
                  ['9', 22.36, '#428BCA'],            // RGB value
                   ['10', 8.94, '#428BCA'],            // RGB value
                    ['11', 52.3, '#428BCA'],            // RGB value
                     ['12', 8.94, '#428BCA'],            // RGB value
       
        ]);

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('thongketheothang'));
        chart.draw(data, options);
      }
      
      
/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace()

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        '2020.07.10',
        '2020.07.13',
        '2020.07.14',
        '2020.07.15',
        '2020.07.16',
        '2020.07.17',
        '2020.07.20'
      ],
      datasets: [{
        data: [
          52700,
          53400,
          53800,
          54700,
          53800,
          54400,
          54400
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
}())

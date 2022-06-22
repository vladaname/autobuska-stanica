<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<canvas id="myChart" width="400" height="200"></canvas>
	<script>
				var labels = [];
				var dataD = [];
				var counter = 0;
				<c:forEach var = "obj" items = "${podaci}">
					var objLabel = {
							value : '${obj[1]}'
					};
					var objData = {
							value :'${obj[0]}'
					};
					labels[counter] = objLabel.value;
					dataD[counter] = objData.value;
					counter++;
				</c:forEach>
				console.log(labels);
				console.log(dataD);
                var ctx = document.getElementById("myChart").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                       labels: labels,

							datasets: [{
                            label: 'Broj polazaka',
                            data: dataD,
                            
                            backgroundColor: [
                                'rgba(153, 102, 255, 0.2)'
                            ],
                            borderColor: [
                                'rgba(153, 102, 255, 1)'
                            ],
                            borderWidth: 1
                        }
                        ]

                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero:true
                                }
                            }]
                        },
                        title: {
                            display: true,
                            text: 'Broj polzaka po liniji'
                        }
                    }
                });
            </script>

</body>
</html>
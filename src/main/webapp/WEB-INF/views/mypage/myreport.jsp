<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/chart.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div class="my-report">
        <h2>마이리포트</h2>
        <h3>당신은 웹툰 샐러드의</h3>
        <p>
		    <span class="rank">${userRank}위</span> / ${totalUsers}명 중 상위 
		    <span class="percentage">${percentage}%</span> 의 독자!
		</p>

        <h3>플랫폼 별 웹툰 찜한 비율</h3>
        <div class="chart-container">
            <canvas id="platformChart"></canvas>
        </div>

        <h3>요일 별 웹툰 찜한 비율</h3>
        <div class="chart-container">
            <canvas id="weekdayChart"></canvas>
        </div>

        <script>
	        async function fetchData(url) {
	            const response = await fetch(url);
	            return response.json();
	        }
	
	        async function renderChart() {
	            const platformData = await fetchData('${pageContext.request.contextPath}/api/report/platform-ratio');
	            const weekdayData = await fetchData('${pageContext.request.contextPath}/api/report/weekday-ratio');
	
	            const platformLabels = platformData.map(data => data['PROVIDER']);
	            const platformCounts = platformData.map(data => data['COUNT']);
	            
	            // 요일 순서 배열
	            const weekdayOrder = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN'];
	            
	            // weekdayData를 weekdayOrder 순서에 맞게 정렬
	            const sortedWeekdayData = weekdayOrder.map(day => {
	                return weekdayData.find(data => data['UPDATEDAYS'] === day) || { UPDATEDAYS: day, COUNT: 0 };
	            });
	            
	            const weekdayLabels = sortedWeekdayData.map(data => data['UPDATEDAYS']);
	            const weekdayCounts = sortedWeekdayData.map(data => data['COUNT']);
	            
	            // 정렬된 데이터에서 최대값 찾기
	            const maxCount = Math.max(...weekdayCounts);
	            const backgroundColors = weekdayCounts.map(count => count === maxCount ? '#FF6384' : '#36A2EB');
	
	            const platformCtx = document.getElementById('platformChart').getContext('2d');
	            new Chart(platformCtx, {
	                type: 'pie',
	                data: {
	                    labels: platformLabels,
	                    datasets: [{
	                        data: platformCounts,
	                        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56']
	                    }]
	                },
	                options: {
	                    responsive: true,
	                    maintainAspectRatio: false,
	                    devicePixelRatio: 2,  // 고해상도 설정
	                }
	            });
	
	            const weekdayCtx = document.getElementById('weekdayChart').getContext('2d');
	            new Chart(weekdayCtx, {
	                type: 'bar',
	                data: {
	                    labels: weekdayLabels,
	                    datasets: [{
	                        data: weekdayCounts,
	                        backgroundColor: backgroundColors
	                    }]
	                },
	                options: {
	                    responsive: true,
	                    maintainAspectRatio: false,
	                    scales: {
	                        y: {
	                            beginAtZero: true
	                        }
	                    },
	                    devicePixelRatio: 2,  // 고해상도 설정
	                    plugins: {
	                        legend: {
	                            display: false // 범례 숨기기
	                        }
	                    }
	                }
	            });
	        }
	
	        renderChart();
        </script>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="my-report">
    <h2>마이리포트</h2>
    <canvas id="platformChart"></canvas>
    <canvas id="weekdayChart"></canvas>
    <script>
        async function fetchData(url) {
            const response = await fetch(url);
            return response.json();
        }

        async function renderChart() {
            const platformData = await fetchData('${pageContext.request.contextPath}/api/report/platform-ratio');
            const weekdayData = await fetchData('${pageContext.request.contextPath}/api/report/weekday-ratio');

            const platformCtx = document.getElementById('platformChart').getContext('2d');
            new Chart(platformCtx, {
                type: 'pie',
                data: {
                    labels: platformData.map(data => data.provider),
                    datasets: [{
                        data: platformData.map(data => data.count),
                        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56']
                    }]
                }
            });

            const weekdayCtx = document.getElementById('weekdayChart').getContext('2d');
            new Chart(weekdayCtx, {
                type: 'bar',
                data: {
                    labels: weekdayData.map(data => data.updatedays),
                    datasets: [{
                        data: weekdayData.map(data => data.count),
                        backgroundColor: '#36A2EB'
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

        renderChart();
    </script>
</div>

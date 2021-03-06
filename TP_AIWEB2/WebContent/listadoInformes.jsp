<%@ page import="java.util.*" %>
<%@ page import="view.*" %>

<a href="#"><strong><i class="glyphicon glyphicon-envelope"></i>
		Listado de Informes</strong></a>
		<hr>

<div>

	<h4>Lista de Informes de Auditor�a</h4>
	<table id="table_conf" class="table">
		<tr>
			<th>M�dulo</th>
			<th>Descripci�n</th>
			<th>Fecha</th>
			<th>Hora</th>
		</tr>
		<tbody id="tbody">	
				
		</tbody>
	</table>
	<hr>
	<button id="consultar_informes" type="button" class="btn btn-success">Consultar Informes</button>
	<button id="enviar_informes" type="button" class="btn btn-primary">Enviar Informes</button>
</div>


<script type="text/javascript">
	$(document).ready(function() {

		var ip = "localhost";
		var puerto = "8080";
		var json;
		var timerInterval = 0;
		var flag = 0;	
		
		$("#enviar_informes").click(function(){
			
				$.ajax({
					type : "POST",
					data : {"informes" : JSON.stringify(json)},
					url : "informes",
					success : function(data) {
						alert("Informes enviados");
						$("#tbody").empty();
						clearInterval(timerInterval);
						$("#consultar_informes").removeClass("btn-warning");
						$("#consultar_informes").addClass("btn-success");
						flag = 0;
					}		
				});
			});

		/* $("#consultar_informes").click(function(){
			$.ajax({
				type : "GET",
				dataType : "json",
				url : "rest/logsMonitor/all",
				success : function(data) {
					
					var cantidadFilas = $('#tbody tr').length;
					json = data;
					if(data.length > cantidadFilas){
							
						$("#tbody").empty();
						$.each(data, function(i, val) {	

							var fecha = formatFecha(val.fecha);
							var hora = formatHora(val.fecha);
																				
							$('#tbody').append("<tr><td>"+val.modulo+"</td><td>"+val.descripcion+"</td><td>"
									+fecha+"</td><td>"+hora+"</td></tr>");
							});
						}
					}
				});	
			}); */

			$("#consultar_informes").click(function(){

				if(flag == 0){
					flag = 1;
					$("#consultar_informes").removeClass("btn-success");
					$("#consultar_informes").addClass("btn-warning");
				}
				else{
					$("#consultar_informes").removeClass("btn-warning");
					$("#consultar_informes").addClass("btn-success");
					flag = 0;
				}
				
				timerInterval = setInterval(function() {
					if(flag == 1){
					$.ajax({
						type : "GET",
						dataType : "json",
						url : "rest/logsMonitor/all",
						success : function(data) {

							var cantidadFilas = $('#tbody tr').length;
							json = data;
							if(data.length > cantidadFilas){
									
								$("#tbody").empty();
								$.each(data, function(i, val) {	

									var fecha = formatFecha(val.fecha);
									var hora = formatHora(val.fecha);
																						
									$('#tbody').append("<tr><td>"+val.modulo+"</td><td>"+val.descripcion+"</td><td>"
											+fecha+"</td><td>"+hora+"</td></tr>");
								});
							}
						}
					})};
			}, 2000);
			});
			

			function formatFecha(date) {
			    var d = new Date(date),
			        month = '' + (d.getMonth() + 1),
			        day = '' + d.getDate(),
			        year = d.getFullYear();

			    if (month.length < 2) month = '0' + month;
			    if (day.length < 2) day = '0' + day;

			    return [day, month, year].join('/');
			}

			function formatHora(date) {
			    var d = new Date(date),
			    hour = "" + d.getHours(); if (hour.length == 1) { hour = "0" + hour; }
			    minute = "" + d.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
			    second = "" + d.getSeconds(); if (second.length == 1) { second = "0" + second; }

			    return [hour, minute, second].join(':');
			}	
		
		});
	
</script>

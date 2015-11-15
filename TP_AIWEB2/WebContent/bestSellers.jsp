<%@ page import="java.util.*" %>
<%@ page import="view.*" %>

<a href="#"><strong><i class="glyphicon glyphicon-signal"></i>
		Ranking Best Sellers</strong></a>
		<hr>
<%
	List<BestSellerView> ranking = (List<BestSellerView>) request.getAttribute("bestSellers");
%>
<div>

	<h4>Lista de Best Sellers</h4>
	<table id="table_conf" class="table">
		<thead>
			<tr>
				<th>Ranking</th>
				<th>Id Art�culo</th>
			</tr>
		</thead>
		<tbody id="tbody_conf">	
			<%if(ranking.size() > 0) {
				for(BestSellerView b : ranking){%>
				<tr>
					<td><%= b.getRanking() %></td>
					<td><%= b.getIdArticulo() %></td>
				<tr>
			<% }
			}%>
		</tbody>
	</table>
	
	<form id="enviar-ranking">
		<input type="number" name="id">
		<button type="submit" class="btn btn-primary">Enviar Ranking</button>
	</form>	
	<div id="modal-enviar-ranking" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">Informaci�n</h4>
	      </div>
	      <div class="modal-body">
	        <p id="modal-enviar-ranking-text"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

</div>


<script src="js/bestSellers.js"></script>
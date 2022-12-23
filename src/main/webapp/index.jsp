<%@ page import="model.bean.Job"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<style type="text/css">
	.table {
		width: 70%;
		margin: 0 auto;
		overflow: hidden;
	}
	
	.tb-col-job {
		width: 90%;
	}
	
	.tb-row-text {
		text-decoration: line-through;
	}
</style>
</head>
<body class="bg-secondary">
	<%
		List<Job> listJobs = (List<Job>) request.getAttribute("jobs");
	%>

	<div class="container mt-5 rounded">
		<header class="d-flex justify-content-center">
			<h1 class="text-warning">TO DO LIST</h1>
		</header>

		<div class="text-center mb-5 mt-5">
			<a href="ShowCreateServlet" class="btn btn-success">Create</a>
		</div>

		<article>
			<table class="table bg-light rounded">
				<thead class="thead-dark">
					<tr>
						<th class="tb-col-job" scope="col">Job</th>
						<th class="text-center" scope="col">Handle</th>
					</tr>
				</thead>
				<tbody>
				<%	if (listJobs.size() == 0) { %>
					<tr>
						<td class="text-center" colspan="2">
							<p>No job</p>
						</td>
					</tr>
				<%	} else { %>
				<%	for (Job job : listJobs) { %>
					<tr>
						<%	if (job.isStatus()) { %>
							<td class="tb-row-text"><%=job.getTitle() %></td>
						<%	} else { %>
							<td><%=job.getTitle() %></td>
						<%	} %>
						<td>
							<div class="btn-group" role="group" aria-label="Basic example">
								<a href="ShowEditServlet?id=<%=job.getId()%>" class="btn btn-info">Edit</a>
								<a href="DoneJobServlet?id=<%=job.getId()%>" class="btn btn-success">Done</a>
								<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal<%=job.getId()%>">Delete</button>
							</div>
							
							<div class="modal fade" id="deleteModal<%=job.getId()%>" tabindex="-1" role="dialog"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title text-danger" id="exampleModalLabel">WARNING</h5>
										</div>
										<div class="modal-body">Bạn có chắc muốn xoá không?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-danger" onclick="handleDelete(<%=job.getId()%>)">Delete</button>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				<%	} %>
				<%	} %>
				</tbody>
			</table>
		</article>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		function handleDelete(id) {
			window.location.href = "DeleteJobServlet?id=" + id;
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<link rel="stylesheet" href="/static/css/board.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form method="post" action="/auth/signup">
		<table>
			<thead>
				<tr>
					<th>
						제목
					</th>
					<td>
						<input type="text" class="board-title">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>
						작성자
					</th>
					<td>
						<input type="text" class="board-writer">
					</td>
				</tr>
				<tr>
					<th>
						내용
					</th>
					<td>
						<textarea class="board-content" rows="50" cols="100"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<td colspan="2">
					<button type="button" class="write-button">작성하기</button>
				</td>
			</tfoot>
		</table>
	</form>
	<script type="text/javascript" src="/static/js/board/board_insert.js"></script>
</body>
</html>
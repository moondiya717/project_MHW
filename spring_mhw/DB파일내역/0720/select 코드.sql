select board.*,
		if(a.up is null, 0, a.up) as up,
		if(b.down is null, 0, b.down) as down from board
	left join (select count(*) as up, board from recommend where state = 1 group by board) -- join을쓰면 조건에 맞는것만나옴(추천이있는것만), left join을쓰면 모든 게시글 다 나옴
		as a on num = a.board
	left join (select count(*) as down, board from recommend where state= -1 group by board)
		as b on num = b.board
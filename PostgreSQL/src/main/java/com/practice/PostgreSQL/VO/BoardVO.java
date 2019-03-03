package com.practice.PostgreSQL.VO;

import lombok.Data;

@Data
public class BoardVO {

	int board_id;
	String user_id;
	String title;
	String content;
	String insert_date;
	
}

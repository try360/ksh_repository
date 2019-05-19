package com.practice.PostgreSQL.VO;

import lombok.Data;

@Data
public class BoardVO extends SearchVO {

	int board_id; 
	String user_id;
	String title;
	String content;
	String insert_date;
	
}

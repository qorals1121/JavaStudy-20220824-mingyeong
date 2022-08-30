BEGIN
	delete
	from
		user_dtl
	where
		user_code = OLD.user_code;
		
END
BEGIN
	INSERT into
		USER dtl(user_code)
		VALUES(NEW.user_code);
END
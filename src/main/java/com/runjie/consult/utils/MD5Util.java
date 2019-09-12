package com.runjie.consult.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
	public static String MD5 (String str) {
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
}

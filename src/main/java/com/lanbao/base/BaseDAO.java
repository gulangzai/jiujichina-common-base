package com.lanbao.base;

import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;




public class BaseDAO {

	 
	 public static String EncodeJsString(String s) {
	        StringBuilder sb = new StringBuilder();
	        // sb.append("\"");
	        // for (char c : s)
	        // {
	        for (int j = 0; j < s.length(); j++) {
	            char c = s.charAt(j);
	            switch (c) {
	            case '"':
	                sb.append("\\\"");
	                break;
	            case '\\':
	                sb.append("\\\\");
	                break;
	            case ' ':
	                sb.append("\\b");
	                break;
	            case '\f':
	                sb.append("\\f");
	                break;
	            case '\n':
	                sb.append("\\n");
	                break;
	            case '\r':
	                sb.append("\\r");
	                break;
	            case '\t':
	                sb.append("\\t");
	                break;
	            case '>':
	                sb.append("&gt;");
	                break;
	            case '<':
	                sb.append("&lt;");
	                break;

	            default:
	                int i = (int) c;
	                if (c >= '\u0000' && c <= '\u001F') {
	                    String ss = Integer.toHexString(c);
	                    sb.append("\\u");
	                    for (int k = 0; k < 4 - ss.length(); k++) {
	                        sb.append('0');
	                    }
	                    sb.append(ss.toUpperCase());
	                } else {
	                    sb.append(c);
	                }
	                break;
	            }
	        }
	        // sb.append("\"");

	        return sb.toString();
	    }
	 
	 
	 

}

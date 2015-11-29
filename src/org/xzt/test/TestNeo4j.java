package org.xzt.test;

import java.util.List;
import java.util.Map;

import com.neo4j.BaseDao;

public class TestNeo4j {
	public static void main(String[] args) {
		BaseDao ins = new BaseDao();
		String sql = "MATCH (:Movie {title:{1}})<-[:ACTED_IN]-(a:Person) RETURN a.name as actor";
		List<Map<String, Object>> list = ins.queryList(sql, "The Matrix");
		System.out.println("------------------------");
		System.out.println(list);
	}
}

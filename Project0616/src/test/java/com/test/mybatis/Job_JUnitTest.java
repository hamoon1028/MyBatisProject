package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.min.edu.model.IJob;
import com.min.edu.model.JobImpl;

public class Job_JUnitTest {

	private IJob dao = new JobImpl();
	
	@Test
	public void updateJobId() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldJob_id", "IT_PROG");
		map.put("newJob_id", "IT_FROG");
		boolean isc = dao.updateJobId(map);
		assertTrue(isc);
	}

}

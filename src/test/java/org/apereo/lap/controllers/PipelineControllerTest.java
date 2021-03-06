/**
 * Copyright 2013 Unicon (R) Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.apereo.lap.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apereo.lap.model.PipelineConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PipelineControllerTest {

	private static final Logger logger = LoggerFactory
			.getLogger(PipelineControllerTest.class);

	@Autowired
	PipelineController pipelineController;

	@Test
	public void testRootGet() {
		assertNotNull(pipelineController);
		Map<String, Object> map = pipelineController.rootGet();
		assertNotNull(map);

		List<PipelineConfig> processors = (List<PipelineConfig>) map
				.get("processors");
		assertTrue(processors.size() > 0);
		logger.info("Test successful in loading pipeline processors");
	}

	@Test
	public void testGetType() {
		assertNotNull(pipelineController.getType("sample"));
		logger.info("Test successful in fetching pipeline config for type sample using pipeline controller ");
	}
	
	// FIXME

//	@Test
//	public void testPostType() {
//		assertTrue(pipelineController.postType("sample"));
//		logger.info("Test successful in starting pipeline for type sample using pipeline controller ");
//	}

//	@Test
//	public void testPostTypeWithInvalidType() {
//		assertTrue(pipelineController.postJsonType("sample", "{}"));
//		logger.info("Test successful in starting pipeline for type sample with json using pipeline controller ");
//	}
	
}

package cn.clxy.tools.core.memo.service.impl;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.clxy.tools.core.memo.domain.Tag;

public class TagServiceClientImplTest {

	private static TagServiceClientImpl service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TagServiceClientImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void testSearchAll() {
		print(service.searchAll());
	}

	@Test
	public void testEdit() {

		Tag tag = new Tag();
		tag.setName("test");
		service.edit(tag);

		List<Tag> tags = service.searchAll();
		Assert.assertTrue(tags.contains(tag));
	}

	@Test
	public void testDelete() {

		Tag tag = new Tag();
		tag.setName("testDelete");
		service.edit(tag);
		print(service.searchAll());

		service.delete(tag);
		print(service.searchAll());

		List<Tag> tags = service.searchAll();
		Assert.assertFalse(tags.contains(tag));
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	private static void print(List<Tag> tags) {

		System.out.println("Started at " + new Date());
		for (Tag t : tags) {
			System.out.println(t);
		}
		System.out.println();
	}
}

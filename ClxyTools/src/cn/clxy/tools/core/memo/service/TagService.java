package cn.clxy.tools.core.memo.service;

import java.util.List;

import cn.clxy.tools.core.memo.domain.Tag;

/**
 * Tag servie.
 * @author clxy
 */
public interface TagService {

	List<Tag> searchAll();

	List<Tag> search(String name);

	void edit(Tag tag);

	void delete(Tag tag);
}

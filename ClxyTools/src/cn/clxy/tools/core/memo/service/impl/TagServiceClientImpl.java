package cn.clxy.tools.core.memo.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.exception.LogicException;
import cn.clxy.tools.core.memo.domain.Tag;
import cn.clxy.tools.core.memo.service.TagService;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * For desktop client like swing.
 * @author clxy
 */
public class TagServiceClientImpl implements TagService {

    private static List<Tag> tags;

    public TagServiceClientImpl() {

        tags = MemoClientWorker.getTags();
    }

    public List<Tag> searchAll() {
        return new ArrayList<Tag>(tags);
    }

    public void edit(final Tag tag) {

        if (tag == null) {
            return;
        }

        final String newName = tag.getName();

        Predicate<Tag> p = new Predicate<Tag>() {

            public boolean apply(Tag compareTag) {
                if (compareTag == tag) {
                    return false;
                }
                String name = compareTag.getName();
                return BeanUtil.equals(name, newName);
            }
        };

        List sameNames = Lists.newArrayList(Iterators.filter(tags.iterator(), p));
        if (sameNames.size() > 0) {
            throw new LogicException("Dulplied tag!");
        }

        if (tag.getId() == null) {
            tag.setId(tag.getEditInfo().getCreateTime().getTime());
            tags.add(tag);
        }

        save();
    }

    public void delete(Tag tag) {
        if (tags.remove(tag)) {
            save();
        }
    }

    public List<Tag> search(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Save tag infomation to file.
     */
    private void save() {
        MemoClientWorker.save();
    }
}

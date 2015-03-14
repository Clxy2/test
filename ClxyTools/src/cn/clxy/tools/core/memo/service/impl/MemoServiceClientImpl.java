package cn.clxy.tools.core.memo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.common.StringUtil;
import cn.clxy.tools.core.memo.domain.Memo;
import cn.clxy.tools.core.memo.domain.Tag;
import cn.clxy.tools.core.memo.service.MemoService;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * For desktop client like swing.
 * @author clxy
 */
public class MemoServiceClientImpl implements MemoService {

    private static List<Memo> memos;
    private static final Log log = LogFactory.getLog(MemoServiceClientImpl.class);

    /**
     * Constructor.<br>
     * Read memo information from file.
     */
    public MemoServiceClientImpl() {

        memos = MemoClientWorker.getMemos();
    }

    public void delete(List<Memo> deleteMemos) {

        for (Memo memo : deleteMemos) {
            memos.remove(memo);
        }
        save();
    }

    public void edit(Memo memo) {

        if (memo.getId() == null) {
            long maxId = MemoClientWorker.getMaxId();

            maxId++;
            MemoClientWorker.setMaxId(maxId);

            memo.setId(maxId);
            memos.add(memo);
        }

        save();
    }

    /**
     * Save all.
     * @param memos
     * @param deleteMemos
     */
    public void merge(List<Memo> memos, List<Memo> deleteMemos) {
        save();
    }

    public List<Memo> search(Map<String, Object> condition) {

        log.debug(condition.toString());

        final String content = (String) condition.get("content");
        final Tag tag = (Tag) condition.get("tag");
        final Boolean finished = (Boolean) condition.get("finished");

        Predicate<Memo> p = new Predicate<Memo>() {

            public boolean apply(Memo memo) {

                if (!StringUtil.isBlank(content) && memo.getContent().indexOf(content) < 0) {
                    return false;
                }

                if (tag != null && !BeanUtil.equals(memo.getTag(), tag)) {
                    return false;
                }

                if (!finished && memo.getFinished()) {
                    return false;
                }

                return true;
            }
        };

        ArrayList<Memo> result = Lists.newArrayList(Iterators.filter(memos.iterator(), p));
        Collections.sort(result, defaultSorter);
        return result;
    }

    private Comparator<Memo> defaultSorter = new Comparator<Memo>() {

        public int compare(Memo m1, Memo m2) {

            Boolean f1 = m1.getFinished();
            Boolean f2 = m2.getFinished();
            int result = f1.compareTo(f2);
            if (result != 0) {
                return result;
            }

            Date u1 = m1.getEditInfo().getUpdateTime();
            Date u2 = m2.getEditInfo().getUpdateTime();

            result = u2.compareTo(u1);

            return result;
        }
    };

    /**
     * Save memo infomation to file.
     */
    private void save() {
        MemoClientWorker.save();
    }
}

package cn.clxy.tools.core.memo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.clxy.tools.core.common.StringUtil;
import cn.clxy.tools.core.memo.domain.Memo;
import cn.clxy.tools.core.memo.domain.Tag;
import cn.clxy.tools.core.memo.service.MemoService;
import cn.clxy.tools.core.tx.Transactional;

/**
 * For jpa implemetion.
 * @author clxy
 */
public class MemoSeviceJPAImpl implements MemoService {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void delete(List<Memo> deleteMemos) {

        for (Memo memo : deleteMemos) {
            em.remove(memo);
        }
    }

    @Transactional
    public void edit(Memo memo) {

        em.merge(memo);
    }

    public void merge(List<Memo> memos, List<Memo> deleteMemos) {
        // TODO Auto-generated method stub
        throw new NoSuchMethodError();
    }

    public List<Memo> search(Map<String, Object> condition) {

        String sql = "SELECT m FROM Memo m where ";
        List<String> keys = new ArrayList<String>();

        final String content = (String) condition.get(keyContent);
        if (!StringUtil.isBlank(content)) {
            sql += "m.content like :content";
            keys.add(keyContent);
        }

        final Tag tag = (Tag) condition.get(keyTag);
        if (tag != null) {
            sql += keys.size() > 0 ? " and " : "" + "m.tag = : tag";
            keys.add(keyTag);
        }

        final Boolean finished = (Boolean) condition.get(keyFinished);
        if (!finished) {// only not finished.
            sql += keys.size() > 0 ? " and " : "" + "m.finished = false";
        }

        Query query = em.createQuery(sql);
        for (String key : keys) {
            query.setParameter(key, condition.get(key));
        }

        log.debug(query);

        return query.getResultList();
    }

    private final static String keyContent = "content";
    private final static String keyTag = "tag";
    private final static String keyFinished = "finished";
    private static final Log log = LogFactory.getLog(MemoSeviceJPAImpl.class);
}

package cn.clxy.tools.core.memo.service;

import java.util.List;
import java.util.Map;

import cn.clxy.tools.core.memo.domain.Memo;

/**
 * Memo servie.
 * @author clxy
 */
public interface MemoService {

    /**
     * Edit a memo.
     * @param memo
     */
    void edit(Memo memo);

    /**
     * Search Memo by condition.
     * @param condition
     * @return
     */
    List<Memo> search(Map<String, Object> condition);

    /**
     * Delete memo
     * @param deleteMemos
     */
    void delete(List<Memo> deleteMemos);

    void merge(List<Memo> memos, List<Memo> deleteMemos);
}

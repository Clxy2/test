package cn.clxy.tools.core.memo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.memo.domain.Memo;
import cn.clxy.tools.core.memo.domain.Tag;

final class MemoClientWorker {

    private static final String fileName = "memo.data";
    private static MemoInfo mi = null;
    private static final Log log = LogFactory.getLog(MemoClientWorker.class);
    // initialization.
    static {
        try {
            mi = (MemoInfo) BeanUtil.deserialize(fileName);
        } catch (Exception e) {
            mi = new MemoInfo();
            log.info("Error getting memo information:" + e);
        }
    }

    public static List<Tag> getTags() {
        return mi.getTags();
    }

    public static List<Memo> getMemos() {
        return mi.getMemos();
    }

    public static Long getMaxId() {
        return mi.getMaxId();
    }

    public static void setMaxId(Long maxId) {
        mi.setMaxId(maxId);
    }

    public static void save() {

        try {
            BeanUtil.serialize((Serializable) mi, fileName);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private MemoClientWorker() {
    }

    /**
     * Memo information.
     * @author clxy
     */
    static class MemoInfo implements Serializable {

        private Long maxId;
        private List<Tag> tags;
        private List<Memo> memos;
        /**
         * Default serial version.
         */
        private static final long serialVersionUID = 1L;

        public MemoInfo() {

            tags = new ArrayList<Tag>();
            memos = new ArrayList<Memo>();
            maxId = 0l;
        }

        public List<Memo> getMemos() {
            return memos;
        }

        public void setMemos(List<Memo> memos) {
            this.memos = memos;
        }

        public Long getMaxId() {
            return maxId;
        }

        public void setMaxId(Long maxId) {
            this.maxId = maxId;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }
    }
}

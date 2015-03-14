package cn.clxy.tools.core.memo.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.common.domain.EditInfo;

/**
 * Memo.
 * @author clxy
 */
@Entity
@NamedQueries( { @NamedQuery(name = "memo.search", query = "SELECT m FROM Memo m ") })
public class Memo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean finished = false;

    private String content;

    @OneToOne
    private Tag tag;

    @Embedded
    @AttributeOverrides( {})
    private EditInfo editInfo = new EditInfo();

    /**
     * Default serial version id.
     */
    private static final long serialVersionUID = 1L;

    public Memo() {
    }

    @Override
    public boolean equals(Object obj) {
        return BeanUtil.equals(obj, this, "id");
    }

    @Override
    public int hashCode() {
        return BeanUtil.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public EditInfo getEditInfo() {
        return editInfo;
    }

    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }
}

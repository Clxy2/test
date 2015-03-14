package cn.clxy.tools.core.memo.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.common.domain.EditInfo;

@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides( {})
    private EditInfo editInfo = new EditInfo();

    /**
     * Default serial version id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object obj) {
        return BeanUtil.equals(this, obj, "id");
    }

    @Override
    public int hashCode() {
        return BeanUtil.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EditInfo getEditInfo() {
        return editInfo;
    }

    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

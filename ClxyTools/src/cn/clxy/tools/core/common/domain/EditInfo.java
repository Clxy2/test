package cn.clxy.tools.core.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Editing information.
 * @author clxy
 */
@Embeddable
public class EditInfo implements Serializable {

    private String updateUser;

    private String createUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * Default serial version id.
     */
    private static final long serialVersionUID = 1L;

    public EditInfo() {
        Date now = new Date();
        createTime = now;
        updateTime = now;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
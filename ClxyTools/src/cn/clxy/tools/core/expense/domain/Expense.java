package cn.clxy.tools.core.expense.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.clxy.tools.core.common.BeanUtil;
import cn.clxy.tools.core.common.domain.EditInfo;

@Entity
@NamedQueries( { @NamedQuery(name = "expense.search", query = "SELECT e FROM Expense e WHERE "
		+ "e.time = :time and  e.item.id = :itemId") })
public class Expense implements Serializable {

	/**
	 * Default version id.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Edit information.
	 */
	@Embedded
	private EditInfo editInfo;

	private Double number;

	private Double cost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	private String note;

	@OneToOne
	@JoinColumn(name = "itemId")
	private Item item;

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
		return BeanUtil.toString(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EditInfo getEditInfo() {
		return editInfo;
	}

	public void setEditInfo(EditInfo editInfo) {
		this.editInfo = editInfo;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}

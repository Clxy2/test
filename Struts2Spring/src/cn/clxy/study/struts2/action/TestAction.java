package cn.clxy.study.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private Integer id;
	private String name;
	private List<String> articleTypeList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getArticleTypeList() {
		return articleTypeList;
	}

	public void setArticleTypeList(List<String> articleTypeList) {
		this.articleTypeList = articleTypeList;
	}

	public String getTypeList() throws Exception {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@getTypeList");
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		this.articleTypeList = list;
		return SUCCESS;
	}

	private static final long serialVersionUID = 1L;
}

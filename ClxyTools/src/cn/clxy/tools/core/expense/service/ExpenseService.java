package cn.clxy.tools.core.expense.service;

import java.util.List;
import java.util.Map;

import cn.clxy.tools.core.expense.domain.Expense;

/**
 * @author clxy
 */
public interface ExpenseService {

	List<Expense> search(Map condition);

	void delete(List<Expense> list);

	void merge(List<Expense> saveList, List<Expense> deleteList);

}

package com.seekandbuy.haveabeer.match;
import java.util.List;


public interface SearchItems {
	public <T> List<T> ListAllProductsByUser(Long id);
}

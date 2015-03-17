package bishe.dao;

import java.util.List;

import bishe.model.Peixun;

public interface PeixunDao  {
	
	
	
	public void insertBean(Peixun Peixun);
	
	public void deleteBean(Peixun Peixun);
	
	public void updateBean(Peixun Peixun);

	public Peixun selectBean(String where);
	
	public List<Peixun> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}

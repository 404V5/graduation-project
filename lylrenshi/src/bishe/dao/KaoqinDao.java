package bishe.dao;

import java.util.List;

import bishe.model.Kaoqin;

public interface KaoqinDao  {
	
	
	
	public void insertBean(Kaoqin Kaoqin);
	
	public void deleteBean(Kaoqin Kaoqin);
	
	public void updateBean(Kaoqin Kaoqin);

	public Kaoqin selectBean(String where);
	
	public List<Kaoqin> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}

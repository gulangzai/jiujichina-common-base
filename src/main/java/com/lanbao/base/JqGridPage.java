package com.lanbao.base;

import java.util.List;

public class JqGridPage<T> {
	
	
	private boolean search = false;
	private String keyword = null;
	
	private Integer page;    //当前页
	private Integer total;   //总共多少页 （返回）
	private Integer records; //总共条数  （返回)
	private Integer rows;    //每页多少行
	
    private PageData pd = new PageData();
	List<PageData> data = null;
	
	public JqGridPage(){
		try {
			this.rows = Integer.parseInt(Tools.readTxtFile(Const.PAGE));
		} catch (Exception e) {
			this.rows = 15;
		}
	}

	public Integer getPage() { 
		if(page>getTotal())
			page = getTotal();  
		if(page<=0)
			page = 1;
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() { 
		if(records%rows==0) 
			total = records/rows;
		else
			total = records/rows+1; 
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		if(records%rows==0) 
			total = records/rows;
		else
			total = records/rows+1; 
		this.records = records;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public PageData getPd() {
		return pd;
	}

	public void setPd(PageData pd) {
		this.pd = pd;
	}

	public List<PageData> getData() {
		return data;
	}

	public void setData(List<PageData> data) {
		this.data = data;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCurrentResult() {
		// TODO Auto-generated method stub 
		if(this.getPage()<1){
			this.setPage(1);
		}
		return (this.getPage()-1)*this.getRows();
	}
  
	
	
}

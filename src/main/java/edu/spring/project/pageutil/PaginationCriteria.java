package edu.spring.project.pageutil;

public class PaginationCriteria {
	private int page;
	private int numsPerPage;
	
	public PaginationCriteria() {
		this.page = 1;
		this.numsPerPage = 9;
	}

	public PaginationCriteria(int page, int numsPerPage) {
		this.page = page;
		this.numsPerPage = numsPerPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumsPerPage() {
		return numsPerPage;
	}

	public void setNumsPerPage(int numsPerPage) {
		this.numsPerPage = numsPerPage;
	}
	
	public int getStart() {
		return (page - 1) * numsPerPage + 1;
	}
	
	public int getEnd() {
		return page * numsPerPage;
	}
	
	
	
	
	
}

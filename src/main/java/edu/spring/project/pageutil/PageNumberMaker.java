package edu.spring.project.pageutil;

public class PageNumberMaker {
	private PaginationCriteria criteria;
	private int totalCount;
	private int numsOfLink;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	public PageNumberMaker() {
		this.numsOfLink = 2; 
	}

	public PageNumberMaker(PaginationCriteria criteria, int totalCount, int numsOfLink, int startPage, int endPage,
			boolean prev, boolean next) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		this.numsOfLink = numsOfLink;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}

	public PaginationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PaginationCriteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNumsOfLink() {
		return numsOfLink;
	}

	public void setNumsOfLink(int numsOfLink) {
		this.numsOfLink = numsOfLink;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void setPageMakerData() {
		int totalPageNum = (int) 
				Math.ceil((double) totalCount / criteria.getNumsPerPage());
		int temp = (int)
				Math.ceil((double) criteria.getPage() / numsOfLink) * numsOfLink;
		
		if (temp > totalPageNum) {
			endPage = totalPageNum;
		} else {
			endPage = temp;
		}
		
		startPage = ((endPage - 1) / numsOfLink) * numsOfLink + 1;
		
		if (startPage == 1) { 
			this.prev = false;
		} else {
			this.prev = true;
		}
		
		if (endPage * criteria.getNumsPerPage() >= totalCount) {
			this.next = false;
		} else {
			this.next = true;
		}
	}
	
	
	
}












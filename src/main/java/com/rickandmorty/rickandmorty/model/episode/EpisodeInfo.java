package com.rickandmorty.rickandmorty.model.episode;

public class EpisodeInfo {
	
	    private int count;

	    private int pages;

	    private String next;

	    private Object prev;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}

		public String getNext() {
			return next;
		}

		public void setNext(String next) {
			this.next = next;
		}

		public Object getPrev() {
			return prev;
		}

		public void setPrev(Object prev) {
			this.prev = prev;
		}
	    
	    

}

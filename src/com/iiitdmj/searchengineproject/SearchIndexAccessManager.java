package com.iiitdmj.searchengineproject;

public class SearchIndexAccessManager {
	
	    private IndexMap index_map;
	    public SearchIndexAccessManager()
	    {}
	    public IndexMap getIndex() { return this.index_map; }
	    public void setIndex(IndexMap new_index) { this.index_map = new_index; }
	    SearchIndexAccessManager(IndexMap new_index) { this.index_map = new_index;  }

	    static final private SearchIndexAccessManager INSTANCE = new SearchIndexAccessManager(new IndexMap());
	    static public  SearchIndexAccessManager getInstance() { return INSTANCE; }
}




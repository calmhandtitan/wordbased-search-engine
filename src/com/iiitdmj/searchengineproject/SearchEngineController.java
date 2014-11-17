package com.iiitdmj.searchengineproject;

public class SearchEngineController {

	
	static CrawlerService crawler ;
	static SearchQueryForm search_form ;
	static SearchIndexAccessManager index_manager = new SearchIndexAccessManager();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		search_form  = new SearchQueryForm(index_manager.getInstance().getIndex());
		
		Thread formT = new Thread(search_form);
		formT.run();
		
		crawler = new CrawlerService();
		crawler.prepareService();
		crawler.attachIndexDatabase(index_manager.getInstance().getIndex());
		crawler.execute();
		

	}

}

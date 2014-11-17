package com.iiitdmj.searchengineproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class CrawlerService implements Runnable {

	private LinkedBlockingQueue<UrlJob> scrapeQ;
	private LinkedBlockingQueue<UrlJob> filterQ;
	private LinkedBlockingQueue<UrlJob> indexQ;
	private List<String> seeds;
	public IndexMap indexMap;
	private String SEED_URL = "http://www.iiitdmj.ac.in";
	private static int SCRAPE_THREAD_COUNT = 1;
	private static int FILTER_THREAD_COUNT = 1;
	private static int INDEX_THREAD_COUNT = 1;
	public CrawlerService crawler_service;
	public static UrlExtractor scraper;
	public static Filterer filterer;
	public static Indexer indexer;
	
	
	public CrawlerService(){
		
		seeds = new ArrayList<String>();
		seeds.add(SEED_URL);
		
		//indexMap = new IndexMap();
	
		
	}
	
	public void prepareService()
	{
	crawler_service = new CrawlerService();
		
	}
	
	
	public void attachIndexDatabase(IndexMap im) {
		
		indexMap = im;
		System.out.println("heelo there " + indexMap.toString());
		scrapeQ = new LinkedBlockingQueue<UrlJob>();
		filterQ = new LinkedBlockingQueue<UrlJob>();
		indexQ = new LinkedBlockingQueue<UrlJob>();
		 scraper = new UrlExtractor(scrapeQ, filterQ);
		 filterer = new Filterer(filterQ, scrapeQ, indexQ);
		 indexer = new Indexer(indexQ, indexMap);
		
		
	}
	
	

	
	
	
	public void execute(){
		
		for (int i = 0; i<SCRAPE_THREAD_COUNT; i++){
			Thread scraperT = new Thread(scraper);
			scraperT.setName("Scraper " + i);
			scraperT.start();
		}
		
		for (int i = 0; i< FILTER_THREAD_COUNT; i++){
			Thread filterT = new Thread(filterer);
			filterT.setName("Filterer " + i);
			filterT.start();
		}
		
		for (int i = 0; i<INDEX_THREAD_COUNT; i++){
			Thread indexT = new Thread(indexer);
			indexT.setName("Indexer " + i);
			indexT.start();
		}

		for (String url : seeds){
			try {
				scrapeQ.put(new UrlJob(url));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	/*
	public static void main(String[] args){
		CrawlerService crawl = new CrawlerService();
		crawl.setSeed("http://web.iiitdmj.ac.in");
		crawl.getSeed();
		crawl.execute();
	}
	*/
	@Override
	public void run() {
		
		crawler_service.execute();
		// TODO Auto-generated method stub
		
	}
	
}

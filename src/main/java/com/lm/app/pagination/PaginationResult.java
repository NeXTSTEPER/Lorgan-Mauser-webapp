package com.lm.app.pagination;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

// Class to handle pagination of query results.
public class PaginationResult<E> {
	   
   // Total number of records in the result set
   private int totalRecords;
   
   // Current page number in the result set
   private int currentPage;
   
   // List of records for the current page
   private List<E> list;
   
   // Maximum number of records per page
   private int maxResult;
   
   // Total number of pages in the result set
   private int totalPages;
 
   // Maximum number of navigation pages to be displayed
   private int maxNavigationPage;
 
   // List of page numbers for navigation
   private List<Integer> navigationPages;
 
   // Constructor to initialize and calculate pagination details
   public PaginationResult(Query<E> query, int page, int maxResult, int maxNavigationPage) {
      // Calculate page index based on page number
      final int pageIndex = page - 1 < 0 ? 0 : page - 1;
 
      // Calculate record index for current page
      int fromRecordIndex = pageIndex * maxResult;
      int maxRecordIndex = fromRecordIndex + maxResult;
 
      // ScrollableResults instance to scroll through query results
      ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
 
      // List to hold query results for current page
      List<E> results = new ArrayList<>();
 
      boolean hasResult = resultScroll.first();
 
      // Check if there are query results
      if (hasResult) {
         // Scroll to first record of current page
         hasResult = resultScroll.scroll(fromRecordIndex);
 
         // Loop through results for current page
         if (hasResult) {
            do {
               // Add each result to list
               E record = (E) resultScroll.get(0);
               results.add(record);
            } while (resultScroll.next() // loop condition
                  && resultScroll.getRowNumber() >= fromRecordIndex
                  && resultScroll.getRowNumber() < maxRecordIndex);
 
         }
 
         // Scroll to last record of result set
         resultScroll.last();
      }
 
      // Calculate total number of records
      this.totalRecords = resultScroll.getRowNumber() + 1;
      this.currentPage = pageIndex + 1;
      this.list = results;
      this.maxResult = maxResult;
 
      // Calculate total number of pages
      if (this.totalRecords % this.maxResult == 0) {
         this.totalPages = this.totalRecords / this.maxResult;
      } else {
         this.totalPages = (this.totalRecords / this.maxResult) + 1;
      }
 
      this.maxNavigationPage = maxNavigationPage;
 
      if (maxNavigationPage < totalPages) {
         this.maxNavigationPage = maxNavigationPage;
      }
 
      // Calculate navigation pages
      this.calcNavigationPages();
   }
 
   // Method to calculate navigation pages
   private void calcNavigationPages() {
 
      this.navigationPages = new ArrayList<Integer>();
 
      int current = this.currentPage > this.totalPages ? this.totalPages : this.currentPage;
 
      int begin = current - this.maxNavigationPage / 2;
      int end = current + this.maxNavigationPage / 2;
 
      // Adding first page to navigation
      navigationPages.add(1);
      if (begin > 2) {
         // Using for '...'
         navigationPages.add(-1);
      }
 
      for (int i = begin; i < end; i++) {
         if (i > 1 && i < this.totalPages) {
            navigationPages.add(i);
         }
      }
 
      if (end < this.totalPages - 2) {
         // Using for '...'
         navigationPages.add(-1);
      }
      // Adding last page to navigation
      navigationPages.add(this.totalPages);
   }
 
   // Getters for total pages, total records, current page, result list, max result per page, and navigation pages.
   public int getTotalPages() {
      return totalPages;
   }
 
   public int getTotalRecords() {
      return totalRecords;
   }
 
   public int getCurrentPage() {
      return currentPage;
   }
 
   public List<E> getList() {
      return list;
   }
 
   public int getMaxResult() {
      return maxResult;
   }
 
   public List<Integer> getNavigationPages() {
      return navigationPages;
   }
}

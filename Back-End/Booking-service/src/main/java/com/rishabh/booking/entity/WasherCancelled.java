/*
 * package com.rishabh.booking.entity;
 * 
 * import org.springframework.data.annotation.Id; import
 * org.springframework.data.mongodb.core.mapping.DBRef; import
 * org.springframework.data.mongodb.core.mapping.Document;
 * 
 * @Document(collection = "WasherCancelled") public class WasherCancelled {
 * 
 * @Id private String id; private String washerUserName; private Boolean
 * isCancelledByWasher;
 * 
 * @DBRef private BookNow bookNow; public String getId() { return id; } public
 * void setId(String id) { this.id = id; } public String getWasherUserName() {
 * return washerUserName; } public void setWasherUserName(String washerUserName)
 * { this.washerUserName = washerUserName; } public Boolean
 * getIsCancelledByWasher() { return isCancelledByWasher; } public void
 * setIsCancelledByWasher(Boolean isCancelledByWasher) {
 * this.isCancelledByWasher = isCancelledByWasher; } public BookNow getBookNow()
 * { return bookNow; } public void setBookNow(BookNow bookNow) { this.bookNow =
 * bookNow; } public WasherCancelled(String id, String washerUserName, Boolean
 * isCancelledByWasher, BookNow bookNow) { super(); this.id = id;
 * this.washerUserName = washerUserName; this.isCancelledByWasher =
 * isCancelledByWasher; this.bookNow = bookNow; } public WasherCancelled(String
 * washerUserName, Boolean isCancelledByWasher, BookNow bookNow) { super();
 * this.washerUserName = washerUserName; this.isCancelledByWasher =
 * isCancelledByWasher; this.bookNow = bookNow; } public WasherCancelled() {
 * super(); }
 * 
 * 
 * 
 * 
 * 
 * }
 */
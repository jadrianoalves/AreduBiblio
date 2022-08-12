package com.aredu.biblio.models;



    public class BookCode{
        private String bookCode;
        private int numberOfCopy;

        public BookCode() {
        }

        public BookCode(String bookCode, int numberOfCopy) {

            this.bookCode = bookCode;
            this.numberOfCopy = numberOfCopy;
        }



        public int getNumberOfCopy(){
            return this.numberOfCopy;
        }

        public String getBookCode(){
            return this.bookCode;
        }

        public void setNumberOfCopy(int numberOfCopy) {
            this.numberOfCopy = numberOfCopy;
        }
        public void setBookCode(String bookCode) {
            this.bookCode = bookCode;
        }




    }



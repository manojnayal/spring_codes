package com.example.java8;

interface MyInterface11{
	void service(int i, String str, double d); // should dispay all the details
}
interface MyInterface22{
	double computeTax(double salary, double taxPer); // return tax
}
//(salary+salary*tax/100)
interface MyInterface33{
	void dummyFunction();// prints hello world
}
interface MyInterface444{
	double dummyFunction2();// should return  a random value
}
interface MyInterface5{
	double dummyFunction2(int x);// should return  a random value
}

class Sample{
	public static void main(String[] args) {
		
		MyInterface11 myInterface11 = (a,b,c)->System.out.println("integer "+a+" String "+ b+ " double "+c);
		MyInterface5 t2= (a)-> a*Math.random();
		MyInterface444 t1= ()-> Math.random();
		
	}
}
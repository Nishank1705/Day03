import java.util.*;
class Movie{
    String title;
    String director;
    int year;
    int rating;
    Movie next;
    Movie prev;
    public Movie(String title,String director,int year,int rating){
        this.title=title;
        this.director=director;
        this.year=year;
        this.rating=rating;
        next=null;
        prev=null;
    }
}



public class MovieManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Movie m1=new Movie("3 Idiots", "Rajkumar Hirani", 2009, 5);
        Movie m2=new Movie("Dangal", "Nitesh Tiwari", 2016, 4);
        Movie m3=new Movie("Lagaan", "Ashutosh Gowariker", 2001, 4);
        Movie m4=new Movie("Taare Zameen Par", "Aamir Khan", 2007, 5);
        Movie m5=new Movie("PK", "Rajkumar Hirani", 2014, 4);
        Movie m6=new Movie("Ghajini", "A.R. Murugadoss", 2008, 3);
        Movie m7=new Movie("Dhoom 3", "Vijay Krishna Acharya", 2013, 3);
        m1.next=m2;
        m2.next=m3; m3.next=m4; m4.next=m5;m5.next=m6; m6.next=m7;
        m7.prev=m6; m6.prev=m5; m5.prev=m4; m4.prev=m3; m3.prev=m2; m2.prev=m1;
        System.out.println("displayng the details of all the movies:- ");
        Movie temp=m1;
        int i=1;
        while(temp!=null){
            System.out.println("Title of the "+i+"st movie is "+ temp.title);
            System.out.println("Director of the "+i+"st movie is "+ temp.director);
            System.out.println("Year of Release of the "+i+"st movie is "+ temp.year);
            System.out.println("Rating of the "+i+"st movie is "+ temp.rating);
            i++;
          temp=temp.next;
          System.out.println();
        }
        System.out.print("enter director to show the details of specific movie: ");
        String dir=sc.nextLine();
        temp=m1;
        int a=0;
        while(temp!=null){
            if(temp.director.equals(dir)){
                System.out.println("Title of the movie is "+ temp.title);
                System.out.println("Director of the movie is "+ temp.director);
                System.out.println("Year of Release of the movie is "+ temp.year);
                System.out.println("Rating of the movie is "+ temp.rating);
                a=1;
    }
    temp=temp.next;
    
}       if(a==0){
            System.out.println("movie with director "+ dir +" is not present");
        }
        System.out.println();
        System.out.print("enter movie title to remove the movie: ");
        String title=sc.nextLine();
        temp=m1;
        a=0;
        while(temp!=null){
            if(temp.title.equals(title)){
                if(temp.prev==null){
                    m1=temp.next;
                    m1.prev=null;
                }
                else if(temp.next==null){
                    temp.prev.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                a=1;
                break;
            }
            temp=temp.next;
        }
        if(a==0){
            System.out.println("movie with title "+ title +" is not present");
        }
        else{
            System.out.println("movie with title "+ title +" is removed");
        }
        
    }
}
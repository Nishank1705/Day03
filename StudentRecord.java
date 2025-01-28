import java.util.*;
class Student{
    String name;
    int rollno;
    int age;
    char grade;
    Student next;
    public Student(String name,int age,int rollno,char grade){
        this.name=name;
        this.age=age;
        this.rollno=rollno;
        this.grade=grade;
        next=null;
    }

}


public class StudentRecord{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student s1=new Student("Ram", 10, 101, 'A');
        Student s2=new Student("Shyam", 31, 102, 'A');
        Student s3=new Student("Aman", 35, 103, 'A');
        Student s4=new Student("Baman", 27, 104, 'C');
        Student s5=new Student("ramesh", 21, 105, 'B');
        Student s6=new Student("Suresh", 21, 106, 'C');
        Student s7=new Student("Neer", 21, 107, 'A');
        s1.next=s2;
        s2.next=s3; s3.next=s4; s4.next=s5;s5.next=s6; s6.next=s7;
        System.out.println("displayng the details of all the student:- ");
        Student temp=s1;
        int i=1;
        while(temp!=null){
            System.out.println("name of the "+i+"number  student is "+ temp.name);
            System.out.println("age of the "+i+" number student is "+ temp.age);
            System.out.println("rollno. of the "+i+" number student is "+ temp.rollno);
            System.out.println("grade of the "+i+" number student is "+ temp.grade);
            i++;
            temp=temp.next;
            System.out.println();
        }
        System.out.print("enter roll no. to show the details of specific student: ");
        int roll=sc.nextInt();

        temp=s1;
        int a=0;
        while(temp!=null){
            if(temp.rollno == roll){
                System.out.println("name of the "+" student is "+ temp.name);
                System.out.println("age of the "+" student is "+ temp.age);
                System.out.println("grade of the "+" student is "+ temp.grade);
                a=1;
                break;
            }
            temp=temp.next;
        }
        if(a==0){
            System.out.println("student with rollno "+ roll +" is not present");
        }

    }

}
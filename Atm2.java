import java.util.*;


class Atm2{
    static int amount[] = {0,0,0,0};
    static int amountnum[] = {2000,500,200,100};
    static String name[] = {"R","D"};
    static String pass[] = {"123","1"};
    static int account[] = {10000,30000};
    static int amt,total;
    static int count=0;
    static int j=0;
    static int arr[] = new int[10];
    static int a,b,c,d,e,f,g,h;
    private static Scanner sc;

    static void add_amount(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Enter number of "+amountnum[i]+" is ");
            amount[i]+=sc.nextInt();
            System.out.print("\033[H\033[2J");
        }
        System.out.println("Amount added Successfully");
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            adminfunc();
        }catch(Exception e){
        }
    }

    static void show_amount(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Number of notes in "+amountnum[i]+" is "+amount[i]);
            total += amountnum[i]*amount[i];
        }
        System.out.println("Total amount added "+total);
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            adminfunc();
        }catch(Exception e){
        }
    }

    static void withdraw_amount(int i){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter the amount");
        amt = sc.nextInt();
        total-=amt;
        // moneytwo(amt);
        with(amt);
        if(amt%100==0){
            account[i]-=amt;
            trans(amt);
            System.out.println("Amount Withdraw Successfully");
            System.out.println();
            System.out.println("Please press enter for previous menu");
            try{
                System.in.read();
                userfunc(i);
            }catch(Exception e){
            }
        }else{
            System.out.println("Invalid Input");
            System.out.println();
            System.out.println("Please press enter for previous menu");
            try{
                System.in.read();
                userfunc(i);
            }catch(Exception e){
            }
        }
    }

    static void trans(int n){
        arr[j]=n;
        j++;
    }

    static void transac(int n){
        System.out.print("\033[H\033[2J");
        for(int i=j-1;i>=j-5;i--){
            if(arr[i]!=0){
                System.out.println("The amount withdrawl is "+arr[i]);
            }
        }
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            userfunc(n);
        }catch(Exception e){
        }
    }

    static void show_balance(int i){
        System.out.print("\033[H\033[2J");
        System.out.println("Your account balance is "+account[i]);
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            userfunc(i);
        }catch(Exception e){
        }
    }

    static void adminfunc(){
        System.out.print("\033[H\033[2J");
        System.out.println("1. Add Amount");
        System.out.println("2. Show Amount");
        System.out.println("3. Back");
        int ch1=sc.nextInt();
        switch(ch1){
            case 1:
                add_amount();
            break;
            case 2:
                show_amount();
            break;
            case 3:
                mainfunc();
            break;
            default:
                System.out.println("Invalid choice");
            break;
        }
    }

    static void userfunc(int i){
        System.out.print("\033[H\033[2J");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Account Balance");
        System.out.println("3. Trancsation");
        System.out.println("4. Pin change");
        System.out.println("5. Back");
        int ch1=sc.nextInt();
        switch(ch1){
            case 1:
                withdraw_amount(i);
            break;
            case 2:
                show_balance(i);
            break;
            case 3:
                transac(i);
            break;
            case 4:
                pinchange(i);
            break;
            case 5:
                mainfunc();
            default:
                System.out.println("Invalid choice");
            break;
        }
    }

    static void adminlogin(){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Admin Id");
        sc.nextLine();
        String adminid = sc.nextLine();
        System.out.print("\033[H\033[2J");
        if(adminid.equals("A")){
            System.out.println("Enter Password");
            String adminpass = sc.nextLine();
            if(adminpass.equals("1")){
                adminfunc();
            }else{
                System.out.println("Invalid password");
            }
        }
        else{
            System.out.println("Invalid admin id");
        }
    }

    static void userlogin(){
        System.out.print("\033[H\033[2J");
        if(count<9){
            System.out.print("\033[H\033[2J");
            count++;
            System.out.println("Enter Username");
            sc.nextLine();
            String username = sc.nextLine();
            System.out.print("\033[H\033[2J");
            if(username.equals(name[0])){
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if(userpass.equals(pass[0])){
                    userfunc(0);
                }else{
                    System.out.println("Invalid password");
                }
            }else if(username.equals(name[1])){
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if(userpass.equals(pass[1])){
                    userfunc(1);
                }else{
                    System.out.println("Invalid password");
                }
            }
            else{
                System.out.println("Invalid Username");
            }
        }else{
            System.out.println("Login Attempt Exceeded");
        }
    }

    static void mainfunc(){
        System.out.print("\033[H\033[2J");
        int ch=0;
        System.out.println("ATM MACHINE");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
        ch = sc.nextInt();
        switch(ch){
            case 1:
                adminlogin();
            break;
            case 2:
                userlogin();
            break;
            case 3:
                System.exit(0);
            break;
            default:
                System.out.println("Invalid Input");
            break;
        }
    }

    static void pinchange(int i){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Old Password");
        String oldpass = sc.next();
        if(pass[i].equals(oldpass)){
            System.out.print("\033[H\033[2J");
            System.out.println("Enter new password");
            String newpass = sc.next();
            pass[i]=newpass;
            System.out.println("Password Changed");
        }else{
            System.out.println("Password incorrect");
        }
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            userfunc(i);
        }catch(Exception e){
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        mainfunc();
    }

    static void with(int n){
        // n=6500

        for(int i=0;i<amount.length;i++){
            if(n>=amountnum[i]){
                int temp = Math.abs(amount[i] - (n/amountnum[i]));
                // System.out.println(temp);
                int rec = Math.abs(temp - (n/amountnum[i]));
                int mul = rec*amountnum[i];
                n -=mul;
                amount[i]-=rec;
            }
        }
    }
}

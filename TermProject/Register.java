package TermProject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Info{
   private String name;
   private String birth;
   private String product;
   private String start_date;  // 보험 가입 날짜 (=보험 시작하는 날짜 ) <- 사용자로부터 입력받아서 저장     //나중에 보험 해지가 가능한지 여부 판단할 때 달력에서 현재 날짜 불러와서 비교
   private double duration; // 보험 유효 기간  - 보험 회사 마다 다르게 설정 - 보험을 보장받는 기간 (납입기간과 다름)
   private double pay_duration; // 보험 납입 기간 (보험료를 납입하는 기간/ 예를 들어 납입기간이 10년, 보험기간이 20년일 경우 보험료는 10년 동안만 내고 20년 동안 보장 받음) 
   private String due_date;  // 보험 만료 날짜 ( 보험 가입 날짜 + duration = 보험 만료 날짜 )
   static private int numberOfCustomer=0; // 총 등록된 고객 수 (한명이 신규등록할 때마다 1증가)
   private double total_insurance_pay;  // 총 보험료 (나이에 따라, 현재까지 사고 경험 유무에 따라 차등 설정)
   private double fee;
   /* 고객 이름 리턴 함수 */
   public String getname() {
      return name;
   }
   /* 고객 생년월일 리턴 함수 */
   public String getbirth() {
      return birth;
   }
   /* 신규 고객이 한명 추가될 때마다 전체 고객 수 1증가  */
   static public void addgetNumber() {
      numberOfCustomer++;
   }
   /* 전체 등록된 고객 수 리턴 */
   static public int getNumber() {      // 고객 수 리턴 get
      return numberOfCustomer;
   }
   /* name, birth setter  */
   public void setBasicInfo(String name, String birth) {   // 이름/생년월일 set
      this.name = name;
      this.birth = birth;
   }
   /* product setter */
   public void setProduct(String product) {
      this.product = product;
   }
   /* start_date setter */
   public void setStartDate(String start_date) {
      this.start_date = start_date;
   }
   /* duration setter */
   public void setDuration(double duration) {
      this.duration = duration;
   }
   /* pay_duration setter */
   public void setPayDuration(double pay_duration) {
      this.pay_duration = pay_duration;
   }
  
   /* due_date setter */
   public void setDueDate() {
      /* String 으로 입력받은 start_date를 정수로 바꾼 뒤 + duration 해서 년/월/일 로 due_date 계산해서 값 설정하기 */
   }
   
}

class Age{
   private static double ageValue=0;
   public static double byAge(int age) {
      // 계산식에 들어가는 알파 값을 나이별로 다르게 정해서 리턴 
      switch(age/10) {
      case 2: {  // 20대
         if(age < 25 ) {
            ageValue = 0.4;
            return ageValue;
         }
         else if( age >= 25 ) {
            ageValue = 0.35;
            return ageValue;
         }
         break;
      }
      case 3: {   // 30대
         if(age < 35 ) {
            ageValue = 0.35;
            return ageValue;
         }
         else if( age >= 35 ) {
            ageValue = 0.3;
            return ageValue;
         }
         break;
      }
      case 4: {
         if(age < 45 ) {
            ageValue = 0.25;
            return ageValue;
         }
         else if( age >= 45 ) {
            ageValue = 0.25;
            return ageValue;
         }// 40대
         break;
      }
      case 5: {
         if(age < 55 ) {
            ageValue = 0.3;
            return ageValue;
         }
         else if( age >= 55 ) {
            ageValue = 0.35;
            return ageValue;
         }// 50대
         break;
      }
      case 6: {
         if(age < 65 ) {
            ageValue = 0.35;
            return ageValue;
         }
         else if( age >= 65 ) {
            ageValue = 0.4;
            return ageValue;
         }// 60대
         break;
      }
      case 7:    // 그 이상
      default:{
         if(age < 75 ) {
            ageValue = 0.4;
            return ageValue;
         }
         else if( age >= 75 ) {
            ageValue = 0.5;
            return ageValue;
         }
         break;
      }
      }
      
      return 0;
      
   }
   
}
class Accident{
	private static double weight;
	public static double byAccident(boolean accident) { // 사고 유무 있을 경우 가중치 
		if(accident==true) {
			weight= 0.3;
			return weight;
		}
		else if(accident!=true) {
			weight =0;
			return weight;
		}
		return 0;
	}
}
class Product{
   private int age;  // 사용자 나이
   private boolean accident; // 사고 유무
   private double fee;
   int base;
   double ageAlpha;// = Age.byAge(age);
   double weightVal;
   public void setAge(int age) {
      this.age = age;
      ageAlpha=Age.byAge(this.age);
   }
   
   public void setAccident(boolean accident) {
      this.accident = accident;
      weightVal = Accident.byAccident(this.accident);
   }
   public void setFee(double fee)
   {
	   this.fee = fee;
   }
   public double getFee()
   {
	   return fee;
   }
  
   public void calculate() {
      //double ageAlpha = Age.byAge(age);
      //double weight;
      //double fee=0; //고객별로 산정된 보험금액
       //각 회사의 기본 보험금액
      
   }
   /* 오버라이딩 */
   public void set(Info person) {
      
   }
   
}

/* 현대해상 보험 회사 */
class Hyundai extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public Hyundai(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("Hyundai");
      person.setPayDuration(10);   // 임의로 정함
      person.setDuration(20);   // 임의로 정함
   }
   public void calculate()
   {
	   int base = 11000;
	   double fee = base + base*ageAlpha+ base*weightVal;
	   System.out.println();
	   System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
	   setFee(fee);
	   System.out.println("===========================================");
	   System.out.println();
   }
   
   
}
/* 삼성화재 보험 회사 */
class Samsung extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public Samsung(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("Samsung");
      person.setPayDuration(10);   
      person.setDuration(20);   
   }
   public void calculate() {
      int base = 12000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* DB손해보험 보험 회사 */
class DB extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public DB(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("DB");
      person.setPayDuration(5);   
      person.setDuration(15);  
   }
   public void calculate() {
      int base = 10000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* 메리츠화재 보험 회사 */
class Meritz extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public Meritz(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("Meritz");
      person.setPayDuration(5);   
      person.setDuration(10);  
   }
   public void calculate() {
      int base = 13000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* KB손해보험 보험 회사 */
class KB extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public KB(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("KB");
      person.setPayDuration(5);   
      person.setDuration(10);   
   }
   public void calculate() {
      int base = 14000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* AXA손해보험 보험 회사 */
class AXA extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public AXA(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("AXA");
      person.setPayDuration(15);   
      person.setDuration(20);   
   }
   public void calculate() {
      int base = 16000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* 한화손해보험 보험 회사 */
class Hanwha extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public Hanwha(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("Hanwha");
      person.setPayDuration(10);   
      person.setDuration(15);   
   }
   public void calculate() {
      int base = 12000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}
/* NH농협손해보험 보험 회사 */
class NH extends Product{
   
   /* 생성자 - 나이, 사고유무 set */
   public NH(int age, boolean accident) {
      super.setAge(age);
      super.setAccident(accident);
   }
   @Override
   public void set(Info person) {
      person.setProduct("NH");
      person.setPayDuration(15);   
      person.setDuration(25);   
   }
   public void calculate() {
      int base = 11000;
      double fee = base + base*ageAlpha+ base*weightVal;
      System.out.println();
      System.out.println("고객님의 보험 납입액은 "+fee+"원 으로 산정되었습니다.");
      setFee(fee);
      System.out.println("===========================================");
      System.out.println();
   }
   
}


/* 메인 클래스 */
public class Register {
   static ArrayList <Info> user = new ArrayList<>(100);    
   /* 전체 리스트에 고객 정보 저장 */
   public static void store_info(Info person) {
      user.add(person);
      Info.addgetNumber();
   }

   /* 기존에 이미 등록되있는 고객인지 확인 */
   public static int searchUser(Info search) {   
      int count = Info.getNumber();
      int i;
      for(i=0; i<count; i++) {
         if(search.getname().equals(user.get(i).getname()) && search.getbirth().equals(user.get(i).getbirth())) return -1;
      }
      if(i==count) return 0;
      return 0;
   }
   

   public static void register () {
      Scanner keyboard = new Scanner(System.in);
      PrintWriter outputStream  = null;
      try {
    	  outputStream = new PrintWriter(new FileOutputStream("Person.txt", true));
      }
      catch(FileNotFoundException e)
      {
    	  System.exit(0);
      }
      Loop1:
      for(;;)
      {
         System.out.print("고객님의 성함을 입력해주세요 : ");
         String name = keyboard.nextLine();
         System.out.println("고객님의 생년월일을 입력해주세요 (yyyy/mm/dd) : ");
         String birth = keyboard.nextLine();

         Info person = new Info();
         
         person.setBasicInfo(name, birth);
         System.out.println("고객님의 정보가 입력되었습니다. 잠시만 기다려주세요...\n");

         /* 고객이 이미 등록되어있는 경우 */
         if(searchUser(person)==-1) {
            System.out.println("이미 등록하신 고객입니다.");
            System.out.println("< 1. 현재 내 정보 확인 >\t<2. 보험 해지>\t<3. 종료>");
            System.out.print("=> ");
            int select = keyboard.nextInt();
            if(select==1) {

            }
            else if(select == 2) {

            }
            else {
               System.out.println("프로그램이 종료되었습니다. 저희 서비스센터를 방문해주셔서 감사합니다.");
               break Loop1;
            }
         } /* 고객이 이미 등록되지 않은, 신규고객일 경우 */
         else {
            System.out.println("*** 환영합니다 " + person.getname()+"님! 운전자 보험 가입을 하시겠습니까? ***");
            System.out.print("(네/아니오)로 입력바랍니다. => ");
            String want = keyboard.nextLine();

            if(want.equals("네")) {
               store_info(person);
               int productchoice;
               try {
            	  System.out.println();
                  System.out.println("1. 현대해상 2. 삼성화재 3. DB손해보험 4. 메리츠화재 5. KB손해보험 6. AXA손해보험 7. 한화손해보험 8. NH농협손해보험");
                  System.out.print("=> ");
                  productchoice = keyboard.nextInt();
                  if(productchoice > 8) throw new Exception("존재하지 않는 상품입니다!! 번호를 다시 입력해주시기 바랍니다.");
               }catch(Exception e) {
                  System.out.println(e); 
                  System.out.println("1. 현대해상 2. 삼성화재 3. DB손해보험 4. 메리츠화재 5. KB손해보험 6. AXA손해보험 7. 한화손해보험 8. NH농협손해보험");
                  System.out.print("=> ");
                  productchoice = keyboard.nextInt();
                  if(productchoice > 8) {
                  System.out.println("존재하지 않는 상품입니다!! 프로그램이 종료되었습니다.");
                  break Loop1;
                  }
               }
               
               Product user= new Product();

               System.out.print("나이를 입력해주세요 : ");
               int age = keyboard.nextInt();
               user.setAge(age);
                           
               System.out.print("사고 유무가 있으신가요? (Y/N) : ");
               boolean acc=false;
               String accident = keyboard.next();
               if(accident.equals("Y")) acc = true;
               else acc = false;
               user.setAccident(acc);
               keyboard.nextLine();
               System.out.println("보험금 납입을 시작할 날짜를 입력해주세요 (yyyy-mm-dd) : ");
               String start_date = keyboard.nextLine();
               person.setStartDate(start_date);
               
               System.out.println("고객님의 정보가 입력되었습니다. 결과를 산출 중이니 잠시만 기다려주세요.. ");
               Product newUser = null;
               
               switch(productchoice) {
               case 1:{

                  newUser = new Hyundai(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 2:{
                  newUser = new Samsung(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 3: {
                  newUser = new DB(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 4: {
                  newUser = new Meritz(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 5: {
                  newUser = new KB(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 6:{
                  newUser = new AXA(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 7:{
                  newUser = new Hanwha(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               case 8: {
                  newUser = new NH(age, acc);
                  newUser.set(person);
                  newUser.calculate();
                  break;
               }
               
               }
               
               outputStream.print(person.getname()+ " ");
               outputStream.print(age + " ");
               outputStream.print(acc + " ");
               outputStream.print(start_date + " ");
               outputStream.print(newUser.getFee() + " ");
               outputStream.println();
               outputStream.close();
               break;
               
         }else {
            System.out.println("감사합니다 고객님. 아쉽지만 다음에 또 뵙겠습니다");
            break;
         }
            
            
      }
      
   }
   }
}

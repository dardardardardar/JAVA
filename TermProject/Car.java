package TermProject;

import java.util.Scanner;

public class Car{

   private static String fuel;

   public static void setFuel(int key) {
      switch (key) {
      case 1: fuel = "Gasolin";
      break;
      case 2: fuel = "Electric";
      break;
      default : {System.out.println("잘못 입력하셨습니다."); System.exit(0);} break;
      }
   }
   public static String getFuel() {
      return fuel;
   }

   public static void car() {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("원하시는 차의 연료를 선택해주세요");
      System.out.print("1.Gasolin  2.Electric  =>  ");
      int fuel = keyboard.nextInt();
      setFuel(fuel);
      System.out.println(getFuel() + "을 선택하셨습니다!");
      System.out.println();
      System.out.print("1. 국산차  2. 외제차  =>  ");
      int country = keyboard.nextInt();
      if(country == 1) {
         Domestic car = null;
         System.out.println();
         System.out.println("차종 브랜드를 선택해주세요");
         if(getFuel().equals("Electric")) {
            System.out.print("1.Hyundai  2.Kia  => ");
            int brand = keyboard.nextInt();
            try {
               switch(brand) {
               case 1: car = new Electric_Hyundai(); break;
               case 2: car = new Electric_Kia(); break;
               default: throw new Error("없는 번호입니다");
               }
            }
            catch(Error e) {
               System.out.println(e+ " 다시 한번 입력바랍니다");
               System.out.print("1.Hyundai  2.Kia  => ");
               brand = keyboard.nextInt();
               switch(brand) {
               case 1: car = new Electric_Hyundai(); break;
               case 2: car = new Electric_Kia(); break;
               default: {System.out.println("프로그램이 종료되었습니다."); System.exit(0);} break;
               }
            }
         }
         else {
            System.out.print("1.Hyundai  2.Kia  3.Genesis  4.Chevrolet  => ");
            int brand = keyboard.nextInt();
            try {
               switch(brand) {
               case 1: car = new Hyundai_car(); break;
               case 2: car = new Kia(); break;
               case 3: car = new Genesis(); break;
               case 4: car = new Chevrolet(); break;
               default: throw new Error("없는 번호입니다");
               }
            }
            catch(Error e) {
               System.out.println(e+ " 다시 한번 입력바랍니다");
               System.out.print("1. Hyundai  2.Kia  3.Genesis  4.Chevrolet  => ");
               brand = keyboard.nextInt();
               switch(brand) {
               case 1: car = new Hyundai_car(); break;
               case 2: car = new Kia(); break;
               case 3: car = new Genesis(); break;
               case 4: car = new Chevrolet(); break;
               default: {System.out.println("프로그램이 종료되었습니다."); System.exit(0);} break;
               }
            }
         }
         
         car.selectModel();

      }
      else if(country == 2) {
         Foreign car = null;
         System.out.println();
         System.out.println("차종 브랜드를 선택해주세요");
         if(getFuel().equals("Electric")) {
            System.out.print("1.Tesla  2.Renault_Nissan  => ");
            int brand = keyboard.nextInt();
            try {
               switch(brand) {
               case 1: car = new Tesla(); break;
               case 2: car = new Renault_Nissan(); break;
               default: throw new Error("없는 번호입니다");
               }
            }
            catch(Error e) {
               System.out.println(e+ " 다시 한번 입력바랍니다");
               System.out.print("1.Tesla  2.Renault_Nissan  => ");
               brand = keyboard.nextInt();
               switch(brand) {
               case 1: car = new Tesla(); break;
               case 2: car = new Renault_Nissan(); break;
               default: {System.out.println("프로그램이 종료되었습니다."); System.exit(0);} break;
               }
            }

         }
         else {
            System.out.print("1.Benz  2.Bmw  3.Audi  4.Volkswagen  => ");
            int brand = keyboard.nextInt();
            try {
               switch(brand) {
               case 1: car = new Benz(); break;
               case 2: car = new Bmw(); break;
               case 3: car = new Audi(); break;
               case 4: car = new Volkswagen(); break;
               default: throw new Error("없는 번호입니다");
               }
            }
            catch(Error e) {
               System.out.println(e+ " 다시 한번 입력바랍니다");
               System.out.print("1.Benz  2.Bmw  3.Audi  4.Volkswagen  => ");
               brand = keyboard.nextInt();
               switch(brand) {
               case 1: car = new Benz(); break;
               case 2: car = new Bmw(); break;
               case 3: car = new Audi(); break;
               case 4: car = new Volkswagen(); break;
               default: {System.out.println("프로그램이 종료되었습니다."); System.exit(0);} break;
               }
            }
         }
         
         car.selectModel();

      }
      else {
         System.out.println("잘못 입력하셨습니다. 다시 입력해주시기 바랍니다.");
      }
      
   }

}


// 국산차
abstract class Domestic{
   final Scanner keyboard = new Scanner(System.in);
   abstract public void selectCarModel(int model);
   abstract public void selectModel();
}

// 국산차 - 전기차
class Electric_Hyundai extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      int car;
      switch(model) {
      case 1: {
         System.out.print("1.익스클루시브  2.프레스티지  =>  ");
         car = keyboard.nextInt();
         if( car == 1) System.out.println("해당 차량의 가격은 4,980만원입니다.");
         else if(car == 2) System.out.println("해당 차량의 가격은 5,455만원입니다.");
         else System.out.println("존재하지 않는 모델입니다.");
      }
      break;
      case 2:{
         System.out.print("1.프리미엄  2.르블랑  3.익스클루시브  4.캘리그래피  =>  ");
         car = keyboard.nextInt();
         switch(car) {
         case 1:  System.out.println("해당 차량의 가격은 3,679만원입니다."); break;
         case 2:  System.out.println("해당 차량의 가격은 3,900만원입니다."); break;
         case 3:  System.out.println("해당 차량의 가격은 4,012만원입니다."); break;
         case 4:  System.out.println("해당 차량의 가격은 4,489만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
      }
      break;
      case 3: {
         System.out.print("1.모던  2.프리미엄 플러스  3.인스퍼레이션  =>  ");
         car = keyboard.nextInt();
         if( car == 1) System.out.println("해당 차량의 가격은 2,881만원입니다.");
         else if(car == 2) System.out.println("해당 차량의 가격은 3,108만원입니다.");
         else if(car == 3) System.out.println("해당 차량의 가격은 3,635만원입니다");
         else System.out.println("존재하지 않는 모델입니다.");
      }
      break;
      case 4: {
         System.out.print("1.모던  2.프리미엄  3.인스퍼레이션  =>  ");
         car = keyboard.nextInt();
         if( car == 1) System.out.println("해당 차량의 가격은 2,857만원입니다.");
         else if(car == 2) System.out.println("해당 차량의 가격은 3,073만원입니다.");
         else if(car == 3) System.out.println("해당 차량의 가격은 3,467만원입니다");
         else System.out.println("존재하지 않는 모델입니다.");
      }
      break;
      default: System.out.println("존재하지 않는 모델입니다."); break;
      }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("현대 전기차를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.아이오닉 5  2.그랜저 하이브리드  3.쏘나타 하이브리드  4. 투싼 하이브리드  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
   
}
class Electric_Kia extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
      case 1: System.out.println("해당 차량의 가격은 4,187만원입니다."); break;
      case 2: System.out.println("해당 차량의 가격은 4,780 ~ 4,980만원입니다."); break;
      case 3: System.out.println("해당 차량의 가격은 4,950 ~ 7,200만원입니다."); break;
      default: System.out.println("존재하지 않는 모델입니다."); break;
      }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("기아 전기차를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.쏘울 EV 5  2.니로 EV  3.EV6  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}

// 국산차 - 디젤, 가솔린
class Hyundai_car extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 2,975 ~ 4,212만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 3,573 ~ 5,563만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 2,435 ~ 3,567만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("현대를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2020 싼타페  2.2020 팰리세이드 EV  3.2021 투싼  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}
class Kia extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 1,738 ~ 2,425만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 3,220 ~ 4,526만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 2,356 ~ 3,151만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("기아를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2022 k3  2.2021 k8  3.2021 k5  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}
class Genesis extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 15,609만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 5,291 ~ 6,214만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 6,067 ~ 6,951만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("제네시스를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 G90L  2.2020 G80  3.2020 GV80  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
}
class Chevrolet extends Domestic{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 1,885 ~ 2,333만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 5,450 ~ 5,529만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 2,364 ~ 3,338만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("쉐보레를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2022 쉐보레 트랙스  2.2021 쉐보레 카마로  3.2021 쉐보레 말리부  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}



// 외제차
abstract class Foreign{
   
   final Scanner keyboard = new Scanner(System.in);
   abstract public void selectCarModel(int model);
   abstract public void selectModel();
}

// 외제차 - 디젤, 가솔린
class Benz extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 14,060 ~ 21,860만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 21,760 ~ 24,560만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 7,621만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("벤츠를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 벤츠 S클래스  2.2021 벤츠 G클래스  3.2021 벤츠 GLA클래스 AMG  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}
class Bmw extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 12,270 ~ 13,170만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 12,170 ~ 13,070만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 12,630 ~ 16,940만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("BMW를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 BMW M4  2.2021 BMW M3  3.2021 BMW X7  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}
class Audi extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 25,569만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 14,696 ~ 19,400만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 13,696만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("아우디를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 아우디 R8  2.2021 아우디 A8L  3.2021 아우디 A8  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
}
class Volkswagen extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 2,949 ~ 3,285만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 8,275 ~ 9,659만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 5,324 ~ 6,113만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("폭스바겐을 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 폭스바겐 제타  2.2021 폭스바겐 투아렉  3.2020 폭스바겐 아테온  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
}

// 외제차 - 전기차
class Tesla extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 5,999 ~ 7,999만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 5,479 ~ 7,479만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 10,414 ~ 12,914만원입니다."); break;
         case 4: System.out.println("해당 차량의 가격은 11,599 ~ 13,599만원입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("테슬라를 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2021 테슬라 모델Y  2.2021 테슬라 모델3  3.2019 테슬라 모델S  4.2019 테슬라 모델X  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
   
}
class Renault_Nissan extends Foreign{
   @Override
   public void selectCarModel(int model) 
   {
      switch(model) {
         case 1: System.out.println("해당 차량의 가격은 4,190 ~ 4,830만원입니다."); break;
         case 2: System.out.println("해당 차량의 가격은 5,630만원입니다."); break;
         case 3: System.out.println("해당 차량의 가격은 40,000달러입니다."); break;
         default: System.out.println("존재하지 않는 모델입니다."); break;
         }
   }
   public void selectModel()
   {
      System.out.println();
      System.out.println("르노 닛산을 선택하셨군요! 모델을 선택해주세요");
      System.out.print("1.2019 닛산 리프  2.2017 닛산 무라노 하이브리드  3.2020 닛산 아리야  =>  ");
      int model = keyboard.nextInt();
      System.out.println();
      selectCarModel(model);
   }
}


